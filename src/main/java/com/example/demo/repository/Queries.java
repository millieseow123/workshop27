package com.example.demo.repository;

public interface Queries {

    public static final String SQL_INSERT_NEW_ACCOUNT = "insert into accounts (acct_id, balance) values (?, ?)";

    public static final String SQL_SELECT_ACCOUNT_NUMBER = "select * from accounts where acct_id = ?";

    public static final String SQL_UPDATE_BALANCE ="update accounts set balance = ? where acct_id = ?";

}
