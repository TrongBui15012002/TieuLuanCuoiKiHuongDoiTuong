import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangSanhSu extends HangHoa{
    private String nhaSX;
    private Date ngayNhapKho;
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    //hàm tạo đầy đủ
    public HangSanhSu(String maHang, String tenHang, int soLuongTonKho, double donGia, String nhaSX, String nhapKho){
        super(maHang, tenHang, soLuongTonKho, donGia);
        this.nhaSX = nhaSX;
        try {
            ngayNhapKho = date.parse(nhapKho);
        } catch (ParseException e) {
            System.out.println("- Sai định dạng ngày nhập kho.");
        }
    }
    //hàm tạo k có mã hàng hóa
    public HangSanhSu(String tenHang, int soLuongTonKho, double donGia, String nhaSX, String nnk) {
        super(tenHang, soLuongTonKho, donGia);
        this.nhaSX = nhaSX;
        try {
            ngayNhapKho = date.parse(nnk);
        } catch (ParseException e) {
           System.out.println("- Sai định dạng ngày nhập kho.");
        }
    }
    //hàm tạo chỉ có mã hàng hóa
  
    
    public String getNhaSX() {
        return nhaSX;
    }
    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
    
    @Override
    public String toString() {
        return "\nLoai hang hoa: Sanh su" + super.toString()+"\nNgay nhap kho: "
         + date.format(ngayNhapKho) + "\nNha san xuat: " + nhaSX;
    }
    @Override
    public double VAT() {
        double vat = 0.1 * getDonGia();
        return vat;
    }
    @Override
    public String danhGia() {
        String dg = "khong danh gia";
        Date toDay = new Date();
        long tg = toDay.getTime() - ngayNhapKho.getTime();
        long day = tg/(24*60*60*1000);
        if(getSoLuongTonKho() > 50 && day > 10){
            dg = "ban cham";
        } 
        return dg;
    }
    
}
