package models;

public class Employee extends Person {
    private int educationDegree;
    private int position;
    private int division;

    public Employee() {
    }

    public Employee(int id,
                    String name,
                    String dateOfBirth,
                    String idCard,
                    String phoneNumber,
                    String email,
                    String address,
                    int educationDegree,
                    int position,
                    int division) {
        super(id, name, dateOfBirth, idCard, phoneNumber, email, address);
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
    }

    public int getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(int educationDegree) {
        this.educationDegree = educationDegree;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }
}
