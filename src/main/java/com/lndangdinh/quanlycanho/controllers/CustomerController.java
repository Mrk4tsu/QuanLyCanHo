package com.lndangdinh.quanlycanho.controllers;

import com.lndangdinh.quanlycanho.models.Customers;
import com.lndangdinh.quanlycanho.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/customer")
    public String customer(Model model) {
        List<Customers> list = service.getAll();
        model.addAttribute("list", list);
        return "/customer/index";
    }

    @GetMapping("/customer/add")
    public String add(Model model) {
        Customers customer = new Customers();
        model.addAttribute("customer", customer);

        return "customer/add-customer";
    }

    @PostMapping("/customer/add")
    public String save(@ModelAttribute("customer") Customers customer){
        if (this.service.create(customer)) {
            return "redirect:/admin/customer";
        }
        return "/customer/add-customer";
    }
    @GetMapping("/customer/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Customers customer = this.service.findById(id);
        model.addAttribute("customer", customer);

        return "customer/edit-customer";
    }
    @PostMapping("/customer/edit")
    public String update(@ModelAttribute("customer") Customers customer) {
        if (this.service.update(customer)) {
            return "redirect:/admin/customer";
        }
        return "customer/edit-customer";
    }
    @GetMapping("/customer/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (this.service.delete(id)) {
            return "redirect:/admin/customer";
        }
        return "/index";
    }
}
