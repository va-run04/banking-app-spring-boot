package com.banking;

import com.banking.enums.AccountType;
import com.banking.service.AccountService;
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

        // Create Account Service
        AccountService service1 = new AccountService(service);

        //initialise accounts
        service1.createAccount(1L, AccountType.SAVINGS);
        service1.createAccount(2L, AccountType.CURRENT);


        //depositing 5000 into Varun's account
        service1.deposit(1L, 5000.00);

        //Withdrawing 2000 from varuns account
        service1.withdraw(1L, 2000.00);

        //catching exception by withdrwaing 10000
        try{
            service1.withdraw(1L, 10000.00);
        }catch (RuntimeException e){
            System.out.println("Caught: "+e.getMessage());
        }







    }
}
