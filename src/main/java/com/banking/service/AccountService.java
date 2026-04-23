package com.banking.service;

import com.banking.enums.AccountType;
import com.banking.model.Account;
import com.banking.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final CustomerService customerService;
    //in memory database for account
    private Map<Long, Account> accountServiceDb = new HashMap<>();
    private Long nextId =   1L;


    @Autowired
    public AccountService(CustomerService customerService) {
        this.customerService = customerService;
    }

    // creating account
    public Account createAccount(Long customerId, AccountType type){
        boolean customerExists = customerService.findById(customerId).isPresent();
            if (!customerExists) {
                throw new RuntimeException("Customer does not exist:"+customerId);
            }
            Long id = nextId++;
        Account account = new Account(id, customerId, "ACC"+id, type);
            accountServiceDb.put(account.getId(), account);
            return account;
    }


    //find by id
    public Optional<Account> findById(Long id){
        return Optional.ofNullable(accountServiceDb.get(id));
    }

    //get accounts by customer ID
    public List<Account> getAccountByCustomerId(Long customerId){

        return accountServiceDb.values().stream().filter(a -> a.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }

    //deposit
    public Account deposit(Long id, Double amount){
        Account ac = findById(id).orElseThrow(() -> new RuntimeException("Account not found"+ id));
        ac.setBalance(ac.getBalance() + amount);
        System.out.println("Deposited: "+ amount + "| new Balance: "+ ac.getBalance());
        return ac;
    }
    //WithDraw
    public Account withdraw(Long id, Double amount){
        Account ac = findById(id).orElseThrow(() -> new RuntimeException("Account Not Found"+id));
        if(ac.getBalance() < amount){
            throw new RuntimeException("Account balance is insufficient to withdraw :"+ac.getBalance());
        }
        ac.setBalance(ac.getBalance() - amount);
        System.out.println("WithDrawn: "+amount + "| New Balance: "+ac.getBalance());
        return ac;


    }

}
