package com.banking.model;

import com.banking.enums.AccountStatus;
import com.banking.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    private Long id;
    private Long customerId;
    private String accountNumber;
    private AccountStatus status;
    private AccountType type;
    private Double balance;

    // constructor
    public Account (Long id, Long customerId, String accountNumber, AccountType type){
        this.id = id;
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.status = AccountStatus.ACTIVE;
        this.balance = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", accountNumber='" + accountNumber + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", balance=" + balance +
                '}';
    }
}
