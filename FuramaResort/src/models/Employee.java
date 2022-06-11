package models;

public class Employee extends Person {
    private String level;
    private String workingPosition;
    private double salary;

    public Employee() {
    }

    public Employee(String id,
                    String name,
                    String dateOfBirth,
                    String gender,
                    String idCard,
                    String phoneNumber,
                    String email,
                    String level,
                    String workingPosition,
                    double salary) {
        super(id, name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.level = level;
        this.workingPosition = workingPosition;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getName(),
                super.getDateOfBirth(),
                super.getGender(),
                super.getIdCard(),
                super.getPhoneNumber(),
                super.getEmail(),
                this.level,
                this.workingPosition,
                this.salary + "\n");
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getWorkingPosition() {
        return workingPosition;
    }

    public void setWorkingPosition(String workingPosition) {
        this.workingPosition = workingPosition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "level='" + level + '\'' +
                ", workingPosition: '" + workingPosition + '\'' +
                ", salary: " + salary +
                '}';
    }
}
