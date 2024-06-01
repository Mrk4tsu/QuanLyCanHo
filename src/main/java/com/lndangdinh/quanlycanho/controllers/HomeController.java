package com.lndangdinh.quanlycanho.controllers;

import com.lndangdinh.quanlycanho.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    @Autowired private RoomService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("rooms", service.getAll());
        return "index";
    }

}
