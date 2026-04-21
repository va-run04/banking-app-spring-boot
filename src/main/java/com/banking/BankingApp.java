package com.banking;

import com.banking.service.CustomerService;

public class BankingApp {
    public static void main(String[] args) {

        CustomerService service = new CustomerService();
        service.registerCustomer("Varun", "Kumar", "varunyadavnanneboina@gmail.com","7981543038");
        service.registerCustomer("Arun", "AA", "ArunAA@gmail.com","324565");
        service.registerCustomer("Warlu", "VER", "Venkateshwarlu@gmail.com","7095527101");

        // printing all customers
        System.out.println(service.getAllCustomers());

        // finding by email and printing the customer
        service.findByEmail("varunyadavnanneboina@gmail.com").ifPresent(c -> System.out.println(c));

        //update customer phone and address
        service.updateCustomer(1L, "9542473524", "9 Arnold Cct");

        // duplicate email registration
        try{
            service.registerCustomer("fake", "name","varunyadavnanneboina@gmail.com","782728432");
        } catch (Exception e) {
            System.out.println("Caught: "+e.getMessage());
        }

        // printing total count
        System.out.println(service.getTotalCustomers());


        // create second customer service and print total count
        CustomerService secondService = new CustomerService();
        System.out.println("Second service customer count: " + secondService.getTotalCustomers());


    }
}
