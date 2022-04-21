public class HangHoaTestDrive {
    public static void main(String[] args) {
        DanhSachQuanLiHangHoa danhSachQuanLiHangHoa = new DanhSachQuanLiHangHoa();
        danhSachQuanLiHangHoa.duLieuMoi();
        ConsoleInput nhap = new ConsoleInput();
        String luaChon;
        do{
            System.out.println("------------MENU------------");
            System.out.println(">>1: Thêm hàng hóa mới vào danh sách.");
            System.out.println(">>2: Xóa hàng hóa khỏi danh sách.");
            System.out.println(">>3: Sửa hàng hóa trong danh sách.");
            System.out.println(">>4: Tìm hàng hóa trong danh sách.");
            System.out.println(">>5: In danh sách hàng hóa.");
            System.out.println(">>6: Sắp xếp hàng hóa theo loại hàng.");
            System.out.println(">>7: Sắp xếp hàng hóa tăng dần theo đơn giá.");
            System.out.println(">>8: Sắp xếp hàng hóa giảm dần theo đơn giá.");
            System.out.println(">>9: Thống kê số lượng hàng hóa.");
            System.out.println(">>10: Đọc file danh sách hàng hóa.");
            System.out.println(">>11: Thoát.");
            System.out.print("- Nhập vào sự lựa chọn (1->11): ");
            luaChon = nhap.input.nextLine();
            switch(luaChon){
                case "1": 
                    System.out.println("----Thêm hàng hóa mới vào danh sách----");
                    ConsoleInput addHangHoa = new ConsoleInputAdd();
                    danhSachQuanLiHangHoa.themHH(addHangHoa.nhapHangHoa());
                    danhSachQuanLiHangHoa.ghi();
                    break;
                case "2":
                    System.out.println("----Xóa hàng hóa khỏi danh sách----");
                    danhSachQuanLiHangHoa.xoa();
                    danhSachQuanLiHangHoa.ghi();
                    break;
                case "3":
                    danhSachQuanLiHangHoa.suaHH();
                    danhSachQuanLiHangHoa.ghi();
                    break;
                case "4":
                    System.out.println("----Tìm hàng hóa trong danh sách----");
                    danhSachQuanLiHangHoa.tim();
                    break;
                case "5":
                    System.out.println("----In danh sách hàng hóa----");
                    danhSachQuanLiHangHoa.inDSHH();
                    break;
                case "6":
                    System.out.println("----Sắp xếp hàng hóa theo loại hàng----");
                    danhSachQuanLiHangHoa.sapXepTheoLoaiHang();
                    danhSachQuanLiHangHoa.ghi();
                    break;
                case "7":
                    System.out.println("----Sắp xếp hàng hóa tăng dần theo đơn giá----");
                    danhSachQuanLiHangHoa.sapXepTangDanTheoDonGia();
                    danhSachQuanLiHangHoa.inDSHH();
                    danhSachQuanLiHangHoa.ghi();
                    break;
                case "8":
                    System.out.println("----Sắp xếp hàng hóa giảm dần theo đơn giá----");
                    danhSachQuanLiHangHoa.sapXepGiamDanTheoDonGia();
                    danhSachQuanLiHangHoa.inDSHH();
                    danhSachQuanLiHangHoa.ghi();
                    break;
                case "9":
                    System.out.println("----Thống kê số lượng hàng hóa----");
                    danhSachQuanLiHangHoa.thongKeSL();
                    break;
                case "10": 
                    System.out.println("----Đọc file danh sách hàng hóa----");
                    danhSachQuanLiHangHoa.doc();
                    break;
                case "11": System.out.println("KẾT THÚC!");
                    return;
                default: 
                    System.out.println("- Lựa chọn không hợp lệ.");

                    
            }
            System.out.print("- Quay lại MENU (1:yes/0:no): ");
            luaChon = nhap.input.nextLine();
        }while(luaChon.equals("1"));  
    }    
}
