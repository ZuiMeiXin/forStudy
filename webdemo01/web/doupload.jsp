<%@ page language="java" pageEncoding="UTF-8" %>
<%@page import="java.io.*,java.util.*" %>
<%@page import="org.apache.commons.fileupload.*" %>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory" %>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="java.lang.reflect.Array" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>上传处理页面</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String uploadFileName = ""; //上传的文件名
    String fieldName = "";  //表单字段元素的name属性值
    //请求信息中的内容是否是multipart类型
    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    //上传文件的存储路径（服务器文件系统上的绝对文件路径）
//	String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/" );
    String uploadFilePath = application.getRealPath("upload/");

    if (isMultipart) {
//		FileItemFactory factory = new DiskFileItemFactory();
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置缓冲区大小和临时目录
        factory.setSizeThreshold(1024 * 10);
        factory.setRepository(new File("F:\\test\\fileupload_temp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024 * 50);//设置上传文件的属性 设置大小只能是5kb
		try {
            //解析form表单中所有文件
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {   //依次处理每个文件
                FileItem item = iter.next();
                if (item.isFormField()) {  //普通表单字段
                    fieldName = item.getFieldName();   //表单字段的name属性值
                    if (fieldName.equals("user")) {
                        //输出表单字段的值
                        out.print(item.getString("UTF-8") + "上传了文件。<br/>");
                    }
                } else {  //文件表单字段
                    String fileName = item.getName();//上传文件名
                    String ext = fileName.substring(fileName.lastIndexOf(".") + 1);//从文件名最后一个.开始 截取后缀名
                    List<String> stringList = Arrays.asList("png", "jpg", "bmp");//将后缀名放到集合中
					//判断文件类型是不是要求的文件类型 如果不是就不会继续执行后面的上传操作
                    if (!stringList.contains(ext)) {
                        out.println("上传的文件类型不对 ，只能上传png，jpg，bmp文件");
                        return;
                    }
                    if (fileName != null && !fileName.equals("")) {
                        File fullFile = new File(fileName);
                        File saveFile = new File(uploadFilePath, fullFile.getName());
                        System.out.println(saveFile.getAbsolutePath());
                        item.write(saveFile);
                        //uploadFileName = fullFile.getName();
                        out.print("上传成功后的文件名是：" + fileName);
                    }
                }
            }
        } catch (FileUploadBase.SizeLimitExceededException e) {
			out.print("上传的最大文件限制是：" + upload.getSizeMax());
            e.printStackTrace();
        }
    }
%>
</body>
</html>