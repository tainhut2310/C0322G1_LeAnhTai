package model;

public class KhachHang {
    private int maKH;
    private String nameKH;
    private String ngaySinh;
    private String gioiTinh;
    private String dienThoai;
    private String diaChi;

    public KhachHang() {
    }

    public KhachHang(int maKH, String nameKH, String ngaySinh, String gioiTinh, String dienThoai, String diaChi) {
        this.maKH = maKH;
        this.nameKH = nameKH;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getNameKH() {
        return nameKH;
    }

    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKH=" + maKH +
                ", nameKH='" + nameKH + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", dienThoai='" + dienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
