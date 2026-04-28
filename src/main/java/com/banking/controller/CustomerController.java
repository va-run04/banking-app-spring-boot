package com.banking.controller;


import com.banking.model.Customer;
import com.banking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {


    private final CustomerService service;
    @Autowired
    CustomerController(CustomerService service){
        this.service = service;
    }


    //1) Get all customers
    @GetMapping
    public List<Customer> getAllCustomer(){
        return service.getAllCustomers();
    }

    //2) Get Customer by Id
    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id){
        return service.findById(id);
    }

    //3) Register Customer
    @PostMapping
    public Customer registerCustomer(@RequestBody Customer customer){
        return service.registerCustomer(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhone());
    }

    //4) Update Customer
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        return service.updateCustomer(id,customer.getPhone(),customer.getAddress());
    }

    //5) delete customer
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id){
        service.deleteCustomer(id);
    }

}
