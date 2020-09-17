package cn.smbms.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));


//        binder.registerCustomEditor(Date.class,new PropertyEditorSupport(){
//            @Override
//            public String getAsText() {
//                return super.getAsText();
//            }
//
//            @Override
//            public void setAsText(String text) throws IllegalArgumentException {
//
//            }
//        });
    }


}
