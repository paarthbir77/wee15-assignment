-- See all sales in different cities
create view cityorders as select city, sum(bill_total) from financial_report group by city;
-- see max sale in month
create view maxsaleofmonth as select month, max(bill_total) from financial_report  where year='2021' group by month;
-- monthly sale last year
create view lastyear as select month, sum(bill_total) from financial_report where year='2020' group by month ;