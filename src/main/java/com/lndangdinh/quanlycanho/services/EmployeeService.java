package com.lndangdinh.quanlycanho.services;

import com.lndangdinh.quanlycanho.models.Employees;
import com.lndangdinh.quanlycanho.services.repository.IEmployeeRepository;
import com.lndangdinh.quanlycanho.services.s_interface.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired private IEmployeeRepository repository;
    @Override
    public List<Employees> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Boolean save(Employees employees) {
        try {
            this.repository.save(employees);
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
    public Employees findById(Integer id) {
        return this.repository.findById(id).get();
    }
}
