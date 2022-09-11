package com.restservice.springBootMySql.dataAccess;

import com.restservice.springBootMySql.entities.Customers;
import lombok.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Data
@AllArgsConstructor
@Repository
public class HibernateCustomersDal implements ICustomersDal{
    private EntityManager entityManager;
    @Autowired

    private Session session;

    Session returnSession(){
        return this.session = this.entityManager.unwrap(Session.class);
    }

    Customers returnCustomer(int id){
        Customers customers = this.session.get(Customers.class , id);
        return customers;
    }

    @Override
    @Transactional
    public List<Customers> getAll() {
        returnSession();
        List < Customers > customers = this.session.createQuery("from Customers" , Customers.class).getResultList();
        return customers;
    }

    @Override
    public Customers getById(int id) {
        returnSession();
        return returnCustomer(id);
    }

    @Override
    public void add(Customers customers) {
        returnSession();
        this.session.save(customers);
    }

    @Override
    public void update(Customers customers) {
        returnSession();
        this.session.update(customers);
    }

    @Override
    public void delete(Customers customers) {
        returnSession();
        Customers customerToDelete = this.session.get(Customers.class , customers.getId());
        this.session.delete(customerToDelete);
    }
}
