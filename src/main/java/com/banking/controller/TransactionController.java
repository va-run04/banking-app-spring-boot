package com.banking.controller;


import com.banking.model.Transaction;
import com.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    // 1) Transfer
    @PostMapping("/transfer")
    public Transaction transfer(@RequestParam Long fromAccountId,
                                @RequestParam Long toAccountId,
                                @RequestParam Double amount) {
        return transactionService.transfer(fromAccountId, toAccountId, amount);
    }

    //2) Deposit
    @PostMapping("/deposit/{id}")
    public Transaction deposit(@PathVariable Long id, @RequestParam Double amount){
        return transactionService.deposit(id, amount);
    }
    // 3) WithDraw
    @PostMapping("/withdraw/{id}")
    public Transaction withdraw(@PathVariable Long id, @RequestParam Double amount){
        return transactionService.withdraw(id, amount);
    }

    // 4) Get All Transactions
    @GetMapping
    public List<Transaction> getAll(){
        return transactionService.getAllTransactions();
    }

    //5) Get Transactions by Account id
    @GetMapping("/{id}")
    public List<Transaction> getById(@PathVariable Long id){
        return transactionService.getTransactionById(id);
    }
}
