package model;

public class Module {
    int id;
    String maModule;
    int maKhoaHoc;
    String tenModule;

    public Module() {
    }

    public Module(int id, String maModule, int maKhoaHoc, String tenModule) {
        this.id = id;
        this.maModule = maModule;
        this.maKhoaHoc = maKhoaHoc;
        this.tenModule = tenModule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaModule() {
        return maModule;
    }

    public void setMaModule(String maModule) {
        this.maModule = maModule;
    }

    public int getMaKhoaHoc() {
        return maKhoaHoc;
    }

    public void setMaKhoaHoc(int maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    public String getTenModule() {
        return tenModule;
    }

    public void setTenModule(String tenModule) {
        this.tenModule = tenModule;
    }
}
