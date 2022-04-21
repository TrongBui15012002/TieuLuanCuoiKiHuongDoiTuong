import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham extends HangHoa{
    private Date ngaySX;
    private Date ngayHH;
    private String nhaCungCap;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    //hàm tạo hàng thực phẩm đầy đủ
    public HangThucPham(String maHang, String tenHang, int soLuongTonKho, double donGia, String SX, String HH, String nhaCungCap){
        super(maHang, tenHang, soLuongTonKho, donGia);
        try {
            ngaySX = date.parse(SX);
        } catch (ParseException e1) {
            System.out.println("- Sai định dạng ngày sản xuất.");
        }
        try {
            ngayHH = date.parse(HH);
        } catch (ParseException e) {
            System.out.println("- Sai định dạng ngày hết hạn.");
        }
        this.setNgaySX(ngaySX);
        this.setNgayHH(ngayHH);
        this.nhaCungCap = nhaCungCap;
    }
    //hàm tạo hàng thực phẩm không có mã hàng
    public HangThucPham(String tenHang, int soLuongTonKho, double donGia, String SX, String HH, String nhaCungCap){
        super(tenHang, soLuongTonKho, donGia);
        try {
            ngaySX = date.parse(SX);
        } catch (ParseException e) {
            System.out.println("- Sai định dạng ngày sản xuất.");
        }
        try {
            ngayHH = date.parse(HH);
        } catch (ParseException e) {
            System.out.println("- Sai định dạng ngày hết hạn.");
        }
        this.setNgaySX(ngaySX);
        this.setNgayHH(ngayHH);
        this.nhaCungCap = nhaCungCap;
    }
    
    public Date getNgaySX() {
        return ngaySX;
    }
    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }
    public Date getNgayHH() {
        return ngayHH;
    }
    //ngày hết hạn phải sau ngày sản xuất
    public void setNgayHH(Date ngayHH) {
        if(ngayHH.after(ngaySX)){
            this.ngayHH = ngayHH;
        }else{
            System.out.println("- Ngày hết hạn phải sau ngày sản xuất.");
        }
    }
    public String getNhaCungCap() {
        return nhaCungCap;
    }
    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    @Override
    public String toString() {
        return "\nLoai hang hoa: Thuc pham" + super.toString() + "\nNgay san xuat: "+date.format(ngaySX) + 
        "\nNgay het han: " + date.format(ngayHH) + "\nNha cung cap: " + nhaCungCap;
    }
    @Override
    public double VAT() {
        double vat = 0.05*getDonGia();
        return vat;
    }
    @Override
    public String danhGia() {
        String dg = "khong danh gia";
        Date toDay = new Date();
        if(getNgayHH().before(toDay)&&getSoLuongTonKho() > 0){
            dg = "kho ban";
        }
        return dg;
    }

    


    
}
