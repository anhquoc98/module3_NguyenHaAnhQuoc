create database ss2_thuchanh;
use ss2_thuchanh;

create table hoc_sinh(
ma_hs int primary key auto_increment,
ten_hs varchar(255),
ngay_sinh date,
lop varchar(255),
gioi_tinh varchar(10)
);

create table giao_vien(
ma_gv int primary key auto_increment,
ten_gv varchar(255),
sdt char
);

create table mon_hoc(
ma_mh int primary key auto_increment,
ten_mh varchar(100),
ma_gv int ,
foreign key (ma_gv) references giao_vien(ma_gv)
);

create table bang_diem(
ma_hs int,
ma_mh int,
diem_thi int default (0),
ngay_kt date,

foreign key (ma_hs) references hoc_sinh(ma_hs),
foreign key (ma_mh) references mon_hoc(ma_mh)
);

