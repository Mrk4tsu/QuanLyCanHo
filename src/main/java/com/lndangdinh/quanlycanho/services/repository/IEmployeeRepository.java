package com.lndangdinh.quanlycanho.services.repository;

import com.lndangdinh.quanlycanho.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employees, Integer>{
}
