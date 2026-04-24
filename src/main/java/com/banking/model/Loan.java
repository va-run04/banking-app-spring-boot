package com.banking.model;

import com.banking.enums.LoanStatus;
import com.banking.enums.LoanType;

public class Loan {
    private Long id;
    private Long customerId;
    private LoanType lType;
    private LoanStatus lStatus;
    private Double principalAmount;
    private Double interestRate;
    private Double emiAmount;
    private Integer tenureMonths;
    private Double remainingAmount;

    public Loan(Long id, Long customerId, LoanType lType, Double principalAmount, Double interestRate,  Integer tenureMonths) {
        this.id = id;
        this.customerId = customerId;
        this.lType = lType;
        this.lStatus = LoanStatus.APPLIED;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.emiAmount = 0.0;
        this.tenureMonths = tenureMonths;
        this.remainingAmount = principalAmount;


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

    public LoanType getlType() {
        return lType;
    }

    public void setlType(LoanType lType) {
        this.lType = lType;
    }

    public LoanStatus getlStatus() {
        return lStatus;
    }

    public void setlStatus(LoanStatus lStatus) {
        this.lStatus = lStatus;
    }

    public Double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(Double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getEmiAmount() {
        return emiAmount;
    }

    public void setEmiAmount(Double emiAmount) {
        this.emiAmount = emiAmount;
    }

    public Integer getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(Integer tenureMonths) {
        this.tenureMonths = tenureMonths;
    }

    public Double getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", lType=" + lType +
                ", lStatus=" + lStatus +
                ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate +
                ", emiAmount=" + emiAmount +
                ", tenureMonths=" + tenureMonths +
                ", remainingAmount=" + remainingAmount +
                '}';
    }
}
