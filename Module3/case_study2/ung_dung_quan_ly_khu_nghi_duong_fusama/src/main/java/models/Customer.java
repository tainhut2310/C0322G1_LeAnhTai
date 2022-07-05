package models;

public class Customer extends Person {
    private int typeOfCustomer;
    private int gender;

    public Customer() {
    }

    public Customer(int id,
                    String name,
                    String dateOfBirth,
                    String idCard,
                    String phoneNumber,
                    String email,
                    String address,
                    int typeOfCustomer,
                    int gender) {
        super(id, name, dateOfBirth, idCard, phoneNumber, email, address);
        this.typeOfCustomer = typeOfCustomer;
        this.gender = gender;
    }

    public Customer(
            String name,
            String dateOfBirth,
            String idCard,
            String phoneNumber,
            String email,
            String address,
            int typeOfCustomer,
            int gender) {
        super(name, dateOfBirth, idCard, phoneNumber, email, address);
        this.typeOfCustomer = typeOfCustomer;
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(int typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }


}
