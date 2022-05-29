package models;

public class Employee extends Person {
    private String level;
    private String workingPosition;
    private double salary;

    public Employee() {
    }

    public Employee(int id,
                    String name,
                    int age,
                    String gender,
                    String idCard,
                    String phoneNumber,
                    String email,
                    String level,
                    String workingPosition,
                    double salary) {
        super(id, name, age, gender, idCard, phoneNumber, email);
        this.level = level;
        this.workingPosition = workingPosition;
        this.salary = salary;
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
