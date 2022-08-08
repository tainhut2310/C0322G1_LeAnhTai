package model;

public class Contract {
    private int id;
    String nameFacility;
    String nameCustomer;
    private String startDate;
    private String endDate;
    private double deposit;
    private double totalMoney;

    public Contract() {
    }

    public Contract(String nameFacility, String nameCustomer, String startDate, String endDate, double deposit, double totalMoney) {
        this.nameFacility = nameFacility;
        this.nameCustomer = nameCustomer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
    }

    public Contract(int id, String nameFacility, String nameCustomer, String startDate, String endDate, double deposit, double totalMoney) {
        this.id = id;
        this.nameFacility = nameFacility;
        this.nameCustomer = nameCustomer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
