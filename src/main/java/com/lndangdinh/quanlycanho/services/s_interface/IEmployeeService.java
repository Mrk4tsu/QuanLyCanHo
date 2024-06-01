package com.lndangdinh.quanlycanho.services.s_interface;

import com.lndangdinh.quanlycanho.models.Employees;

import java.util.List;

public interface IEmployeeService {
    List<Employees> getAll();
    Boolean save(Employees employees);
    Boolean delete(Integer id);
    Employees findById(Integer id);
}
