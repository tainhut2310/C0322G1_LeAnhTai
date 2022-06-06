package quan_ly_cong_ty_abc.model;

public class ManagementStaff extends Staff {
    private String basicSalary;
    private String coefficientsSalary;

    public ManagementStaff() {
    }

    public ManagementStaff(int id,
                           String idStaff,
                           String name,
                           String birthdayDate,
                           String address,
                           String basicSalary,
                           String coefficientsSalary) {
        super(id, idStaff, name, birthdayDate, address);
        this.basicSalary = basicSalary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(String coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getId(),
                getIdStaff(),
                getName(),
                getBirthdayDate(),
                getAddress(),
                basicSalary,
                coefficientsSalary + "\n");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " + basicSalary +
                ", " + coefficientsSalary;
    }
}
