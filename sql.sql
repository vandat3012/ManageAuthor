drop database if exists manage_post;
create database if not exists manage_post;
use manage_post;



create table author (
id int primary key,
name varchar(255),
price int
);

create table posts (
id int primary key,
name varchar(255)
);

create table assignment (
id int primary key auto_increment,
date_start date,
date_end date,
note varchar(255),
id_author int,
id_post int,
foreign key (id_author) references author(id),
foreign key (id_post) references posts(id)
);

insert into author values 
(1,"Luong Van Dat",10000),
(2,"Le Dang Phap",20000),
(3,"Huynh Tran Thanh Dung",30000),
(4,"Nguyen Van Hai Nhat",40000),
(5,"Nguyen Truc Vy",50000);

insert into posts values 
(1,"Xã Hội"),
(2,"An Ninh"),
(3,"Tài Chính");

insert into assignment(date_start,date_end,note,id_author,id_post) values 
("2000-11-03","2000-11-12","no note",1,2),
("2000-11-05","2000-11-13","request fast",3,2),
("2000-11-04","2000-11-14","bonus",1,3),
("2000-11-06","2000-11-11","no note",2,2),
("2000-11-01","2000-11-27","bonus",5,1),
("2000-11-11","2000-11-11","bonus",4,2);

select * from posts;
select * from author;
select * from assignment;

select am.id,am.date_start,am.date_end,am.note,p.name as name_post,a.name as name_author,a.price
from assignment am
join author a on a.id = am.id_author
join posts p on p.id = am.id_post
order by am.id asc;

select am.id,am.date_start,am.date_end,am.note,am.id_post,am.id_author
from assignment am
where am.id = 1;

update assignment am set am.date_start = "2000-11-11",am.date_end="2000-11-12",am.note="no note",am.id_post=2,am.id_author =1
where am.id = 1;

select am.id,am.date_start,am.date_end,am.note,p.name as name_post,a.name as name_author,a.price
from assignment am
join author a on a.id = am.id_author
join posts p on p.id = am.id_post
where a.name='Lương Văn Đạt';

