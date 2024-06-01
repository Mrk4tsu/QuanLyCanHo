package com.lndangdinh.quanlycanho.services.s_interface;

import com.lndangdinh.quanlycanho.models.Customers;

import java.util.List;

public interface ICustomerService {
    List<Customers> getAll();
    Boolean create(Customers customers);
    Boolean update(Customers customers);
    Boolean delete(Integer id);
    Customers findById(Integer id);
}
