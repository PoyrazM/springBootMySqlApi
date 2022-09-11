package com.restservice.springBootMySql.restApi;
import com.restservice.springBootMySql.business.ICustomerService;
import com.restservice.springBootMySql.entities.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomersController {

    private ICustomerService customerService;

    @Autowired
    CustomersController(ICustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customers> getCustomers(){
        return this.customerService.getAll();
    }

    @GetMapping("/customers/{id}")
    public Customers getById(@PathVariable int id){
        return this.customerService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Customers customers){
        this.customerService.add(customers);
    }

    @PutMapping("/update")
    public void update(@RequestBody Customers customers){
        this.customerService.update(customers);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Customers customers){
        this.customerService.delete(customers);
    }
}
