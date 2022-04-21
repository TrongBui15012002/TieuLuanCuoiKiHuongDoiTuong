import java.text.NumberFormat;
import java.util.Locale;

public abstract class HangHoa {
    private String maHang;
    private String tenHang;
    private int soLuongTonKho;
    private double donGia;

    // hàm tạo không tham số
    public HangHoa() {

    }

    // hàm tạo k có mã hàng hóa
    public HangHoa(String tenHang, int soLuongTonKho, double donGia) {
        this.setTenHang(tenHang);
        this.setSoLuongTonKho(soLuongTonKho);
        this.setDonGia(donGia);
    }

    // hàm tạo có tham số đầy đủ
    public HangHoa(String maHang, String tenHang, int soLuongTonKho, double donGia) {
        this.setMaHang(maHang);
        this.setTenHang(tenHang);
        this.setSoLuongTonKho(soLuongTonKho);
        this.setDonGia(donGia);
    }

    

   

    public String getMaHang() {
        return maHang;
    }

    

    // mã hàng không được sửa và không để trống
    public void setMaHang(String maHang) {
        if (maHang == null) {
            System.out.println("- Mã hàng không được để trống.");
        } else {
            this.maHang = maHang;
        }
    }

    public String getTenHang() {
        return tenHang;
    }

    // tên hàng không để trống
    public void setTenHang(String tenHang) {
        if (tenHang == null) {
            System.out.println("- Tên hàng không được để trống.");
        } else {
            this.tenHang = tenHang;
        }
    }

    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }

    // số lượng tồn kho >= 0
    public void setSoLuongTonKho(int soLuongTonKho) {
        if (soLuongTonKho < 0) {
            System.out.println("- Số lượng tồn kho phải >= 0.");
        } else {
            this.soLuongTonKho = soLuongTonKho;
        }
    }

    public double getDonGia() {
        return donGia;
    }

    // đơn giá > 0
    public void setDonGia(double donGia) {
        if (donGia < 0) {
            System.out.println("- Đơn giá phải lớn hơn 0.");
        } else {
            this.donGia = donGia;
        }
    }

    @Override
    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getInstance(localeVN)  ;
        String tt = numberFormat.format(donGia);
        return "\nMa hang: " + maHang + "\nTen hang: " + tenHang + "\nSo luong ton kho: " + soLuongTonKho
                + "\nDon gia: " + tt;
    }

    // VAT
    public abstract double VAT();

    public abstract String danhGia();

}
