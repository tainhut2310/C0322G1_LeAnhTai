package quan_ly_dien_thoai.model;

public abstract class Phone {
    private int idPhone;
    private String namePhone;
    private String price;
    private String amount;
    private String producer;

    public Phone() {
    }

    public Phone(int idPhone, String namePhone, String price, String amount, String producer) {
        this.idPhone = idPhone;
        this.namePhone = namePhone;
        this.price = price;
        this.amount = amount;
        this.producer = producer;
    }

    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", idPhone +
                namePhone +
                price +
                amount +
                producer);
    }
}
