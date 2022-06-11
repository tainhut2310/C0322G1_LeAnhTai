package quan_ly_person.model;

import java.time.LocalDate;

public class Teacher extends Person {
    private String lopDay;
    private double luongMotGio;
    private double soGioTrongThang;

    public Teacher() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                getId(),
                getName(),
                getGender(),
                getBirthday(),
                getAddress(),
                lopDay,
                luongMotGio,
                soGioTrongThang + "\n");
    }

    public Teacher(int id,
                   String name,
                   String gender,
                   LocalDate birthday,
                   String address,
                   String lopDay,
                   double luongMotGio,
                   double soGioTrongThang) {
        super(id, name, gender, birthday, address);
        this.lopDay = lopDay;
        this.luongMotGio = luongMotGio;
        this.soGioTrongThang = soGioTrongThang;
    }

    public String getLopDay() {
        return lopDay;
    }

    public void setLopDay(String lopDay) {
        this.lopDay = lopDay;
    }

    public double getLuongMotGio() {
        return luongMotGio;
    }

    public void setLuongMotGio(double luongMotGio) {
        this.luongMotGio = luongMotGio;
    }

    public double getSoGioTrongThang() {
        return soGioTrongThang;
    }

    public void setSoGioTrongThang(double soGioTrongThang) {
        this.soGioTrongThang = soGioTrongThang;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                "lopDay='" + lopDay + '\'' +
                ", luongMotGio=" + luongMotGio +
                ", soGioTrongThang=" + soGioTrongThang +
                '}';
    }
}
