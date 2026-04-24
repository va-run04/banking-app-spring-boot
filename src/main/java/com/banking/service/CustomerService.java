package com.banking.service;

import com.banking.model.Customer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;
//@Scope("prototype")  // for prototype demo
@Service
public class CustomerService {

    private Map<Long, Customer> customerDb = new HashMap<>();
    private Long nextId =   1L;

    @PostConstruct
    public void init(){
        System.out.println("Customer service bean is created and ready to use");
    }

    public Customer registerCustomer(String firstName, String lastName, String email, String phone) {

        boolean emailExists = customerDb.values().stream().anyMatch(c -> c.getEmail().equals(email));
        if (emailExists) {
            throw new RuntimeException("Email already Registered: "+email);
        }

        Customer customer = new Customer(nextId++, firstName, lastName, email, phone);
        customerDb.put(customer.getId(), customer);
        System.out.println("Customer registered successfully "+customer);
        return customer;
    }

    // 1) Find by Id
    public Optional<Customer> findById(Long id){
        return Optional.ofNullable(customerDb.get(id));
    }
    // 2) Find by Email
    public Optional<Customer> findByEmail(String email){
        return customerDb.values().stream().filter(c -> c.getEmail().equals(email)).findFirst();

    }

    // 3) Get All
    public List<Customer> getAllCustomers(){

        return  new ArrayList<>(customerDb.values());
    }

    // 4) Update customer

    public Customer updateCustomer(Long id, String phone, String address) {
        Customer customer = customerDb.get(id);
        if (customer == null) {
            throw new RuntimeException("Customer not found: " + id);
        }
        customer.setPhone(phone);
        customer.setAddress(address);
        System.out.println("Customer updated: " + customer);
        return customer;
    }

    public void deleteCustomer(Long id) {
        if (!customerDb.containsKey(id)) {
            throw new RuntimeException("Customer not found: " + id);
        }
        customerDb.remove(id);
        System.out.println("Customer deleted: id=" + id);
    }

    public int getTotalCustomers() {
        return customerDb.size();
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Customer service bean is being destroyedA");
    }
}
