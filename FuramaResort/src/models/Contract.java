package models;

public class Contract {
    private String contractNumber;
    private Booking bookingCode;
    private double deposit;
    private double sumMoney;
    private Customer customerCode;

    public Contract() {
    }

    public Contract(String contractNumber, Booking bookingCode, double deposit, double sumMoney, Customer customerCode) {
        this.contractNumber = contractNumber;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.sumMoney = sumMoney;
        this.customerCode = customerCode;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Booking getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(Booking bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Customer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Customer customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractNumber=" + contractNumber +
                ", bookingCode=" + bookingCode.getBookingCode() +
                ", deposit=" + deposit +
                ", sumMoney=" + sumMoney +
                ", customerCode=" + customerCode.getId() +
                '}';
    }
}
