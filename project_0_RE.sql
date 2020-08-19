--------- DANGER ZONE ---------
--DROP TABLE IF EXISTS users; 
--DROP TABLE IF EXISTS customers CASCADE;
--DROP TABLE IF EXISTS accounts;
--DROP TABLE IF EXISTS customers CASCADE;
--DROP TABLE IF EXISTS employees CASCADE;
---==========================================================

CREATE TABLE users (
	user_id SERIAL,
	user_name VARCHAR(30) PRIMARY KEY,
	user_pw VARCHAR(30) NOT null,
    user_type VARCHAR(30) NOT null
);

CREATE TABLE customers (
	customer_id SERIAL PRIMARY KEY, 
	first_name VARCHAR(30) NOT NULL,
	middle_name VARCHAR(30),
    last_name VARCHAR(30) NOT NULL,
    address VARCHAR(50),
	city VARCHAR(30),
    state VARCHAR(30),
    zip Integer,
	phone_number Integer,
    user_name_fk VARCHAR(30) REFERENCES users(user_name)    
);

CREATE TABLE accounts (
	account_id BIGINT PRIMARY KEY, 
	account_name VARCHAR(30) NOT NULL,
	account_type VARCHAR(30) NOT NULL,  --saving, checking
    balance REAL NOT NULL,
	status VARCHAR(30) NOT NULL,		--approved, denied, pending
    customer_id_fk INTEGER REFERENCES customers(customer_id),
    internal_memo VARCHAR(100),
    created_date_time date 
);

CREATE TABLE employees (
	employee_id SERIAL PRIMARY KEY, 
	status  VARCHAR(30) NOT NULL,		-- employee, admin
    user_name_fk VARCHAR(30) REFERENCES users(user_name)    
);
---======================================================================

INSERT INTO users (user_name, user_pw, user_type) 
	VALUES ( 'ruki', 'ruki', 'client'),			
			( 'akidobie', 'akidobie', 'client'),
			( 'boss', 'boss', 'client'),
		    ('goodemp', 'goodemp', 'employee');
		   
		   
INSERT INTO users (user_id, user_name, user_pw, user_type) 
VALUES (4, 'goodemp', 'goodemp', 'employee')


INSERT INTO customers ( first_name, middle_name, last_name, address, city, state, zip, phone_number, user_name_fk)
VALUES ( 'Rukiye', 'Nafis', 'Eziz', '123 abc', 'Tokyo', 'Tokyo', 1234, 12345678, 'ruki' ),	
		( 'Aki', 'Mocha', 'Delight', '123 abc', 'Tokyo', 'Tokyo', 1234, 12345678, 'akidobie' ),
		( 'Good boss','Noname', 'Doe', '345 abc', 'Nowhere', 'MI', 9999, 4444444, 'boss'),
		( 'GoodEmp', 'like', 'choco', '987 sun', 'Ann Arbor', 'MI', 1234, 12345678, 'goodemp' );

	INSERT INTO customers (customer_id, first_name, middle_name, last_name, address, city, state, zip, phone_number, user_name_fk)
VALUES (4, 'GoodEmp', 'like', 'choco', '987 sun', 'Ann Arbor', 'MI', 1234, 12345678, 'goodemp' );
		--(2, 'Jamie', 'JJ' , 'Tartam', '234 abc', 'AnnArbor', 'MI', 4321, 98765432, 'jamie' ),
		
INSERT INTO accounts (account_id , account_name, account_type, balance, status, customer_id_fk, internal_memo, created_date_time )
VALUES (1, 'my saving', 'saving', '5000.0', 'approved', 1 ,'', now()),
		(2, 'trip', 'checking', '300.0', 'approved', 1 ,'just approved',now()),
		(3, 'emergency', 'checking', '300.0', 'approved', 2 ,'', now()),
		(4, 'school', 'checking', '600.0', 'approved', 2 , 'student loans sucks', now());
	
	
	
		(5, 'secret', 'saving', '3300.0', 'approved', 3 , 'do not tell no one'),
		(6, 'incase', 'checking', '300.0', 'approved', 4 ,'');
	
---======================================================================================
	

SELECT * FROM users;

SELECT * FROM users WHERE user_name = 'ruki';


DELETE FROM customers 
WHERE user_name =  'jamie'; 
	

SELECT * FROM customers;

UPDATE customers 
	SET middle_name = 'JJ', last_name  = 'TT'
	WHERE customer_id = 3;

		
UPDATE customers 
	SET first_name = 'nafis'
	WHERE customer_id = 5; 


SELECT * FROM customers;


---------------------------------------------------------------
--renaming table column name
ALTER TABLE accounts 
RENAME COLUMN created_date_time TO internal_memo;

--renaming column data type
ALTER TABLE accounts 
ALTER COLUMN created_date_time TYPE varchar;

--update a cell value
UPDATE accounts 
	SET balance = 30
	WHERE account_id = 2 AND customer_id_fk = 1;

-- add a column to a table
ALTER TABLE accounts 
ADD COLUMN created_date_time date

---update and set type
UPDATE accounts 
	SET created_date_time = now() 
	WHERE account_id = 4;

SELECT * FROM accounts;

--- delete
DELETE FROM accounts 
WHERE account_id = 77777; 

---insert value to a table
INSERT INTO employees (status , user_name_fk )
VALUES ('admin', 'boss' ),
       ('employee', 'goodemp');
		
INSERT INTO employees (status , user_name_fk )
VALUES ('employee', 'hardworker' );







