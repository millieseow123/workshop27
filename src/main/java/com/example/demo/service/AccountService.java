package com.example.demo.service;

import com.example.demo.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accRepo;

    @Transactional
    public void transfer(String sourceAcc, String destAcc, Float amount) {
        try {
            accRepo.withdraw(amount, sourceAcc);
            if (amount > 300)
                throw new IllegalArgumentException("You do not have sufficient balance");
                accRepo.deposit(amount, destAcc);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
