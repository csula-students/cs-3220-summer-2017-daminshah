create database restaurant;

use restaurant;


#Create restaurant food item table


create table FoodItems(
	ID int ,
	Name varchar(255),
    Description varchar(255),
    Price float

);


#Create restaurant order statuses table
create table Orders(

ID int,
CustomerName varchar(255),
Created date

);

create table Order_Foods(

OrderID int,
FoodID int,
Quantity int

);

#Create restaurant cart table


create table Shopping_Cart(
ID int,
CustomerName varchar(255),
FoodID int,
Quantity int

);


#Insert default food items into food items table

insert into FoodItems (ID,Name,Description,Price)
values(1,"Hamburger","A Hamburger",9.99);

insert into FoodItems (ID,Name,Description,Price)
values(2,"Fries","Some Fries",4.99),
(3,"Coke","Coke Cola",2.99);


alter table Orders
modify column Created datetime;

#Insert default order statuses into order statuses table
insert into Orders(ID,CustomerName, Created)
values(1,"Eric",now()),
(2,"John",now()),
(3,"Jane",now()),
(4,"Alice",now());



insert into Order_Foods(OrderID,FoodID,Quantity)
values(1,1,1),
(1,2,2),
(2,2,2),
(2,3,1),
(3,3,1),
(4,2,1),
(4,3,2);


insert into Shopping_Cart(ID,CustomerName,FoodID,Quantity)
values(1,"Anonymous",1,2),
(1,"Anonymous",2,1),
(1,"Anonymous",2,1),
(2,"Mike",1,1),
(2,"MIke",2,1),
(3,"Bob",3,1);


#Update food item name from "Hamburger" to "Salad"
update FoodItems
set Name=' Salad'
where ID=1;


#Find out which food item has the most orders
select  FoodItems.Name, 
count(Order_Foods.OrderID)
from Order_Foods
inner join FoodItems
on Order_Foods.FoodID=FoodItems.ID
group by Name
order by count(FoodID)  desc limit 2;

#Find out which food item in least shopping carts
select FoodItems.Name,
count(Shopping_Cart.FoodID)
from Shopping_Cart
inner join FoodItems
on Shopping_Cart.FoodID=FoodItems.ID
group by Name
order by count(FoodID) limit 1;

#Find out all restaurant food items using SELECT query
select * from FoodItems;


#Find out all restaurant order statuses using SELECT query
select * from Orders;

#Find out the order statuses that is created today

select * from Orders
where date(Created) = date(now());


#DELETE restaurant food items table
drop table FoodItems;

#Delete restaurant order statuses table
drop table Orders;

#Delete restaurant order statuses table
drop table Shopping_Cart;





