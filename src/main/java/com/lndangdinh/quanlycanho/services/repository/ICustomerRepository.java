package com.lndangdinh.quanlycanho.services.repository;

import com.lndangdinh.quanlycanho.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customers, Integer> {
}
