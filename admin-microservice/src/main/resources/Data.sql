-- Insert Data into INVENTORY_DETAILS Table
INSERT INTO INVENTORY_DETAILS (ID, ITEM_NAME, PRICE) VALUES (1, 'Chips', 10);
INSERT INTO INVENTORY_DETAILS (ID, ITEM_NAME, PRICE) VALUES (2, 'Hide & Seek Biscuit', 35);
INSERT INTO INVENTORY_DETAILS (ID, ITEM_NAME, PRICE) VALUES (3, 'Apple', 20);
INSERT INTO INVENTORY_DETAILS (ID, ITEM_NAME, PRICE) VALUES (4, 'Banana', 5);
INSERT INTO INVENTORY_DETAILS (ID, ITEM_NAME, PRICE) VALUES (5, 'Chicken', 200);
INSERT INTO INVENTORY_DETAILS (ID, ITEM_NAME, PRICE) VALUES (6, 'Sandwich', 50);
INSERT INTO INVENTORY_DETAILS (ID, ITEM_NAME, PRICE) VALUES (7, 'Pasta', 100);

-- Insert data into USER Table
 INSERT INTO USER ("EMAIL", "PASSWORD","TYPE") VALUES ('abc@gmail.com','abc','Customer');
 INSERT INTO USER ("EMAIL", "PASSWORD","TYPE") VALUES ('ag@gmail.com','abc','Customer');
 INSERT INTO USER ("EMAIL", "PASSWORD","TYPE") VALUES ('xyz@yahoo.co.in','abc','Customer');
 INSERT INTO USER ("EMAIL", "PASSWORD","TYPE") VALUES ('admin@rest.com', 'admin','Admin');

-- Insert data into FINANCIAL_REPORT Table
INSERT INTO FINANCIAL_REPORT ("ID", "USERID", "BILL_TOTAL","DATE","MONTH","YEAR", "CITY") VALUES (1, 'xyz@yahoo.co.in', 100,'01','01','2021', 'delhi');
INSERT INTO FINANCIAL_REPORT ("ID", "USERID", "BILL_TOTAL","DATE","MONTH","YEAR", "CITY") VALUES (2, 'ag@gmail.com', 650,'30','11','2021', 'mumbai');

INSERT INTO FINANCIAL_REPORT ("ID", "USERID", "BILL_TOTAL","DATE","MONTH","YEAR", "CITY") VALUES (3, 'abc@gmail.com', 500,'11','11','2020', 'mumbai');
-- ADMIN VIEWS

-- See all sales in different cities
 create view cityorders as select city, sum(bill_total) from financial_report group by city;

-- see max sale in month
 create view maxsaleofmonth as select month, max(bill_total) from financial_report  where year='2021' group by month;

-- monthly sale last year
 create view lastyear as select month, sum(bill_total) from financial_report where year='2020' group by month ;
 
 --USER VIEWS

 --view all orders
create view allOrders as select * from financial_report;

--see orders by date between 1/01/2021 to 30/11/2021
create view ordersDateFiltered as select * from financial_report where cast(cast(year*10000 + month*100 + date as varchar(255)) as date) between '2021-01-01' and '2021-11-30' ;

--see by price between 50 and 500
create view ordersPriceFiltered as select * from financial_report where bill_total between 50 and 500;
 