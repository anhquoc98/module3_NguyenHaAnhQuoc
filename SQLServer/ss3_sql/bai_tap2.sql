drop database if exists `quan_ly_ban_hang_ss3`;
create database `quan_ly_ban_hang_ss3`;
use `quan_ly_ban_hang_ss3`;

create table customer(
cID int primary key,
cName varchar(25),
cAge tinyint
);

create table order_customer(
oID int primary key,
cID int,
oDate date,
oTotalPrice int,
foreign key (cID) references  customer(cID)
);

create table product(
pID int primary key,
pName varchar(25),
pPrice int
);

create table order_detail(
oID int,
pID int,
odQTY int,
primary key (oID,pID),
foreign key (oID) references order_customer(oID),
foreign key (pID) references product(pID)
);

insert into customer(cID,cName,cAge)
value (1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',20);

insert into order_customer(oID,cID,oDate)
value(1,1,'2006-03-21'),
(2,2,'2006-03-23'),
(3,1,'2022-03-16');

insert into product(pID,pName,pPrice)
value(1,'May Giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into order_detail(oID,pID,odQTY)
value(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select oID,oDate,oTotalPrice from order_customer;

 -- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select cName as `Name Customer`, pName as `Product`
from order_detail 
inner join order_customer on order_detail.oID =order_customer.oID
inner join product on order_detail.pID =product.pID
inner join customer on customer.cID=order_customer.cID;

 -- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
 select customer.cName from customer
 left join order_customer on customer.cID = order_customer.cID
 where order_customer.cID is null;
 
 -- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
 -- Giá bán của từng loại được tính = odQTY*pPrice)
 select order_customer.oID, order_customer.oDate, order_detail.odQTY*product.pPrice as `Total price`
 from order_detail
 inner join order_customer on order_detail.oID = order_customer.oID
 inner join product on order_detail.pID = product.pID;