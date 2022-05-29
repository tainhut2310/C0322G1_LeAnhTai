package models;

public class Booking {
    private int bookingCode;
    private String startDate;
    private String endDate;
    private Customer customerCode;
    private Facility serviceName;
    private Facility idService;

    public Booking() {
    }

    public Booking(int bookingCode,
                   String startDate,
                   String endDate,
                   Customer customerCode,
                   Facility serviceName,
                   Facility idService) {
        this.bookingCode = bookingCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.serviceName = serviceName;
        this.idService = idService;
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

    public Facility getServiceName() {
        return serviceName;
    }

    public void setServiceName(Facility serviceName) {
        this.serviceName = serviceName;
    }

    public Facility getIdService() {
        return idService;
    }

    public void setIdService(Facility idService) {
        this.idService = idService;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode=" + bookingCode +
                ", startDay=" + startDate +
                ", endDay=" + endDate +
                ", customerCode=" + customerCode.getId() +
                ", serviceName='" + serviceName.getNameService() + '\'' +
                ", idService='" + idService.getIdFacility() + '\'' +
                '}';
    }
}
