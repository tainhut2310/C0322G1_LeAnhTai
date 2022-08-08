package model.validate;

public class Validate {
    public static final String NAME_CUSTOMER = "^([A-Z\\P{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\P{L}]{1}[a-z\\p{L}]*))*$";
    public static final String NAME_FACILITY = "^([A-Z\\P{L}]{1}[a-z\\d\\p{L}]*)+(\\s([A-Z\\P{L}]{1}[a-z\\d\\p{L}]*))*$";
    public static final String PHONE_NUMBER = "^090|091\\d{7}$";
    public static final String ID_CARD = "\\d{9}";

    public static boolean checkNameCustomer(String name) {
        return name.matches(NAME_CUSTOMER);
    }

    public static boolean checkNameFacility(String name) {
        return name.matches(NAME_FACILITY);
    }

    public static boolean checkPhoneNumber(String name) {
        return name.matches(PHONE_NUMBER);
    }
    public static boolean checkIdCard(String name) {
        return name.matches(ID_CARD);
    }
}
