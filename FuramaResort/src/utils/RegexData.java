package utils;

import exception.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);

    public static String regexString(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new StringException("Bạn đã nhập sai định dạng, tên dịch vụ phải viết hoa chữ cái đầu, không chứa ký tự số\nXin vui lòng nhập lại: ");
                }
            } catch (StringException e) {
                System.out.print(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexVilla(String temp, String regex) {
        boolean check = true;
        do {
            temp = CheckException.checkString(scanner.nextLine());
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new IdVillaException("Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng SVVL-XXXX\nXin vui lòng nhập lại: ");
                }
            } catch (IdVillaException e) {
                System.out.print(e.getMessage());
            }
        } while (check);
        return temp;
    }
//    public class IdVillaException extends Exception { Note:Class Exception tự định nghĩa
//        public IdVillaException(String message) {
//            super(message);
//        }
//    }

    public static String regexHouse(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (temp.matches(regex)) {
                    return temp;
                } else {
                    throw new IdHousetException("Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng SVHO-XXXX\nXin vui lòng nhập lại: ");
                }
            } catch (IdHousetException e) {
                System.out.print(e.getMessage());
                temp = CheckException.checkString(scanner.nextLine());
            }
        }
        return temp;
    }

    public static String regexRoom(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (temp.matches(regex)) {
                    return temp;
                } else {
                    throw new IdRoomException("Bạn đã nhập sai định dạng, mã dịch vụ phải có dạng SVRO-XXXX\nXin vui lòng nhập lại: ");
                }
            } catch (IdRoomException e) {
                System.out.print(e.getMessage());
                temp = CheckException.checkString(scanner.nextLine());
            }
        }
        return temp;
    }

    public static String regexMount(String temp, String regex) {
        boolean check = true;
        while (check) {
            temp = CheckException.checkString(scanner.nextLine());
            try {
                if (!temp.matches(regex)) {
                    check = false;
                } else {
                    throw new AmountPeopleException("Bạn đã nhập sai định dạng, số lượng người phải > 0 và < 20\nXin vui lòng nhập lại: ");
                }
            } catch (AmountPeopleException e) {
                System.out.print(e.getMessage());
                temp = CheckException.checkString(scanner.nextLine());
            }
        }
        return temp;
    }

    public static String regexInt(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = CheckException.checkString(scanner.nextLine());
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new IntException("Bạn đã nhập sai định dạng, số nhập phải là số dương\nXin vui lòng nhập lại: ");
                }
            } catch (IntException e) {
                System.out.print(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexArea(String regex) {
        boolean check = true;
        String temp;
        do {
            temp = CheckException.checkString(scanner.nextLine());
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new AreaException("Bạn đã nhập sai định dạng, diện tích phải lớn hơn 30\nXin vui lòng nhập lại: ");
                }
            } catch (AreaException e) {
                System.out.print(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexDate(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (!temp.trim().equals("") && Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(date, now).getDays();
                    if (current > 0) {
                        check = false;
                    } else {
                        throw new DateException("Ngày nhập vào lớn hơn ngày hiện tại! Xin vui lòng nhập lại: ");
                    }
                } else {
                    throw new DateException("Định dạng nhập vào không đúng! Xin vui lòng nhập lại: ");
                }
            } catch (DateException e) {
                System.out.print(e.getMessage());
            }
        }
        return temp;
    }

    public static String regexAge(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getDays();
                    if (current < 100 && current > 18) {
                        check = false;
                    } else {
                        throw new DateException("Tuổi phải < 100 và > 18! Xin vui lòng nhập lại: ");
                    }
                } else {
                    throw new DateException("Định dạng nhập vào không đúng! Xin vui lòng nhập lại: ");
                }
            } catch (DateException e) {
                System.out.print(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }

// Hàm regex tổng quát
    public static String regexStr(String temp, String regex, String error) {
        boolean check = true;
        do {
            if (temp.matches(regex)) {
                check = false;
            } else {
                System.out.println(error);
                temp = scanner.nextLine();
            }
        } while (check);
        return temp;
    }

}