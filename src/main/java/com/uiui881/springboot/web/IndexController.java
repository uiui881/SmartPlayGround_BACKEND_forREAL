package com.uiui881.springboot.web;

import com.uiui881.springboot.config.auth.LoginUser;
import com.uiui881.springboot.config.auth.dto.SessionUser;
import com.uiui881.springboot.service.playgrounds.PlaygroundsService;
import com.uiui881.springboot.web.playground.dto.PlaygroundsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String index(Model model, @LoginUser SessionUser user){
        //model.addAttribute("playgrounds", playgroundsService.findAllDesc());
        if(user!=null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/playgrounds/list")
    public String playgroundsList(Model model) {
        model.addAttribute("playgrounds", playgroundsService.findAllDesc());
        return "playgrounds-list";
    }

    @GetMapping("/playgrounds/update/{playgroundId}")
    public String playgroundsUpdate(@PathVariable long playgroundId, Model model){
        PlaygroundsResponseDto dto = playgroundsService.findById(playgroundId);
        model.addAttribute("playground", dto);

        return "playgrounds-update";
    }
}
