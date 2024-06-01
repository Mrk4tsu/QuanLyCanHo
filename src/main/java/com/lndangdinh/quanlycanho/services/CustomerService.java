package com.lndangdinh.quanlycanho.services;

import com.lndangdinh.quanlycanho.models.Customers;
import com.lndangdinh.quanlycanho.services.repository.ICustomerRepository;
import com.lndangdinh.quanlycanho.services.s_interface.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired private ICustomerRepository repository;

    @Override
    public List<Customers> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Boolean create(Customers customers) {
        try {
            this.repository.save(customers);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(Customers customers) {
        try {
            this.repository.save(customers);
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
    public Customers findById(Integer id) {
        return this.repository.findById(id).get();
    }
}
