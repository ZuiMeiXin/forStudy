package cn.smbms.controller;

import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.service.provider.ProviderServiceImpl;
import cn.smbms.tools.Constants;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    /*查询用户列表*/
    @RequestMapping("/providerlist.html")
    public String getProviderList(
            @RequestParam(value = "queryProName", defaultValue = "") String queryProName,
            @RequestParam(value = "queryProCode", defaultValue = "") String queryProCode,
            Model model
    ) {
        List<Provider> providerList = new ArrayList<Provider>();
        providerList = providerService.getProviderList(queryProName, queryProCode);
        model.addAttribute("providerList", providerList);
        model.addAttribute("queryProName", queryProName);
        model.addAttribute("queryProCode", queryProCode);
        return "providerlist";
    }

    @RequestMapping("/addprovider.html")
    public String addProvider(@ModelAttribute("provider") Provider provider) {
        return "provideradd";
    }

    @RequestMapping("/addproviderSave.html")
    public String addProviderSave(@Valid Provider provider,
                                  BindingResult result,
                                  HttpSession session,
                                  Model model,
                                  @RequestParam("p_idPicPath") MultipartFile multipartFile,
                                  @RequestParam("p_orgPicPath") MultipartFile orgFile
    ) {
        String savePath = null;
        if (!multipartFile.isEmpty()) {
            /*上传准备工作*/
            /*获取文件的原名和大小*/
            String oldName = multipartFile.getOriginalFilename();
            /*获取文件的后缀*/
            String ext = FilenameUtils.getExtension(oldName);
            long size = multipartFile.getSize();
            if (size > 500 * 1024) {
                model.addAttribute("upLoadFileError", "上传文件带下不得超过500K");
                return "provideradd";
            } else {
                String[] types = {"jpg", "rng", "png", "gif"};
                if (!Arrays.asList(types).contains(ext)) {
                    model.addAttribute("upLoadFileError", "上传文件格式不正确，格式为jpg,rng,png,gif");
                    return "provideradd";
                } else {
                    /*正式上传*/
                    String targetPath = session.getServletContext().getRealPath("statics" + File.separator + "upload");
                    /*修改上传文件名*/
                    String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Provider" + ext;
                    File saveFile = new File(targetPath, fileName);
                    if (!saveFile.exists()) {
                        saveFile.mkdirs();
                    }
                    /**/
                    try {
                        multipartFile.transferTo(saveFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                        model.addAttribute("upLoadFileError", "文件上传失败，联系管理员");
                        return "provideradd";
                    }
                    savePath = targetPath + File.separator + fileName;
                }

            }

        }


        String saveOrgPath = null;
        if (!orgFile.isEmpty()) {
            /*上传准备工作*/
            /*获取文件的原名和大小*/
            String oldName = orgFile.getOriginalFilename();
            /*获取文件的后缀*/
            String ext = FilenameUtils.getExtension(oldName);
            long size = orgFile.getSize();
            if (size > 500 * 1024) {
                model.addAttribute("upLoadOrgFileError", "上传文件带下不得超过500K");
                return "provideradd";
            } else {
                String[] types = {"jpg", "rng", "png", "gif"};
                if (!Arrays.asList(types).contains(ext)) {
                    model.addAttribute("upLoadOrgFileError", "上传文件格式不正确，格式为jpg,rng,png,gif");
                    return "provideradd";
                } else {
                    /*正式上传*/
                    String targetPath = session.getServletContext().getRealPath("statics" + File.separator + "upload");
                    /*修改上传文件名*/
                    String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_OrgCode" + ext;
                    File saveFile = new File(targetPath, fileName);
                    if (!saveFile.exists()) {
                        saveFile.mkdirs();
                    }
                    /**/
                    try {
                        orgFile.transferTo(saveFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                        model.addAttribute("upLoadOrgFileError", "文件上传失败，联系管理员");
                        return "provideradd";
                    }
                    saveOrgPath = targetPath + File.separator + fileName;
                }

            }

        }


            if (result.hasErrors()) {
                return "provideradd";
            }
            provider.setCreatedBy(((User) session.getAttribute(Constants.USER_SESSION)).getId());
            provider.setCreationDate(new Date());
            provider.setIdPicPath(savePath);
            provider.setOrgCodePicPath(saveOrgPath);
            boolean flag = false;
            flag = providerService.add(provider);
            if (flag) {
                return "redirect:/provider/providerlist.html";
            } else {
                return "provideradd";
            }

    }

    @RequestMapping("/tomodify.html")
    public String getProviderById(@RequestParam("proid") String id, Model model) {
        if (!StringUtils.isNullOrEmpty(id)) {
            Provider provider = null;
            provider = providerService.getProviderById(id);
            model.addAttribute("provider", provider);
            return "providermodify";
        } else {
            throw new RuntimeException("数据不能为空 未获取到providerid");
        }
    }

    @RequestMapping("/modifysave.html")
    public String modifySave(Provider provider, HttpServletRequest request) {
        provider.setModifyBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        provider.setModifyDate(new Date());
        boolean flag = false;
        flag = providerService.modify(provider);
        if (flag) {
            return "redirect:/provider/providerlist.html";
        } else {
            return "providermodify";
        }
    }


    @RequestMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) {
        if (!StringUtils.isNullOrEmpty(id)) {
            Provider provider = null;
            provider = providerService.getProviderById(id);
            model.addAttribute("provider", provider);
            return "providerview";
        } else {
            throw new RuntimeException("数据不能为空 未获取到providerid");
        }
    }

    /*,produces = "application/json;charset=utf-8" 可以解决json乱码问题*/
    @RequestMapping(value = "/view")
    @ResponseBody
    public String view(@RequestParam("id") String id) {
        if (!StringUtils.isNullOrEmpty(id)) {
            Provider provider = null;
            provider = providerService.getProviderById(id);
            return JSONArray.toJSONString(provider);
        } else {
            return "null";
        }
    }


    @RequestMapping("/delprovider")
    @ResponseBody
    public String delProvider(@RequestParam("proid") String id){
        HashMap<String, String> resultMap = new HashMap<String, String>();
        if(!StringUtils.isNullOrEmpty(id)){
            int flag = providerService.deleteProviderById(id);
            if(flag == 0){//删除成功
                resultMap.put("delResult", "true");
            }else if(flag == -1){//删除失败
                resultMap.put("delResult", "false");
            }else if(flag > 0){//该供应商下有订单，不能删除，返回订单数
                resultMap.put("delResult", String.valueOf(flag));
            }
        }else{
            resultMap.put("delResult", "notexit");
        }
        //把resultMap转换成json对象输出
        return JSONArray.toJSONString(resultMap);
    }



}
