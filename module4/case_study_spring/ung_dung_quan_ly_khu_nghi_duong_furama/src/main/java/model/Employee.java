package model;

public class Employee {
    private int id;
    private String name;
    private String dateOfBirthday;
    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;
    private int positionId;
    private int educationDegreeId;
    private int divisionId;

    public Employee() {
    }

    public Employee(String name,
                    String dateOfBirthday,
                    String idCard,
                    double salary,
                    String phoneNumber,
                    String email,
                    String address,
                    int positionId,
                    int educationDegreeId,
                    int divisionId) {
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
    }

    public Employee(int id,
                    String name,
                    String dateOfBirthday,
                    String idCard,
                    double salary,
                    String phoneNumber,
                    String email,
                    String address,
                    int positionId,
                    int educationDegreeId,
                    int divisionId) {
        this.id = id;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.educationDegreeId = educationDegreeId;
        this.divisionId = divisionId;
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

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }
}
