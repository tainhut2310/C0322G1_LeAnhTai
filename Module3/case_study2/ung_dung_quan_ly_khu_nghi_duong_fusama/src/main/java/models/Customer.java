package models;

public class Customer extends Person {
    private String typeOfCustomer;
    private String address;

    public Customer() {
    }

    public Customer(String id,
                    String name,
                    String dateOfBirth,
                    String gender,
                    String idCard,
                    String phoneNumber,
                    String email,
                    String typeOfCustomer,
                    String address) {
        super(id, name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getName(),
                super.getDateOfBirth(),
                super.getGender(),
                super.getIdCard(),
                super.getPhoneNumber(),
                super.getEmail(),
                this.typeOfCustomer,
                this.address + "\n");
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
