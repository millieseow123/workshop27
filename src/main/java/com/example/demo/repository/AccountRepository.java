package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import static com.example.demo.repository.Queries.*;


import java.util.Optional;

import com.example.demo.model.Account;

import static com.example.demo.model.AccountUtil.*;


@Repository
public class AccountRepository {
    
    @Autowired
    private JdbcTemplate template;

    public boolean newAccount(Account account){
        int count = template.update(SQL_INSERT_NEW_ACCOUNT, account.getAcct_id(), account.getBalance());
        return 1 == count;
    }

    public Optional<Account> findAccount(String acct_no){
        
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_ACCOUNT_NUMBER, acct_no);
        if (!rs.next())
            return Optional.empty();

        return Optional.of(convert(rs));
    }

    public boolean deposit(float amount, String acct_id){
        Optional<Account> opt = findAccount(acct_id);
        if (opt.isEmpty())
            throw new IllegalArgumentException("Account %s is not found".formatted(acct_id));
        Account acct = opt.get();
        int count = template.update(SQL_UPDATE_BALANCE, amount + acct.getBalance(), acct_id);
        return 1 == count; 
    }

    public boolean withdraw(float amount, String acct_id){
        Optional<Account> opt = findAccount(acct_id);
        if (opt.isEmpty())
            throw new IllegalArgumentException("Account %s is not found".formatted(acct_id));

        int count = template.update(SQL_UPDATE_BALANCE, opt.get().getBalance() - amount, acct_id);
        return 1 == count; 
    }

}
