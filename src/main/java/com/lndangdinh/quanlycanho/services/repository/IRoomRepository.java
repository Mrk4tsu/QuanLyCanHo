package com.lndangdinh.quanlycanho.services.repository;

import com.lndangdinh.quanlycanho.models.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoomRepository extends JpaRepository<Rooms, Integer> {
    List<Rooms> findByStatusFalse();
}
