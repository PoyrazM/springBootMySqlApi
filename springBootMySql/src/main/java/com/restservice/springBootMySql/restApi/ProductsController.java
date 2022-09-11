package com.restservice.springBootMySql.restApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductsController {

    private final Map< Object , String > prods = new HashMap<>();

    ProductsController(){
        this.prods.put("id" , "1");
        this.prods.put("name" , "Lenovo Legion Y5");
        this.prods.put("ram" , "16GB");
        this.prods.put("memory" , "1TB SSD");
    }

    @GetMapping("/")
    public String getProduct(){
        return "Laptop";
    }

    @GetMapping("/products")
    public Map<Object , String> getProducts(){
        return this.prods;
    }
}
