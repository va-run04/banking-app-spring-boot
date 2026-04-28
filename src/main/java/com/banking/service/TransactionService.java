package com.banking.service;

import com.banking.enums.TransactionType;
import com.banking.model.Account;
import com.banking.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class TransactionService {
    private final AccountService service;
    private Long nextId = 1L;

    @Autowired
    public TransactionService(AccountService service) {
        this.service = service;
    }

    // In memory Storage i.e HashMap
    private Map<Long, Transaction> storage = new HashMap<>();

    // deposit
    public Transaction deposit(Long accountId, Double amount){
        Account account = service.deposit(accountId, amount);
        Transaction transact = new Transaction(nextId++,
                accountId,
                TransactionType.DEPOSIT,
                amount,
                account.getBalance(),
                "Deposit",
                LocalDateTime.now().toString());

        storage.put(transact.getId(),transact);
        return transact;
    }

    //Withdraw
    public Transaction withdraw(Long accountId, Double amount){
        Account account = service.withdraw(accountId, amount);
        Transaction transact = new Transaction(nextId++,
                accountId,
                TransactionType.WITHDRAWAL,
                amount,
                account.getBalance(),
                "WithDraw",
                LocalDateTime.now().toString());

        storage.put(transact.getId(), transact);
        return transact;
    }

    //Transfer
    public Transaction transfer(Long fromAccountId,Long toAccountId, Double amount){

        Account fromAc = service.withdraw(fromAccountId, amount);
        Account toAc = service.deposit(toAccountId, amount);

        Transaction transferOut = new Transaction(nextId++, fromAccountId, TransactionType.TRANSFER_OUT, amount, fromAc.getBalance(), "TransferOut",LocalDateTime.now().toString());
        storage.put(transferOut.getId(), transferOut);

        Transaction tranferIn = new Transaction(nextId++, toAccountId, TransactionType.TRANSFER_IN,amount ,toAc.getBalance(), "Transfer In",LocalDateTime.now().toString());
        storage.put(tranferIn.getId(), tranferIn);

        return transferOut;
    }


    //Get Transactions By Id
    public List<Transaction> getTransactionById(Long accountId){
        return storage.values().stream().filter(t -> t.getAccountId().equals(accountId)).collect(Collectors.toList());
    }

    // Get All Transactions
    public List<Transaction> getAllTransactions(){
        return new ArrayList<>(storage.values());
    }
    
}
