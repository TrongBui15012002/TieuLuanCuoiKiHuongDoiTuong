public class HangDienMay extends HangHoa{
    private int tgBaoHanh;
    private int congSuat;
    //hàm tạo đầy đủ
    public HangDienMay(String maHang, String tenHang, int soLuongTonKho, double donGia, int tgBaoHanh, int congSuat){
        super(maHang, tenHang, soLuongTonKho, donGia);
        this.setTgBaoHanh(tgBaoHanh);
        this.setCongSuat(congSuat);
    }
    //hàm tạo k có mã hàng hóa
    public HangDienMay(String tenHang, int soLuongTonKho, double donGia, int tgBaoHanh, int congSuat) {
        super(tenHang, soLuongTonKho, donGia);
        this.tgBaoHanh = tgBaoHanh;
        this.congSuat = congSuat;
    } 
    
    public int getTgBaoHanh() {
        return tgBaoHanh;
    }
    //hàm tạo chỉ có mã hàng hóa
   
    //thời gian bảo hàng phải >0 tháng
    public void setTgBaoHanh(int tgBaoHanh) {
        if(tgBaoHanh > 0){
            this.tgBaoHanh = tgBaoHanh;
        }else{
            System.out.println("- Thời gian bảo hành phải > 0 tháng.");
        }
    }
    public int getCongSuat() {
        return congSuat;
    }
    //công suất tiêu thụ phải > 0 KW
    public void setCongSuat(int congSuat) {
        if(congSuat > 0){
            this.congSuat = congSuat;
        }else{
            System.out.println("- Công suất tiêu thụ phải > 0 KW.");
        }
    }
    @Override
    public String toString() {
        return "\nLoai hang hoa: Dien may" + super.toString()+"\nCong suat: " + congSuat +" W"+"\nThoi gian bao hanh: " 
        + tgBaoHanh + " thang";
    }
    @Override
    public double VAT() {
        double vat = 0.1*getDonGia();
        return vat;
    }
    @Override
    public String danhGia() {
        String dg = "khong ban duoc";
        if(getSoLuongTonKho() < 3){
            dg = "ban duoc";
        }
        return dg;
    }
    
    
}
