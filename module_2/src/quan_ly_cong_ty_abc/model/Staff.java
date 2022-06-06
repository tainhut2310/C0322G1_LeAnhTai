package quan_ly_cong_ty_abc.model;

public abstract class Staff {
    private int id;
    private String idStaff;
    private String name;
    private String birthdayDate;
    private String address;

    public Staff() {
    }

    public Staff(int id, String idStaff, String name, String birthdayDate, String address) {
        this.id = id;
        this.idStaff = idStaff;
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",
                id,
                idStaff,
                name,
                birthdayDate,
                address);
    }
}
