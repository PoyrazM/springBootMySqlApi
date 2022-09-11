package com.restservice.springBootMySql.business;

import com.restservice.springBootMySql.dataAccess.ICustomersDal;
import com.restservice.springBootMySql.entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CustomerManager implements ICustomerService{

    private ICustomersDal customersDal;

    @Autowired
    CustomerManager(ICustomersDal customersDal){
        this.customersDal = customersDal;
    }


    @Override
    @Transactional
    public List<Customers> getAll() {
        return this.customersDal.getAll();
    }

    @Override
    @Transactional
    public Customers getById(int id) {
        return this.customersDal.getById(id);
    }

    @Override
    @Transactional
    public void add(Customers customers) {
        this.customersDal.add(customers);
    }

    @Override
    @Transactional
    public void update(Customers customers) {
        this.customersDal.update(customers);
    }

    @Override
    @Transactional
    public void delete(Customers customers) {
        this.customersDal.delete(customers);
    }
}
