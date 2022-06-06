package quan_ly_cong_ty_abc.model;

public class ProductionStaff extends Staff {
    private String productNumber;
    private String pricePerProduct;

    public ProductionStaff() {
    }

    public ProductionStaff(int id,
                           String idStaff,
                           String name,
                           String birthdayDate,
                           String address,
                           String productNumber,
                           String pricePerProduct) {
        super(id, idStaff, name, birthdayDate, address);
        this.productNumber = productNumber;
        this.pricePerProduct = pricePerProduct;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(String pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    @Override
    public String getInfo() {
       return String.format("%s,%s,%s,%s,%s,%s,%s",
                getId(),
                getIdStaff(),
                getName(),
                getBirthdayDate(),
                getAddress(),
                productNumber,
                pricePerProduct + "\n");
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " + productNumber +
                ", " + pricePerProduct;
    }
}
