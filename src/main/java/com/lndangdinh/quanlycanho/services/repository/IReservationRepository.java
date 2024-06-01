package com.lndangdinh.quanlycanho.services.repository;

import com.lndangdinh.quanlycanho.models.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservations, Integer>{
}
