package com.example.demo.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.util.MultiValueMap;

import static com.example.demo.model.Account.*;

public class AccountUtil {

    public static Account convert(SqlRowSet rs) {
        Account account = new Account();
        account.setAcct_id(rs.getString("acct_id"));
        account.setBalance(rs.getFloat("balance"));

        return account;
    }

    public static Account convert(MultiValueMap<String, String> form) {        
        

        Account account = new Account();

        account.setAcct_id(form.getFirst("acct_id"));
        account.setBalance(Float.valueOf(form.getFirst("balance")));
        //account.setBalance(Float.valueOf(form.getFirst("deposit")));

        //account.setBalance(Float.valueOf(form.getFirst("withdraw")));

        return account;
    }

    public static Account depositConvert(MultiValueMap<String, String> form) {        
        Account account = new Account();
        account.setAcct_id(form.getFirst("acct_id"));
        //account.setBalance(Float.valueOf(form.getFirst("balance")));
        account.setBalance(Float.valueOf(form.getFirst("deposit")));

        return account;
    }

    public static Account withdrawConvert(MultiValueMap<String, String> form) {        
        Account account = new Account();
        account.setAcct_id(form.getFirst("acct_id"));
        account.setBalance(Float.valueOf(form.getFirst("withdraw")));

        return account;
    }
}
