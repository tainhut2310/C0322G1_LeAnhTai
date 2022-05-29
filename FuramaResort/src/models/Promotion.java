package models;

public class Promotion {
    private int numericalOrder;
    private Customer idCustomer;
    private Booking bookingDate;
    private String typeVoucher;

    public Promotion() {
    }

    public Promotion(int numericalOrder, Customer idCustomer, Booking bookingDate, String typeVoucher) {
        this.numericalOrder = numericalOrder;
        this.idCustomer = idCustomer;
        this.bookingDate = bookingDate;
        this.typeVoucher = typeVoucher;
    }

    public int getNumericalOrder() {
        return numericalOrder;
    }

    public void setNumericalOrder(int numericalOrder) {
        this.numericalOrder = numericalOrder;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Booking getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Booking bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTypeVoucher() {
        return typeVoucher;
    }

    public void setTypeVoucher(String typeVoucher) {
        this.typeVoucher = typeVoucher;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "numericalOrder=" + numericalOrder +
                ", idCustomer=" + idCustomer.getId() +
                ", bookingDate=" + bookingDate.getStartDate() +
                ", typeVoucher='" + typeVoucher + '\'' +
                '}';
    }
}
