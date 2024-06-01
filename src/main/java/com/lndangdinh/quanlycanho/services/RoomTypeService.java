package com.lndangdinh.quanlycanho.services;

import com.lndangdinh.quanlycanho.models.RoomType;
import com.lndangdinh.quanlycanho.services.repository.IRoomTypeRepository;
import com.lndangdinh.quanlycanho.services.s_interface.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService implements IRoomTypeService {
    @Autowired
    private IRoomTypeRepository repository;

    @Override
    public List<RoomType> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Boolean save(RoomType type) {
        try {
            this.repository.save(type);
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
    public RoomType findById(Integer id) {
        return this.repository.findById(id).get();
    }
}
