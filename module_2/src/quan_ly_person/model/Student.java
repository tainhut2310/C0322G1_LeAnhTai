package quan_ly_person.model;

import java.time.LocalDate;

public class Student extends Person {
    private String studentCode;
    private double dtb;

    public Student() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getId(),
                getName(),
                getGender(),
                getBirthday(),
                getAddress(),
                studentCode,
                dtb + "\n");
    }

    public Student(int id,
                   String name,
                   String gender,
                   LocalDate birthday,
                   String address,
                   String studentCode,
                   double dtb) {
        super(id, name, gender, birthday, address);
        this.studentCode = studentCode;
        this.dtb = dtb;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "studentCode='" + studentCode + '\'' +
                ", dtb=" + dtb +
                '}';
    }
}
