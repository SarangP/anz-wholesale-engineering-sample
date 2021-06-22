insert into Account(account_Number, account_Name, account_Type, currency, balance_Date, balance) values (1234567890, 'SGSaving723', 'Savings', 'SGD',CURDATE(),1233.33);
insert into Account(account_Number, account_Name, account_Type, currency, balance_Date, balance) values (1234567891, 'SGCurrent724', 'Current', 'SGD',CURDATE(),55542.13);
insert into Account(account_Number, account_Name, account_Type, currency, balance_Date, balance) values (1234567892, 'AUSaving212', 'Savings', 'AUD',CURDATE(),7656.99);
insert into Account(account_Number, account_Name, account_Type, currency, balance_Date, balance) values (1234567893, 'AUCurrent222', 'Current', 'AUD',CURDATE(),5432.33);
insert into Account(account_Number, account_Name, account_Type, currency, balance_Date, balance) values (1234567894, 'SGSaving788', 'Savings', 'SGD',CURDATE(),9989.05);
insert into Account(account_Number, account_Name, account_Type, currency, balance_Date, balance) values (1234567895, 'AUCurrent233', 'Current', 'AUD',CURDATE(),6676.12);

insert into Account_TRANSACTION values (1, 0,   122.10, 'Debit','expense',CURDATE(), 1234567891);
insert into Account_TRANSACTION values (2, 0,   12.00, 'Debit','expense',CURDATE(), 1234567891);
insert into Account_TRANSACTION values (3, 0,   19.10, 'Debit','expense',CURDATE(), 1234567891);
insert into Account_TRANSACTION values (4, 0,   17.50, 'Debit','expense',CURDATE(), 1234567891);
insert into Account_TRANSACTION values (5, 0,   198.10, 'Debit','expense',CURDATE(), 1234567891);
insert into Account_TRANSACTION values (6, 0,   113.10, 'Debit','expense',CURDATE(), 1234567891);

insert into Account_TRANSACTION values (7, 0,   17.10, 'Debit','expense',CURDATE(), 1234567892);
insert into Account_TRANSACTION values (8, 0,   16.10, 'Debit','expense',CURDATE(), 1234567892);
insert into Account_TRANSACTION values (9, 0,   87.10, 'Debit','expense',CURDATE(), 1234567892);
insert into Account_TRANSACTION values (10, 0,   54.10, 'Debit','expense',CURDATE(), 1234567892);
insert into Account_TRANSACTION values (11, 0,   78.10, 'Debit','expense',CURDATE(), 1234567892);
insert into Account_TRANSACTION values (12, 0,   345.10, 'Debit','expense',CURDATE(), 1234567892);

insert into Account_TRANSACTION values (13, 0,   22.10, 'Debit','expense',CURDATE(), 1234567893);
insert into Account_TRANSACTION values (14, 0,   2.10, 'Debit','expense',CURDATE(), 1234567893);
insert into Account_TRANSACTION values (15, 0,   23.10, 'Debit','expense',CURDATE(), 1234567893);
insert into Account_TRANSACTION values (16, 0,   65.10, 'Debit','expense',CURDATE(), 1234567893);
insert into Account_TRANSACTION values (17, 0,   99.10, 'Debit','expense',CURDATE(), 1234567893);
insert into Account_TRANSACTION values (18, 0,   90.10, 'Debit','expense',CURDATE(), 1234567893);

insert into Account_TRANSACTION values (19, 0,   12.10, 'Debit','expense',CURDATE(), 1234567894);
insert into Account_TRANSACTION values (20, 0,   17.10, 'Debit','expense',CURDATE(), 1234567894);
insert into Account_TRANSACTION values (21, 0,   109.10, 'Debit','expense',CURDATE(), 1234567894);
insert into Account_TRANSACTION values (22, 0,   198.10, 'Debit','expense',CURDATE(), 1234567894);
insert into Account_TRANSACTION values (23, 0,   12.10, 'Debit','expense',CURDATE(), 1234567894);

insert into Account_TRANSACTION values (24, 0,   234.10, 'Debit','expense',CURDATE(), 1234567895);
insert into Account_TRANSACTION values (25, 0,   767.10, 'Debit','expense',CURDATE(), 1234567895);
insert into Account_TRANSACTION values (26, 0,   89.10, 'Debit','expense',CURDATE(), 1234567895);

insert into Account_TRANSACTION values (27, 0,   1222.10, 'Debit','expense',CURDATE(), 1234567890);
insert into Account_TRANSACTION values (28, 0,   124.10, 'Debit','expense',CURDATE(), 1234567890);
insert into Account_TRANSACTION values (29, 0,   11.10, 'Debit','expense',CURDATE(), 1234567890);
insert into Account_TRANSACTION values (30, 0,   81.10, 'Debit','expense',CURDATE(), 1234567890);
commit;