ALTER TABLE s_transactions.t_transactions
ADD CONSTRAINT check_category
CHECK (c_category IN ('product', 'service'));
