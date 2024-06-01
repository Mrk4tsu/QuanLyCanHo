package com.lndangdinh.quanlycanho.services.s_interface;

import com.lndangdinh.quanlycanho.models.Reservations;


import java.util.List;

public interface IReservationService {
    List<Reservations> getAll();
    Boolean save(Reservations reservations);
    Boolean delete(Integer id);
    Reservations findById(Integer id);

}
