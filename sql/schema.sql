drop schema if exists bank;
create schema bank;
use bank;

create table accounts(
    acct_id char(8) not null,
    balance float not null,
    primary key(acct_id)
);