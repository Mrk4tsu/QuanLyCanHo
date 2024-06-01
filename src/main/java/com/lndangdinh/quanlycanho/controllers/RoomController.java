package com.lndangdinh.quanlycanho.controllers;

import com.lndangdinh.quanlycanho.models.Customers;
import com.lndangdinh.quanlycanho.models.RoomType;
import com.lndangdinh.quanlycanho.models.Rooms;
import com.lndangdinh.quanlycanho.services.CustomerService;
import com.lndangdinh.quanlycanho.services.RoomService;
import com.lndangdinh.quanlycanho.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class RoomController {
    @Autowired
    private RoomService service;
    @Autowired
    RoomTypeService roomTypeService;

    @GetMapping("/room")
    public String customer(Model model) {
        List<RoomType> listType = roomTypeService.getAll();
        model.addAttribute("listType", listType);

        List<Rooms> list = service.getAll();
        model.addAttribute("list", list);
        return "/room/index";
    }

    @GetMapping("/room/add")
    public String add(Model model) {
        List<RoomType> roomTypes = roomTypeService.getAll();
        model.addAttribute("roomTypes", roomTypes);

        model.addAttribute("room", new Rooms());
        return "room/add";
    }

    @PostMapping("/room/add")
    public String save(@ModelAttribute("room") Rooms room){
        room.setStatus(false);
        if (this.service.save(room)) {
            return "redirect:/admin/room";
        }
        return "/room/add";
    }
    @GetMapping("/room/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        List<RoomType> roomTypes = roomTypeService.getAll();
        model.addAttribute("roomTypes", roomTypes);

        Rooms room = this.service.findById(id);
        model.addAttribute("room", room);

        return "room/edit";
    }
    @PostMapping("/room/edit")
    public String update(@ModelAttribute("room") Rooms room) {
        if (this.service.save(room)) {
            return "redirect:/admin/room";
        }
        return "room/edit";
    }
    @GetMapping("/room/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        if (this.service.delete(id)) {
            return "redirect:/admin/room";
        }
        return "/index";
    }
    @GetMapping("/room-type/add")
    public String addType(Model model) {

        model.addAttribute("roomType", new RoomType());
        return "room/add-type";
    }

    @PostMapping("/room-type/add")
    public String saveType(@ModelAttribute("roomType") RoomType roomType){
        if (this.roomTypeService.save(roomType)) {
            return "redirect:/admin/room";
        }
        return "/room/add-type";
    }
    @GetMapping("/room/edit-type/{id}")
    public String editType(Model model, @PathVariable("id") Integer id) {
        RoomType roomType = this.roomTypeService.findById(id);
        model.addAttribute("roomType", roomType);

        return "room/edit-type";
    }
    @PostMapping("/room/edit-type")
    public String updateType(@ModelAttribute("roomType") RoomType roomType) {
        if (this.roomTypeService.save(roomType)) {
            return "redirect:/admin/room";
        }
        return "room/edit-type";
    }
}
