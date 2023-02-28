use case_study_for_database;

-- 6.Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue,
-- ten_loai_dich_vu của tất cả các loại dịch vụ
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3)

select dich_vu.ma_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu
from dich_vu 
join loai_dich_vu on dich_vu.ma_loai_dich_vu =loai_dich_vu.ma_loai_dich_vu
join hop_dong on hop_dong.ma_dich_vu =dich_vu.ma_dich_vu
where hop_dong.ma_dich_vu not in (select ma_dich_vu from hop_dong where month(ngay_lam_hop_dong) between 1 and 3  and year(ngay_lam_hop_dong) =2021)
group by dich_vu.ma_dich_vu
order by dich_vu.dien_tich desc
;

-- 7.Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
-- của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.

select dich_vu.ma_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.so_nguoi_toi_da,dich_vu.chi_phi_thue,loai_dich_vu.ma_loai_dich_vu
from dich_vu
join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu=dich_vu.ma_loai_dich_vu
join hop_dong on hop_dong.ma_dich_vu =dich_vu.ma_dich_vu
where hop_dong.ma_dich_vu not in (select ma_dich_vu from hop_dong where year(ngay_lam_hop_dong) =2021)
group by dich_vu.ma_dich_vu;

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.

select ho_ten from khach_hang
group by ho_ten
having count(ho_ten) >1;

-- 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select month(hop_dong.ngay_lam_hop_dong) as thang, count(khach_hang.ma_khach_hang) as soluong
from hop_dong 
join khach_hang on khach_hang.ma_khach_hang =hop_dong.ma_khach_hang
where year(hop_dong.ngay_lam_hop_dong) =2021
group by month(hop_dong.ngay_lam_hop_dong)
order by thang asc;
 -- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
 -- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
 -- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
 select hop_dong.ma_hop_dong,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc,hop_dong.tien_dat_coc,ifnull(sum(hop_dong_chi_tiet.so_luong), 0) as hdct
 from hop_dong
 left join hop_dong_chi_tiet on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
 group by hop_dong.ma_hop_dong;
 
 -- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
 
 select dich_vu_di_kem.ma_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem
 from dich_vu_di_kem
  join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem= hop_dong_chi_tiet.ma_dich_vu_di_kem
  join hop_dong on hop_dong.ma_hop_dong=hop_dong_chi_tiet.ma_hop_dong
 join khach_hang on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
 join loai_khach on loai_khach.ma_loai_khach =khach_hang.ma_loai_khach
 where khach_hang.dia_chi like'%Vinh' or khach_hang.dia_chi like'%Quang Ngai' and loai_khach.ten_loai_khach ='Diamond' ;
 
 -- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu,
 -- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem),
 -- tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021
 select hop_dong.ma_hop_dong,nhan_vien.ho_ten,khach_hang.ho_ten,khach_hang.so_dien_thoai,dich_vu.ma_dich_vu,dich_vu.ten_dich_vu,ifnull(sum(hop_dong_chi_tiet.so_luong), 0) as hdct,hop_dong.tien_dat_coc
 from hop_dong
 left join khach_hang on khach_hang.ma_khach_hang=hop_dong.ma_khach_hang
 left join nhan_vien on nhan_vien.ma_nhan_vien =hop_dong.ma_nhan_vien
 left join dich_vu on dich_vu.ma_dich_vu =hop_dong.ma_dich_vu
 left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong=hop_dong.ma_hop_dong
 where month(hop_dong.ngay_lam_hop_dong) between 10 and 12 and year(hop_dong.ngay_lam_hop_dong) =2020
 group by hop_dong.ma_hop_dong;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select * ,count(hop_dong_chi_tiet.ma_dich_vu_di_kem) as slsd from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
 