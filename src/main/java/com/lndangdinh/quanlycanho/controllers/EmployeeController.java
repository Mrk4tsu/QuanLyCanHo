package com.lndangdinh.quanlycanho.controllers;

import com.lndangdinh.quanlycanho.models.Customers;
import com.lndangdinh.quanlycanho.models.Employees;
import com.lndangdinh.quanlycanho.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class EmployeeController {
    @Autowired private EmployeeService service;
    @GetMapping("/employee")
    public String index(Model model) {
        model.addAttribute("employees", this.service.getAll());
        return "/employee/index";
    }
    @GetMapping("/employee/add")
    public String add(Model model) {
        Employees employee = new Employees();
        model.addAttribute("employee", employee);

        return "employee/add";
    }

    @PostMapping("/employee/add")
    public String save(@ModelAttribute("employee") Employees employee){
        if (this.service.save(employee)) {
            return "redirect:/admin/employee";
        }
        return "/employee/add";
    }
    @GetMapping("/employee/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        Employees employee = this.service.findById(id);
        model.addAttribute("employee", employee);

        return "employee/edit";
    }
    @PostMapping("/employee/edit")
    public String update(@ModelAttribute("employee") Employees employee) {
        if (this.service.save(employee)) {
            return "redirect:/admin/employee";
        }
        return "employee/edit";
    }
    @GetMapping("/employee/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (this.service.delete(id)) {
            return "redirect:/admin/employee";
        }
        return "/index";
    }
}
