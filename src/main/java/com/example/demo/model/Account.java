package com.example.demo.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Account {
    
    private String acct_id;
    private float balance;
    private float deposit;
    private float withdraw;
    public String getAcct_id() {
        return acct_id;
    }
    public void setAcct_id(String acct_id) {
        this.acct_id = acct_id;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public float getDeposit() {
        return deposit;
    }
    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }
    public float getWithdraw() {
        return withdraw;
    }
    public void setWithdraw(float withdraw) {
        this.withdraw = withdraw;
    }

 
    

    
}
