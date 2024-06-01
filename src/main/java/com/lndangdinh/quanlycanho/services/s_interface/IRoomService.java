package com.lndangdinh.quanlycanho.services.s_interface;

import com.lndangdinh.quanlycanho.models.Rooms;

import java.util.List;

public interface IRoomService {
    List<Rooms> getAll();
    List<Rooms> getAllNonActive();
    Boolean save(Rooms rooms);
    Boolean delete(Integer id);
    Rooms findById(Integer id);
}
