create database neoflexDB;

create table customer (
id int not null auto_increment primary key,
firstName varchar(10),
lastName varchar(10),
middleName varchar(10),
login varchar(10) not null,
password varchar(10) not null
);

create table orderStatus (
id int not null auto_increment primary key,
created varchar(10),
processing varchar(1000),
finished varchar(10)
);

create table orderCustomer(
id int not null auto_increment primary key,
date date,
customer_id int,
order_status_id int,
foreign key(customer_id) references customer(id),
foreign key(order_status_id) references orderStatus(id)
);

create table orderHistory(
id int not null auto_increment primary key,
place_of_issue varchar(1000),
delivery varchar(100),
delivery_address varchar(100),
order_customer_id int,
order_status_id int,
foreign key(order_customer_id) references ordercustomer(id),
foreign key(order_status_id) references orderStatus(id)
);

INSERT INTO `neoflexdb`.`customer` (`firstName`, `lastName`, `middleName`, `login`, `password`) VALUES ('Дмитрий', 'Григорьев', 'Сергеевич', 'admin', 'admin');

INSERT INTO `neoflexdb`.`orderstatus` (`created`, `processing`, `finished`) VALUES ('оплачен', 'добавлен на склад', 'не выдан');
INSERT INTO `neoflexdb`.`orderstatus` (`created`, `processing`, `finished`) VALUES ('оплачен', 'в пути', 'не выдан');
INSERT INTO `neoflexdb`.`orderstatus` (`created`, `processing`, `finished`) VALUES ('оплачен', 'на месте разгрузки', 'не выдан');
INSERT INTO `neoflexdb`.`orderstatus` (`created`, `processing`, `finished`) VALUES ('оплачен', 'в месте выдачи', 'не выдан');
INSERT INTO `neoflexdb`.`orderstatus` (`created`) VALUES ('не оплачен');

