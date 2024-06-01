package com.lndangdinh.quanlycanho.services.s_interface;

import com.lndangdinh.quanlycanho.models.RoomType;
import com.lndangdinh.quanlycanho.models.Rooms;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoomTypeService {
    List<RoomType> getAll();
    Boolean save(RoomType rooms);
    Boolean delete(Integer id);
    RoomType findById(Integer id);
}
