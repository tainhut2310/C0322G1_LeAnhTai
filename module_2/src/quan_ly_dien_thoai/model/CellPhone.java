package quan_ly_dien_thoai.model;

public class CellPhone extends Phone {
    private String countryPortable;
    private String status;

    public CellPhone() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getIdPhone(),
                getNamePhone(),
                getPrice(),
                getAmount(),
                getProducer(),
                countryPortable,
                status + "\n");
    }

    public CellPhone(int idPhone,
                     String namePhone,
                     String price,
                     String amount,
                     String producer,
                     String countryPortable,
                     String status) {
        super(idPhone, namePhone, price, amount, producer);
        this.countryPortable = countryPortable;
        this.status = status;
    }

    public String getCountryPortable() {
        return countryPortable;
    }

    public void setCountryPortable(String countryPortable) {
        this.countryPortable = countryPortable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
