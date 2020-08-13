package com.uiui881.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/main")
    public String mainPage(){
        return "mainPage";
    }

    @GetMapping("/playgrounds/save")
    public String playgroundsSave(){
        return "playgrounds-save";
    }
}
