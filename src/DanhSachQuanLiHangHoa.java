import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class DanhSachQuanLiHangHoa {

    private List<HangHoa> danhSachHH = new ArrayList<>();// tạo danh sách hàng hóa
    ConsoleInput input = new ConsoleInput();

    public void themHH(HangHoa hangHoa) {// thêm hàng hóa mới vào danh sách
        for (HangHoa x : danhSachHH) {
            while (x.getMaHang().equalsIgnoreCase(hangHoa.getMaHang())) {
                System.out.println("- Mã hàng đã tồn tại.");
                System.out.print("- Nhập mã hàng mới: ");
                hangHoa.setMaHang(input.input.nextLine());
            }
        }
        this.danhSachHH.add(hangHoa);

    }

    public void inDSHH() {// in danh sách hàng hóa ra màn hình
        for (HangHoa hangHoa : danhSachHH) {
            System.out.println(hangHoa);
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat numberFormat = NumberFormat.getInstance(localeVN);
            String tt = numberFormat.format(hangHoa.VAT());
            System.out.println("Thue VAT: " + tt + "VND/1SP");
            System.out.println("Danh gia: " + hangHoa.danhGia());
            System.out.print("_________________________________\n");
        }
    }

    public HangHoa tim() {// tìm kiếm hàng hóa qua mã hàng hóa
        HangHoa hh = null;
        String maHH;
        System.out.print("- Nhập mã của hàng hóa: ");
        maHH = input.input.nextLine();
        for (HangHoa hangHoa : danhSachHH) {
            if (hangHoa.getMaHang().equalsIgnoreCase(maHH)) {
                hh = hangHoa;
            }
        }
        System.out.println(hh);
        return hh;
    }
   

    public void xoa() {// xóa hàng hóa thông qua hàm tìm khi biết mã hàng hóa
        HangHoa hangHoa = tim();
        if(hangHoa == null){
            System.out.println("- Không có mã hàng hóa cần xóa.");
            return;
        }
        this.danhSachHH.remove(hangHoa);
        System.out.println("- Xóa thành công.");
    }

    public void sapXepTheoLoaiHang() {
        for (HangHoa hangHoa : danhSachHH) {
            if (hangHoa instanceof HangThucPham) {
                System.out.println(hangHoa);
            }
        }
        for (HangHoa hangHoa : danhSachHH) {
            if (hangHoa instanceof HangDienMay) {
                System.out.println(hangHoa);
            }
        }
        for (HangHoa hangHoa : danhSachHH) {
            if (hangHoa instanceof HangSanhSu) {
                System.out.println(hangHoa);
            }
        }

    }

    public void sapXepTangDanTheoDonGia() {
        Comparator<HangHoa> comparator = new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                return Double.compare(o1.getDonGia(), o2.getDonGia());
            }
        };
        Collections.sort(danhSachHH, comparator);
    }
    public void sapXepGiamDanTheoDonGia(){
        sapXepTangDanTheoDonGia();
        Collections.reverse(danhSachHH);
    }

    public void thongKeSL() {
        int sl1 = 0;
        int sl2 = 0;
        int sl3 = 0;
        for (HangHoa hangHoa : danhSachHH) {
            if (hangHoa instanceof HangThucPham) {
                sl1++;
            } else if (hangHoa instanceof HangDienMay) {
                sl2++;
            } else {
                sl3++;
            }
        }
        System.out.println("- Số lượng hàng hóa của hàng thực phẩm là: " + sl1);
        System.out.println("- Số lượng hàng hóa của hàng điện máy là: " + sl2);
        System.out.println("- Số lượng hàng hóa của hàng sành sứ là: " + sl3);

    }

    public int timvitriHH(HangHoa hangHoa) {
        // HangHoa hangHoa = tim();
        int vitrisHH = danhSachHH.indexOf(hangHoa);
        return vitrisHH;
    }

    public void suaHH() {     
        HangHoa hangHoa = tim();
        System.out.print("Xác nhận mã hàng cần sửa: ");
        String maHang = input.input.nextLine();
        if(hangHoa == null){
            System.out.println("Không tìm thấy mã hàng!");
        }
        int vitri = timvitriHH(hangHoa);
        hangHoa = input.nhapHangHoa();
        danhSachHH.set(vitri, hangHoa);
        hangHoa.setMaHang(maHang);
    }

    public void ghi() {
        GhiFile ghiFile = new GhiFile();
        ghiFile.ghi("DanhSachQuanLyHangHoa.txt", danhSachHH);
    }

    public void doc() {
        DocFile docFile = new DocFile();
        docFile.doc("DanhSachQuanLyHangHoa.txt");
    }

    public void duLieuMoi() {
        HangHoa hangHoa = new HangDienMay("DM01", "Quat may", 100, 280000, 24, 180);
        HangHoa hangHoa2 = new HangSanhSu("SS01", "To su", 201, 50000, "Bat Trang", "14/04/2022");
        HangHoa hangHoa3 = new HangThucPham("TP01", "Banh trang", 300, 5000, "14/02/2022", "14/05/2022", "btt");
        HangHoa hangHoa4 = new HangDienMay("DM02", "Tu lanh", 50, 5500000, 12, 220);
        HangHoa hangHoa5 = new HangThucPham("TP02", "Thit heo", 100, 90000, "14/04/2022", "16/04/2022", "Nong trai");
        HangHoa hangHoa6 = new HangSanhSu("SS02", "Dia", 120, 60000, "Bat Trang", "14/03/2022");
        HangHoa hangHoa7 = new HangDienMay("DM03", "Tivi", 20, 7000000, 36, 220);
        HangHoa hangHoa8 = new HangDienMay("DM04", "May loc nuoc", 60, 5000000, 24, 180);
        HangHoa hangHoa9 = new HangSanhSu("SS03", "Binh hoa", 30, 80000, "Bat Trang", "18/03/2022");
        HangHoa hangHoa10 = new HangThucPham("TP03", "Xuc xich", 300, 45000, "22/02/2022", "22/04/2022", "CP");
        HangHoa hangHoa11 = new HangDienMay("DM05", "may lanh", 54, 6000000, 18, 220);
        danhSachHH.add(hangHoa);
        danhSachHH.add(hangHoa2);
        danhSachHH.add(hangHoa3);
        danhSachHH.add(hangHoa4);
        danhSachHH.add(hangHoa5);
        danhSachHH.add(hangHoa6);
        danhSachHH.add(hangHoa7);
        danhSachHH.add(hangHoa8);
        danhSachHH.add(hangHoa9);
        danhSachHH.add(hangHoa10);
        danhSachHH.add(hangHoa11);
    }

}
