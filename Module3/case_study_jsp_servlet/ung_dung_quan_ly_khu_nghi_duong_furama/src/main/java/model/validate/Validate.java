package model.validate;

public class Validate {
    public static final String NAME = "^([A-Z\\P{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\P{L}]{1}[a-z\\p{L}]*))*$";
    public static final String NAME_FACILITY = "^([A-Z\\P{L}]{1}[a-z\\d\\p{L}]*)+(\\s([A-Z\\P{L}]{1}[a-z\\d\\p{L}]*))*$";
    public static final String PHONE_NUMBER = "^09[0|1][0-9]{7}$";
    public static final String ID_CARD = "\\d{9}";
    public static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String SALARY = "^[1-9][0-9]*";
    public static final String POSITIVE_NUMBER = "^[1-9][0-9]*";


    public static boolean checkName(String name) {
        return name.matches(NAME);
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

    public static boolean checkEmail(String mail) {
        return mail.matches(EMAIL);
    }

    public static boolean checkSalary(String salary) {
        return salary.matches(SALARY);
    }

    public static boolean checkPositive(String value) {
        return value.matches(POSITIVE_NUMBER);
    }



}
