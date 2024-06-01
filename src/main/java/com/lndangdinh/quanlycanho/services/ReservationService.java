package com.lndangdinh.quanlycanho.services;

import com.lndangdinh.quanlycanho.models.Reservations;
import com.lndangdinh.quanlycanho.services.repository.IReservationRepository;
import com.lndangdinh.quanlycanho.services.s_interface.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationService implements IReservationService {
    @Autowired private IReservationRepository repository;
    @Override
    public List<Reservations> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Boolean save(Reservations reservations) {
        try {
            this.repository.save(reservations);
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
    public Reservations findById(Integer id) {
        return this.repository.findById(id).get();
    }
}
