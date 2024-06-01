package com.lndangdinh.quanlycanho.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class PayMentController {
    @RequestMapping("/payment")
    public String payment() {
        return "payment/index";
    }
}
