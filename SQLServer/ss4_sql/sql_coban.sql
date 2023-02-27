SELECT * FROM case_study_for_database;

use case_study_for_database;

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là 
	-- 	một trong các ký tự “H”,
	-- “T” hoặc “K” và có tối đa 15 kí tự.
    select * from nhan_vien 
    where ho_ten like 'H%'or
     ho_ten like 'T%' or ho_ten like 'K%'
    and length(ho_ten) <=15;
    
    -- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
     -- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”
     select *,round(Datediff(curdate(),ngay_sinh)/365,0)as tuoi
     from khach_hang
     where round(Datediff(curdate(),ngay_sinh)/365,0) between 18 and 50 
     and dia_chi like '%Da Nang' or dia_chi like '%Quang tri';
     
     -- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
     -- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
     -- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
     select khach_hang.ma_khach_hang ,khach_hang.ho_ten,count(ngay_lam_hop_dong) as solandat
     from khach_hang
     inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
     inner join hop_dong on khach_hang.ma_khach_hang =hop_dong.ma_khach_hang
     where ten_loai_khach ='diamond'
	 group by khach_hang.ma_khach_hang
     order  by count(ngay_lam_hop_dong) ;
     
     -- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
     -- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet)
     -- cho tất cả các khách hàng đã từng đặt phòng.
     -- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
     select khach_hang.ma_khach_hang,khach_hang.ho_ten,dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc,sum(dich_vu.chi_phi_thue+hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia) as tongtien
     from khach_hang
     inner join loai_khach on khach_hang.ma_loai_khach =loai_khach.ma_loai_khach
     inner join hop_dong on khach_hang.ma_khach_hang =hop_dong.ma_khach_hang
     inner join dich_vu on dich_vu.ma_dich_vu =hop_dong.ma_dich_vu
     left join hop_dong_chi_tiet on hop_dong.ma_hop_dong =hop_dong_chi_tiet.ma_hop_dong
     left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem =dich_vu_di_kem.ma_dich_vu_di_kem
     group by khach_hang.ma_khach_hang,
     hop_dong.ma_hop_dong
     order by khach_hang.ma_khach_hang;
     