package com.uiui881.springboot.web;

import com.uiui881.springboot.config.auth.LoginUser;
import com.uiui881.springboot.config.auth.dto.SessionUser;
import com.uiui881.springboot.service.managerInfos.ManagerInfosService;
import com.uiui881.springboot.service.playgrounds.PlaygroundsService;
import com.uiui881.springboot.service.rides.RidesService;
import com.uiui881.springboot.service.safety.SafetyService;
import com.uiui881.springboot.web.managerInfos.dto.ManagerInfosResponseDto;
import com.uiui881.springboot.web.playground.dto.PlaygroundsResponseDto;
import com.uiui881.springboot.web.rides.dto.RidesResponseDto;
import com.uiui881.springboot.web.safety.dto.SafetyResponseDto;
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

    private final RidesService ridesService;

    private final ManagerInfosService managerInfosService;

    private final SafetyService safetyService;

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

    @GetMapping("/rides/list")
    public String ridesList(Model model) {
        model.addAttribute("rides", ridesService.findAllDesc());
        return "rides-list";
    }

    @GetMapping("/rides/save")
    public String ridesSave(){
        return "rides-save";
    }

    @GetMapping("/rides/update/{id_r}")
    public String ridesUpdate(@PathVariable long id_r, Model model){
        RidesResponseDto dto = ridesService.findById(id_r);
        model.addAttribute("ride", dto);

        return "rides-update";
    }


    @GetMapping("/managerInfos/list")
    public String managerInfoList(Model model) {
        model.addAttribute("managerInfos", managerInfosService.findAllDesc());
        return "managerInfos-list";
    }

    @GetMapping("/managerInfos/save")
    public String managerInfoSave(){
        return "managerInfos-save";
    }

    @GetMapping("/managerInfos/update/{managerId}")
    public String managerInfoUpdate(@PathVariable long managerId, Model model){
        ManagerInfosResponseDto dto = managerInfosService.findById(managerId);
        model.addAttribute("managerInfo", dto);

        return "managerInfos-update";
    }

    @GetMapping("/safety/list")
    public String safetyList(Model model) {
        model.addAttribute("safety", safetyService.findAllDesc());
        return "safety-list";
    }

    @GetMapping("/safety/save")
    public String safetySave(){
        return "safety-save";
    }

    @GetMapping("/safety/update/{id_s}")
    public String safetyUpdate(@PathVariable long id_s, Model model){
        SafetyResponseDto dto = safetyService.findById(id_s);
        model.addAttribute("safety", dto);

        return "safety-update";
    }

}
