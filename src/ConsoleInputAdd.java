public class ConsoleInputAdd extends ConsoleInput {
    @Override
    public HangHoa nhapHangHoa() {
        System.out.print("+ Nhập mã hàng hóa: ");
        String maHH = input.nextLine();
        HangHoa hangHoa = super.nhapHangHoa();
        if (hangHoa instanceof HangThucPham) {
            hangHoa.setMaHang(maHH);
        } else if (hangHoa instanceof HangDienMay) {
            hangHoa.setMaHang(maHH);
        } else {
            hangHoa.setMaHang(maHH);
        }
        return hangHoa;
    }
}
