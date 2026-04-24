package com.banking.service;

import com.banking.enums.LoanStatus;
import com.banking.enums.LoanType;
import com.banking.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LoanService {

    private Long nextId = 1L;
    private final CustomerService customerService;


    private Map<Long, Loan> loanServiceDb = new HashMap<>();

    @Autowired
    public LoanService (CustomerService customerService1){
        this.customerService = customerService1;
    }

    //Apply loan
    public Loan applyLoan(Long customerId, LoanType lType, Double amount, Double interestRate, Integer tenure){

        throw new RuntimeException();
    }

    // Approve loan
    public Loan approveLoan(Long loanId){
        throw new RuntimeException();
    }

    //DisburseLone
    public Loan disburseLoan(Long loanId){
        throw new RuntimeException();
    }

    //Pay EMI
    public Loan payEmi(Long loanId){
        throw new RuntimeException();
    }
    //get ALL Loans by customer id
    public List<Loan> getLoans(Long customerId){
        throw new RuntimeException();
    }

    //FIND lOAN BY ID
    public Optional<Loan> findLoanById(Long loanId){
        throw new RuntimeException();
    }


}
