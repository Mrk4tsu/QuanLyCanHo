package com.lndangdinh.quanlycanho.services;

import com.lndangdinh.quanlycanho.models.Rooms;
import com.lndangdinh.quanlycanho.services.repository.IRoomRepository;
import com.lndangdinh.quanlycanho.services.s_interface.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired private IRoomRepository repository;

    @Override
    public List<Rooms> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Rooms> getAllNonActive() {
        return this.repository.findByStatusFalse();
    }

    @Override
    public Boolean save(Rooms rooms) {
        try {
            this.repository.save(rooms);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            this.repository.delete(findById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Rooms findById(Integer id) {
        return this.repository.findById(id).get();
    }
}
