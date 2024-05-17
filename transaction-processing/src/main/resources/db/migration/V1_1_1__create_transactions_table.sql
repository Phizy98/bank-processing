create schema if not exists s_transactions;
create table s_transactions.t_transactions (
    c_id                    serial primary key,
    c_account_from          bigint not null,
    c_account_to            bigint not null,
    c_currency_shortname    varchar(10) not null,
    c_sum                   double precision not null,
    c_category              varchar(100),
    c_transaction_datetime  varchar(20) not null
);
