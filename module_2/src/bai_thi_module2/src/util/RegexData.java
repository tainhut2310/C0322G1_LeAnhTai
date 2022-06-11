package util;

import exception.CheckException;

import java.util.Scanner;

public class RegexData {
        public static Scanner scanner = new Scanner(System.in);
        public static String regexInt(String temp, String regex) {
            while (true) {
                try {
                    if (temp.matches(regex) && !temp.equals("")) {
                        return temp;
                    } else {
                        throw new CheckException("Nhập sai định dạng, nhập vào phải là số dương\nXin vui lòng nhập lại: ");
                    }
                } catch (CheckException e) {
                    System.out.print(e.getMessage());
                    temp = scanner.nextLine();
                }
            }
        }
        public static String regexStr(String temp, String regex, String error) {
            boolean check = true;
            do {
                if (temp.matches(regex) && !temp.trim().equals("")) {
                    check = false;
                } else {
                    System.out.print(error);
                    temp = scanner.nextLine();
                }
            } while (check);
            return temp;
        }
    }
