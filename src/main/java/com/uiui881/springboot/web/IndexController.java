package com.uiui881.springboot.web;

import com.uiui881.springboot.config.auth.dto.SessionUser;
import com.uiui881.springboot.service.playgrounds.PlaygroundsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PlaygroundsService playgroundsService;
    private final HttpSession httpSession;
    
    @GetMapping("/main")
    public String mainPage(){
        return "mainPage";
    }

    @GetMapping("/playgrounds/save")
    public String playgroundsSave(){
        return "playgrounds-save";
    }

    @GetMapping("/")
    public String index(Model model){
        //model.addAttribute("playgrounds", playgroundsService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user!=null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

}
