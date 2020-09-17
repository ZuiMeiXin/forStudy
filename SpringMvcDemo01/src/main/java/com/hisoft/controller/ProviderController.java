package com.hisoft.controller;

import com.hisoft.entity.Provider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/provider")
public class ProviderController {
    private List<Provider> providers;

    @RequestMapping(value = "/showProvider.html")
    public String showProvider(Map map, Provider provider) {
        map.put("provider", provider);
        return "providerShow";
    }

    public ProviderController() {
        providers=new ArrayList<>();

    }
}
