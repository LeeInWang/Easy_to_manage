-- drop database if exists phonshopdb;
create database phonshopdb;
use phonshopdb;
-- DROP table productManagement;
create table productManagement(
   productCode varchar(15) primary key,
    productDisplayStatus varchar(10) ,
    productSalePrice int not null,
    productInventoryQuantity int(3) not null,
    productRegistrationDate datetime default current_timestamp,
    productName varchar(50) not null,
    productSaleCount int not null,
    productDiscountStatus int(1) not null,
    productOriginalPrice int not null,
    productCostPrice int not null,
    productPaymentType varchar(10) not null,
    productContent varchar(100),
    productImage varchar(100),
    productHashtags varchar(10),
    mainCategory varchar(20) not null,
   subCategory varchar(20) not null,
    productBest int(1) not null
);




insert into productManagement values('ABC123', "1", 20000, 100, '2024-03-18 12:00:00', 'Product 1', 50, 0, 25000, 15000, 'Cash', 'Description for Product 1', 'image1.jpg', '#tag1', 'Category1', 'Subcategory1', 1),
('DEF456'," 1", 30000, 150, '2024-03-18 12:00:00', 'Product 2', 30, 1, 35000, 20000, 'Card', 'Description for Product 2', 'image2.jpg', '#tag2', 'Category2', 'Subcategory2', 0),
('GHI789', "1", 25000, 80, '2024-03-18 12:00:00', 'Product 3', 70, 0, 30000, 18000, 'Cash', 'Description for Product 3', 'image3.jpg', '#tag3', 'Category3', 'Subcategory3', 1),
('JKL012',  "1", 18000, 120, '2024-03-18 12:00:00', 'Product 4', 90, 0, 20000, 15000, 'Cash', 'Description for Product 4', 'image4.jpg', '#tag4', 'Category4', 'Subcategory4', 1),
('MNO345',  "1", 22000, 90, '2024-03-18 12:00:00', 'Product 5', 60, 1, 25000, 18000, 'Card', 'Description for Product 5', 'image5.jpg', '#tag5', 'Category5', 'Subcategory5', 0),
('PQR678',  "1", 28000, 110, '2024-03-18 12:00:00', 'Product 6', 40, 0, 32000, 20000, 'Cash', 'Description for Product 6', 'image6.jpg', '#tag6', 'Category6', 'Subcategory6', 1),
('STU901',  "1", 24000, 70, '2024-03-18 12:00:00', 'Product 7', 80, 1, 28000, 19000, 'Card', 'Description for Product 7', 'image7.jpg', '#tag7', 'Category7', 'Subcategory7', 0),
('VWX234',  "1", 19000, 100, '2024-03-18 12:00:00', 'Product 8', 55, 0, 22000, 16000, 'Cash', 'Description for Product 8', 'image8.jpg', '#tag8', 'Category8', 'Subcategory8', 1),
('YZA567',  "1", 26000, 130, '2024-03-18 12:00:00', 'Product 9', 45, 1, 30000, 20000, 'Card', 'Description for Product 9', 'image9.jpg', '#tag9', 'Category9', 'Subcategory9', 0),
('BCD890',  "1", 21000, 85, '2024-03-18 12:00:00', 'Product 10', 75, 0, 24000, 17000, 'Cash', 'Description for Product 10', 'image10.jpg', '#tag10', 'Category10', 'Subcategory10', 1),
('EFG123',  "1", 29000, 95, '2024-03-18 12:00:00', 'Product 11', 35, 1, 33000, 22000, 'Card', 'Description for Product 11', 'image11.jpg', '#tag11', 'Category11', 'Subcategory11', 0),
('HIJ456',  "1", 23000, 105, '2024-03-18 12:00:00', 'Product 12', 65, 0, 27000, 18000, 'Cash', 'Description for Product 12', 'image12.jpg', '#tag12', 'Category12', 'Subcategory12', 1),
('KLM789',  "1", 20000, 75, '2024-03-18 12:00:00', 'Product 13', 85, 1, 23000, 16000, 'Card', 'Description for Product 13', 'image13.jpg', '#tag13', 'Category13', 'Subcategory13', 0),
('NOP012',  "1", 27000, 125, '2024-03-18 12:00:00', 'Product 14', 50, 0, 31000, 20000, 'Cash', 'Description for Product 14', 'image14.jpg', '#tag14', 'Category14', 'Subcategory14', 1),
('QRS345',  "1", 25000, 80, '2024-03-18 12:00:00', 'Product 15', 70, 1, 29000, 19000, 'Card', 'Description for Product 15', 'image15.jpg', '#tag15', 'Category15', 'Subcategory15', 0),
('TUV678',  "1", 22000, 110, '2024-03-18 12:00:00', 'Product 16', 40, 0, 25000, 17000, 'Cash', 'Description for Product 16', 'image16.jpg', '#tag16', 'Category16', 'Subcategory16', 1),
('VWX901',  "1", 30000, 90, '2024-03-18 12:00:00', 'Product 17', 60, 1, 34000, 22000, 'Card', 'Description for Product 17', 'image17.jpg', '#tag17', 'Category17', 'Subcategory17', 0),
('YZA234',  "1", 19000, 120, '2024-03-18 12:00:00', 'Product 18', 80, 0, 22000, 15000, 'Cash', 'Description for Product 18', 'image18.jpg', '#tag18', 'Category18', 'Subcategory18', 1);

update productManagement set productDisplayStatus ="숨김", productSalePrice=1, productInventoryQuantity=1, 
         productName="asd", productSaleCount=1, productDiscountStatus=1, productOriginalPrice=1, 
         productCostPrice=1, productPaymentType="무통장", productContent="내용1", productImage="경로1", productHashtags="#ㅇㅇ",
      mainCategory="가죽", subCategory="과일", productBest=1 where productCode="ABC123";

select * from productManagement;
drop table  userManagement;
create table userManagement(
    userId varchar(12) primary key,
    userName varchar(10) not null,  /* FK*/
    userGrade varchar(15),
    userJoinDate datetime default current_timestamp,
    userLastLoginDate datetime ,
    userTotalPurchaseCount int(10) not null,
    userAccessBlocked int(2) not null,
    userPassword varchar(20) not null,
    userEmail1 varchar(50) not null,
   userEmail2 varchar(50) not null,
    userZipcode varchar(50) not null,
   userAddress1 varchar(50) not null,
   userAddress2 varchar(50) not null,
    userBirthdayYear varchar(50) not null,
   userBirthdayMonth varchar(50) not null,
   userBirthdayDay varchar(50) not null,
    userTotalPurchaseAmount int(10) not null,
    userPhoneNumber1 varchar(20) not null,
   userPhoneNumber2 varchar(20) not null,
   userPhoneNumber3 varchar(20) not null,
    userNumber int(10) not null  
);
select * from userManagement;

insert into userManagement values
('user0011', 'John', 'Diamond', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1);

insert into userManagement values
('user0012', 'John', 'Diamond', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1);


insert into userManagement values
('user001', 'John', 'Gold', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1),
('user002', 'John', 'Silver', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1),
('user003', 'John', 'Platinum', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1),
('user004', 'John', 'Diamond', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1),
('user005', 'John', 'Silver', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1),
('user006', 'John', 'Gold', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1),
('user007', 'John', 'Diamond', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1),
('user008', 'John', 'Silver', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1),
('user009', 'John', 'Gold', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1),
('user0010', 'John', 'Diamond', '2024-03-18 12:00:00', '2024-03-18 12:00:00', 10, 0, 'password1', 'john','@example.com', 'Country', 'Country', 'Country', '1990','01','01', 5000, '123','4567','890', 1);




-- drop table orderManagement;
create table orderManagement(
   orderID  int auto_increment primary key,
   orderProductPrice  int not null,
    orderDate  DATETIME default current_timestamp not null,
    orderProductName  VARCHAR(50) not null,
    orderProductCount  int(3) not null,
    orderDeliveryCost  int not null, /* FK*/
    orderUserName  varchar(10) not null,
    orderRecipientName  varchar(10) not null,
    orderTotalAmount  int not null,
    orderPaymentType  varchar(10) not null,
    orderPhoneNumber  varchar(15) not null,
    orderTrackingNumber  varchar(20) not null,
    orderDeliveryCompanyName  varchar(20) not null,
    orderRecipientAddress  varchar(50) not null,
    orderDeliveryRequest  varchar(30) not null,
    orderDelivery VARCHAR(50) not null
);


update orderManagement set OrderId=?, getOrderProductName=?, OrderProductCount =? ,
         OrderProductPrice=?, OrderDeliveryCost=?, getOrderTotalAmount=?, OrderDate=?,
         OrderUserName=?, OrderRecipientName=?, OrderPaymentType=?, OrderPhoneNumber=?,
         OrderTrackingNumber=?, OrderDeliveryCompanyName=?, OrderRecipientAddress=? ,
         OrderDeliveryRequest=?, orderDelivery=? where orderID=?;
            


ALTER TABLE orderManagement AUTO_INCREMENT = 1;
insert into orderManagement values(1, 20000, '2024-03-18 12:00:00', 'Product 1', 2, 5000, 'John', 'Alice', 45000, '무통장입금', '+1234567890', 'TN1234567890', 'DeliveryExpress', '123 Main St, City, Country', 'Handle with care', '배송대기'),
(2, 30000, '2024-03-18 12:00:00', 'Product 2', 1, 4000, 'Alice', 'Bob', 34000, '신용카드', '+9876543210', 'TN2345678901', 'QuickShip', '456 Oak St, City, Country', 'Fragile', '배송중'),
(3, 25000, '2024-03-18 12:00:00', 'Product 3', 3, 6000, 'Bob', 'David', 81000, '무통장입금', '+1357924680', 'TN3456789012', 'FastDelivery', '789 Pine St, City, Country', 'Please deliver before 3pm', '배송완료'),
(4, 18000, '2024-03-18 12:00:00', 'Product 4', 1, 3000, 'David', 'Emma', 21000, '신용카드', '+2468135790', 'TN4567890123', 'SwiftCargo', '321 Elm St, City, Country', 'Leave at door if no answer', '배송대기'),
(5, 22000, '2024-03-18 12:00:00', 'Product 5', 2, 4500, 'Emma', 'Sophia', 48500, '무통장입금', '+3698521470', 'TN5678901234', 'SpeedyShip', '654 Maple St, City, Country', 'Do not bend', '배송중'),
(6, 28000, '2024-03-18 12:00:00', 'Product 6', 1, 3500, 'Sophia', 'James', 31500, '신용카드', '+9517534680', 'TN6789012345', 'DeliveryForce', '987 Cedar St, City, Country', 'Call before delivery', '배송대기'),
(7, 24000, '2024-03-18 12:00:00', 'Product 7', 4, 7000, 'James', 'Olivia', 103000, '무통장입금', '+1472583690', 'TN7890123456', 'ExpressCargo', '741 Birch St, City, Country', 'Signature required', '배송완료'),
(8, 19000, '2024-03-18 12:00:00', 'Product 8', 1, 2500, 'Olivia', 'Michael', 21500, '신용카드', '+2583691470', 'TN8901234567', 'SwiftDelivery', '852 Cherry St, City, Country', 'Please deliver after 5pm', '배송대기'),
(9, 26000, '2024-03-18 12:00:00', 'Product 9', 2, 4000, 'Michael', 'Emily', 56000, '무통장입금', '+3691472580', 'TN9012345678', 'FastCargo', '369 Walnut St, City, Country', 'Handle with care', '배송중'),
(10, 21000, '2024-03-18 12:00:00', 'Product 10', 3, 5500, 'Emily', 'William', 68500, '신용카드', '+3693693690', 'TN0123456789', 'QuickDeliver', '159 Sycamore St, City, Country', 'Leave at reception', '배송완료'),
(11, 29000, '2024-03-18 12:00:00', 'Product 11', 1, 3200, 'William', 'Ava', 32200, '무통장입금', '+3693693690', 'TN1234567890', 'SpeedyDelivery', '753 Poplar St, City, Country', 'Fragile', '배송중'),
(12, 23000, '2024-03-18 12:00:00', 'Product 12', 2, 4800, 'Ava', 'Alexander', 30800, '신용카드', '+3693693690', 'TN2345678901', 'DeliveryXpress', '246 Pineapple St, City, Country', 'Please deliver before 12pm', '배송대기'),
(13, 20000, '2024-03-18 12:00:00', 'Product 13', 1, 3500, 'Alexander', 'Charlotte', 23500, '무통장입금', '+3693693690', 'TN3456789012', 'FastShip', '369 Grape St, City, Country', 'Do not bend', '배송완료'),
(14, 27000, '2024-03-18 12:00:00', 'Product 14', 3, 6000, 'Charlotte', 'Daniel', 83700, '신용카드', '+3693693690', 'TN4567890123', 'ExpressDelivery', '852 Orange St, City, Country', 'Call before delivery', '배송중'),
(15, 25000, '2024-03-18 12:00:00', 'Product 15', 2, 4500, 'Daniel', 'Mia', 55000, '무통장입금', '+3693693690', 'TN5678901234', 'SpeedyShip', '741 Lemon St, City, Country', 'Signature required', '배송완료'),
(16, 22000, '2024-03-18 12:00:00', 'Product 16', 1, 3000, 'Mia', 'Benjamin', 25000, '신용카드', '+3693693690', 'TN6789012345', 'SwiftCargo', '963 Banana St, City, Country', 'Please deliver after 3pm', '배송완료'),
(17, 30000, '2024-03-18 12:00:00', 'Product 17', 4, 7000, 'Benjamin', 'Sophia', 103000, '무통장입금', '+3693693690', 'TN7890123456', 'DeliveryForce', '123 Elm St, City, Country', 'Do not bend', '배송대기');

insert into orderManagement values(18, 20000, '2024-03-19 12:00:00', 'Product 1', 2, 5000, 'John', 'Alice', 45000, '무통장입금', '+1234567890', 'TN1234567890', 'DeliveryExpress', '123 Main St, City, Country', 'Handle with care', '배송대기'),
(19, 30000, '2024-03-20 11:00:00', 'Product 2', 1, 4000, 'Alice', 'Bob', 34000, '신용카드', '+9876543210', 'TN2345678901', 'QuickShip', '456 Oak St, City, Country', 'Fragile', '배송중'),
(20, 25000, '2024-03-19 02:00:00', 'Product 3', 3, 6000, 'Bob', 'David', 81000, '무통장입금', '+1357924680', 'TN3456789012', 'FastDelivery', '789 Pine St, City, Country', 'Please deliver before 3pm', '배송완료'),
(21, 18000, '2024-03-19 03:00:00', 'Product 4', 1, 3000, 'David', 'Emma', 21000, '신용카드', '+2468135790', 'TN4567890123', 'SwiftCargo', '321 Elm St, City, Country', 'Leave at door if no answer', '배송대기'),
(22, 22000, '2024-03-19 12:00:00', 'Product 5', 2, 4500, 'Emma', 'Sophia', 48500, '무통장입금', '+3698521470', 'TN5678901234', 'SpeedyShip', '654 Maple St, City, Country', 'Do not bend', '배송중'),
(23, 28000, '2024-03-21 12:00:00', 'Product 6', 1, 3500, 'Sophia', 'James', 31500, '신용카드', '+9517534680', 'TN6789012345', 'DeliveryForce', '987 Cedar St, City, Country', 'Call before delivery', '배송대기'),
(24, 24000, '2024-03-20 12:00:00', 'Product 7', 4, 7000, 'James', 'Olivia', 103000, '무통장입금', '+1472583690', 'TN7890123456', 'ExpressCargo', '741 Birch St, City, Country', 'Signature required', '배송완료'),
(25, 19000, '2024-03-19 12:00:00', 'Product 8', 1, 2500, 'Olivia', 'Michael', 21500, '신용카드', '+2583691470', 'TN8901234567', 'SwiftDelivery', '852 Cherry St, City, Country', 'Please deliver after 5pm', '배송대기'),
(26, 26000, '2024-03-19 10:00:00', 'Product 9', 2, 4000, 'Michael', 'Emily', 56000, '무통장입금', '+3691472580', 'TN9012345678', 'FastCargo', '369 Walnut St, City, Country', 'Handle with care', '배송중'),
(27, 21000, '2024-03-19 11:00:00', 'Product 10', 3, 5500, 'Emily', 'William', 68500, '신용카드', '+3693693690', 'TN0123456789', 'QuickDeliver', '159 Sycamore St, City, Country', 'Leave at reception', '배송완료'),
(28, 29000, '2024-03-22 12:00:00', 'Product 11', 1, 3200, 'William', 'Ava', 32200, '무통장입금', '+3693693690', 'TN1234567890', 'SpeedyDelivery', '753 Poplar St, City, Country', 'Fragile', '배송중'),
(29, 23000, '2024-03-17 12:00:00', 'Product 12', 2, 4800, 'Ava', 'Alexander', 30800, '신용카드', '+3693693690', 'TN2345678901', 'DeliveryXpress', '246 Pineapple St, City, Country', 'Please deliver before 12pm', '배송대기'),
(30, 20000, '2024-03-16 12:00:00', 'Product 13', 1, 3500, 'Alexander', 'Charlotte', 23500, '신용카드', '+3693693690', 'TN3456789012', 'FastShip', '369 Grape St, City, Country', 'Do not bend', '배송완료'),
(31, 27000, '2024-03-15 12:00:00', 'Product 14', 3, 6000, 'Charlotte', 'Daniel', 83700, '신용카드', '+3693693690', 'TN4567890123', 'ExpressDelivery', '852 Orange St, City, Country', 'Call before delivery', '배송중'),
(32, 25000, '2024-03-14 12:00:00', 'Product 15', 2, 4500, 'Daniel', 'Mia', 55000, '무통장입금', '+3693693690', 'TN5678901234', 'SpeedyShip', '741 Lemon St, City, Country', 'Signature required', '배송완료'),
(33, 22000, '2024-03-13 12:00:00', 'Product 16', 1, 3000, 'Mia', 'Benjamin', 25000, '신용카드', '+3693693690', 'TN6789012345', 'SwiftCargo', '963 Banana St, City, Country', 'Please deliver after 3pm', '배송완료'),
(34, 30000, '2024-03-12 12:00:00', 'Product 17', 4, 7000, 'Benjamin', 'Sophia', 103000, '무통장입금', '+3693693690', 'TN7890123456', 'DeliveryForce', '123 Elm St, City, Country', 'Do not bend', '배송대기');
select * from orderManagement;
select orderId, orderTrackingNumber, orderUserName, orderProductName, orderDelivery, orderDate from orderManagement group by orderId;
select orderId, orderTrackingNumber, orderUserName, orderProductName, orderTotalAmount, orderPaymentType, orderDate from orderManagement group by orderId;
select * from orderManagement where orderDelivery like '%대기';


drop table userGradeManagement;
create table userGradeManagement(

   userGradeNumber int auto_increment primary key,
   userGradeName   VARCHAR(10) not null,
    userGradeTotalPurchaseAmount   int  not null,
    userGradeDiscountRate   int not null,
    userGradeCount   int not null

);
ALTER TABLE userGradeManagement AUTO_INCREMENT = 6;

insert into userGradeManagement values(1, 'Bronze', 0, 0, 0),
(2, 'Silver', 100000, 5, 0),
(3, 'Gold', 300000, 10, 0),
(4, 'Platinum', 500000, 15, 0),
(5, 'Diamond', 1000000, 20, 0);

select * from userGradeManagement;



create table mainCategory(
   mainCagegoryNumber   int primary key unique,
   mainCategoryName VARCHAR(10) not null unique
);

select * from mainCategory;

create table subCategory(
   subCagegoryNumber    int primary key unique,
   subCategoryName  VARCHAR(10) not null, 
    subMainCategoryName  VARCHAR(10) not null unique
);

select * from subCategory;


create table designManagement(
   designNumber    int primary key unique,
   designImage   VARCHAR(100) 
);

select * from designManagement;


create table productReviewManagement(
   productReviewNumber  int auto_increment primary key,
   productReviewTitle   VARCHAR(50) not null, 
    productReviewCategory  VARCHAR(50) not null,
    productReviewContent  VARCHAR(300) not null,
   productReviewImage   VARCHAR(100), 
    productReviewUser   VARCHAR(10) not null, 
    productReviewDate  DATETIME default current_timestamp not null, 
    productReviewId  VARCHAR(12) not null
);
ALTER TABLE productReviewManagement AUTO_INCREMENT = 1;

drop table boardManagement;
create table boardManagement(
   boardNumber   int auto_increment primary key,
   boardTitle    VARCHAR(50) not null, 
    boardCategory   VARCHAR(50) not null,
    boardContent   VARCHAR(300) not null,
   boardImage    VARCHAR(100), 
    boardUser    VARCHAR(10) not null, 
    boardDate   DATETIME default current_timestamp,
    boardViews int UNSIGNED DEFAULT 0
);

ALTER TABLE boardManagement AUTO_INCREMENT = 1;
select * from boardManagement;
insert into boardManagement(boardNumber, boardTitle, boardCategory, boardContent, boardImage, boardUser) values(null, "제목1", "공지사항", "내용1", "경로1", "관리자");

create table boardManagementFaq(
   boardFaqNumber int auto_increment primary key,
    boardFaqTitle VARCHAR(50) not null,
   boardFaqContent   VARCHAR(300) not null,
   boardFaqUser    VARCHAR(10) not null
);
ALTER TABLE boardManagementFaq AUTO_INCREMENT = 1;
insert into boardManagementFaq(boardFaqNumber, boardFaqTitle, boardFaqContent, boardFaqUser) values(null, "제목1", "내용1", "uswe001");
insert into boardManagementFaq(boardFaqNumber, boardFaqTitle, boardFaqContent, boardFaqUser) values(null, "제목2", "내용2", "uswe001");
insert into boardManagementFaq(boardFaqNumber, boardFaqTitle, boardFaqContent, boardFaqUser) values(null, "제목3", "내용3", "uswe001");
insert into boardManagementFaq(boardFaqNumber, boardFaqTitle, boardFaqContent, boardFaqUser) values(null, "제목4", "내용4", "uswe001");
insert into boardManagementFaq(boardFaqNumber, boardFaqTitle, boardFaqContent, boardFaqUser) values(null, "제목5", "내용5", "uswe001");

select * from boardManagementFaq;