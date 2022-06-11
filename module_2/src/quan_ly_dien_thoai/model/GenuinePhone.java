package quan_ly_dien_thoai.model;

public class GenuinePhone extends Phone{
    private String warrantyPeriod;
    private String warrantyCoverage;

    public GenuinePhone() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                getIdPhone(),
                getNamePhone(),
                getPrice(),
                getAmount(),
                getProducer(),
                warrantyPeriod,
                warrantyCoverage + "\n");
    }

    public GenuinePhone(int idPhone,
                        String namePhone,
                        String price,
                        String amount,
                        String producer,
                        String warrantyPeriod,
                        String warrantyCoverage) {
        super(idPhone, namePhone, price, amount, producer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyCoverage = warrantyCoverage;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getWarrantyCoverage() {
        return warrantyCoverage;
    }

    public void setWarrantyCoverage(String warrantyCoverage) {
        this.warrantyCoverage = warrantyCoverage;
    }
}
