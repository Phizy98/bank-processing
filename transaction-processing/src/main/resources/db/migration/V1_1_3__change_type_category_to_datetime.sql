ALTER TABLE s_transactions.t_transactions
ALTER COLUMN c_transaction_datetime
TYPE TIMESTAMP WITH TIME ZONE
USING c_transaction_datetime::TIMESTAMP WITH TIME ZONE;

