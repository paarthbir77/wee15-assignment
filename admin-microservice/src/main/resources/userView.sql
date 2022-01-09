--view all orders
create view allOrders as select * from financial_report;
--see orders by date between 1/01/2021 to 30/11/2021
create view ordersDateFiltered as select * from financial_report where cast(cast(year*10000 + month*100 + date as varchar(255)) as date) between '2021-01-01' and '2021-11-30' ;
--see by price between 50 and 500
create view ordersPriceFiltered as select * from financial_report where bill_total between 50 and 500;