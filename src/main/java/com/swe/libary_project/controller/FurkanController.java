package com.swe.libary_project.controller;

import com.swe.libary_project.entities.Furkan;
import com.swe.libary_project.services.FurkanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/furkan")
public class FurkanController {
    private final FurkanService furkanService;

    @GetMapping("")
    public String getAllFurkans(Model model){
        List<Furkan> furkans = furkanService.getAll();
        model.addAttribute("furkans", furkans);

        return "furkan";
    }
}
