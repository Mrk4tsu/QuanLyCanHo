package com.lndangdinh.quanlycanho.controllers;

import com.lndangdinh.quanlycanho.models.Employees;
import com.lndangdinh.quanlycanho.models.Reservations;
import com.lndangdinh.quanlycanho.models.RoomType;
import com.lndangdinh.quanlycanho.models.Rooms;
import com.lndangdinh.quanlycanho.services.CustomerService;
import com.lndangdinh.quanlycanho.services.EmployeeService;
import com.lndangdinh.quanlycanho.services.ReservationService;
import com.lndangdinh.quanlycanho.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ReservationController {
    @Autowired
    private ReservationService service;
    @Autowired
    private RoomService roomService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/reservation")
    public String reservation(Model model) {
        List<Reservations> reservations = service.getAll();
        model.addAttribute("reservations", reservations);

        return "reservation/index";
    }

    @GetMapping("/reservation/{id}")
    public String reservationDetail(@PathVariable("id") int id, Model model) {
        Reservations reservation = service.findById(id);
        model.addAttribute("reservation", reservation);
        return "reservation/detail";
    }

    @GetMapping("/reservation/add")
    public String addReservation(Model model) {
        var rooms = roomService.getAll();
        rooms.removeIf(Rooms::getStatus);
        model.addAttribute("rooms", rooms);

        var cus = customerService.getAll();
        model.addAttribute("cus", cus);

        var reservation = new Reservations();
        model.addAttribute("reservation", reservation);
        return "reservation/add";
    }

    @PostMapping("/reservation/add")
    public String saveReservation(Reservations reservation) {
        var e = employeeService.findById(2);
        reservation.setEmployees(e);
        if (service.save(reservation)) {
            return "redirect:/admin/reservation";
        }
        return "reservation/add";
    }

    @GetMapping("/reservation/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        var rooms = roomService.getAll();

        rooms.removeIf(Rooms::getStatus);

        model.addAttribute("rooms", rooms);

        var cus = customerService.getAll();
        model.addAttribute("cus", cus);
        Reservations r = this.service.findById(id);

        model.addAttribute("reservation", r);
        return "reservation/edit";
    }

    @PostMapping("/reservation/edit")
    public String update(@ModelAttribute("reservation") Reservations reservation) {
        var e = employeeService.findById(2);
        reservation.setEmployees(e);
        if (this.service.save(reservation)) {
            return "redirect:/admin/reservation";
        }
        return "reservation/edit";
    }

    @GetMapping("/reservation/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        service.findById(id).getRooms().setStatus(false);
        if (this.service.delete(id)) {
            return "redirect:/admin/reservation";
        }
        return "/index";
    }
}
