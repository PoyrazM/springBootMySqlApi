package com.restservice.springBootMySql.business;

import com.restservice.springBootMySql.entities.Customers;

import java.util.List;

public interface ICustomerService {

    List<Customers> getAll();
    Customers getById(int id);
    void add(Customers customers);
    void update(Customers customers);
    void delete(Customers customers);
}
