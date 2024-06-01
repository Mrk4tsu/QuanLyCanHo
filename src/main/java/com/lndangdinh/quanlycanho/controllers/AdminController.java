package com.lndangdinh.quanlycanho.controllers;

import com.lndangdinh.quanlycanho.models.Customers;
import com.lndangdinh.quanlycanho.models.Reservations;
import com.lndangdinh.quanlycanho.models.Rooms;
import com.lndangdinh.quanlycanho.services.CustomerService;
import com.lndangdinh.quanlycanho.services.EmployeeService;
import com.lndangdinh.quanlycanho.services.ReservationService;
import com.lndangdinh.quanlycanho.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/add")
    public String add(Model model) {
        var rooms = roomService.getAll();
        rooms.removeIf(Rooms::getStatus);
        model.addAttribute("rooms", rooms);

        var cus = customerService.getAll();
        model.addAttribute("customer", cus);

        var reservation = new Reservations();
        model.addAttribute("reservation", reservation);
        return "/add";
    }

    @PostMapping("/add")
    public String save(@RequestParam Map<String, String> allParams) {
        Customers customer = new Customers();
        customer.setFirst_name(allParams.get("first_name"));
        customer.setLast_name(allParams.get("last_name"));
        customer.setAddress(allParams.get("address"));
        customer.setEmail(allParams.get("email"));
        customer.setPhone(allParams.get("phone"));


        Reservations reservation = new Reservations();
        int roomId = Integer.parseInt(allParams.get("roomId"));
        Rooms room = roomService.findById(roomId); // Assuming you have a method to find room by id

        if (room != null) {
            room.setStatus(true);
            reservation.setRooms(room);
        }
        reservation.setCheck_in(java.sql.Date.valueOf(allParams.get("check_in")));
        reservation.setCheck_out(java.sql.Date.valueOf(allParams.get("check_out")));
        reservation.setTotal_price(Double.parseDouble(allParams.get("total_price")));
        reservation.setStatus(allParams.get("status"));


        var e = employeeService.findById(2);
        reservation.setEmployees(e);
        reservation.setCustomers(customer);
        if (customerService.create(customer) && reservationService.save(reservation)) {
            return "redirect:/admin/reservation/" + reservation.getId();
        }
        return "/add";
    }
}
