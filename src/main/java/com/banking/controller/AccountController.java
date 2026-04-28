package com.banking.controller;

import com.banking.enums.AccountType;
import com.banking.model.Account;
import com.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    //1) Create account
    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account.getCustomerId(), account.getType());
    }


    // 2) Get accounts Id
    @GetMapping("/{id}")
    public Optional<Account> findById(@PathVariable Long id){
        return accountService.findById(id);
    }


    // 3) Get accounts By Customer Id
    @GetMapping("customer/{custId}")
    public List<Account> getByCustomerId(@PathVariable Long custId){
        return accountService.getAccountByCustomerId(custId);
    }

    // 4) Deposit into Account
    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestParam Double amount){
        return accountService.deposit(id,amount);
    }

    // 5) WithDraw
    @PostMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestParam Double amount){
        return accountService.withdraw(id,amount);
    }

}
