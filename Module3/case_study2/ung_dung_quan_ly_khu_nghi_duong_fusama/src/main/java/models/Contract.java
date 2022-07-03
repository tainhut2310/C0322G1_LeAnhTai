package models;

public class Booking {
    private int contractId;
    private String startDate;
    private String endDate;
    private double deposit;
    private double totalMoney;

    public Booking() {
    }

    public Booking(int bookingCode,
                   String startDate,
                   String endDate,
                   Customer customerCode,
                   Facility idFacility) {
        this.bookingCode = bookingCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.idFacility = idFacility;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
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

    public Customer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Customer customerCode) {
        this.customerCode = customerCode;
    }

    public Facility getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(Facility idFacility) {
        this.idFacility = idFacility;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode=" + bookingCode +
                ", startDay=" + startDate +
                ", endDay=" + endDate +
                ", customerCode=" + customerCode.getId() +
                ", idFacility='" + idFacility.getIdFacility() +
                '}';
    }
}
