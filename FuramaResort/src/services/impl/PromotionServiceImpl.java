package services.impl;

import models.Booking;
import models.Promotion;
import services.PromotionService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class PromotionServiceImpl implements PromotionService {
    public static Scanner scanner = new Scanner(System.in);
    static Set<Promotion> promotionSet = new TreeSet<>();

    @Override
    public void displayUseService() {
        Set<Booking> bookingSet = BookingServiceImpl.sendBooking();
        System.out.print("Nhập năm khách hàng sử dụng dịch vụ: ");
        int yearUseService = Integer.parseInt(scanner.nextLine());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate;
        for (Booking item : bookingSet) {
            startDate = LocalDate.parse(item.getStartDate(), formatter);
            if (yearUseService == startDate.getYear()) {
                System.out.println(item.toString());
            }
        }
    }

    @Override
    public void displayGetVoucher() {
        Stack<Booking> bookingStack = new Stack<>();
        Set<Booking> bookingSet = BookingServiceImpl.sendBooking();
        System.out.print("Nhập số lượng voucher khuyến mãi 10%: ");
        int voucher10 = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số lượng voucher khuyến mãi 20%: ");
        int voucher20 = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số lượng voucher khuyến mãi 50%: ");
        int voucher50 = Integer.parseInt(scanner.nextLine());
        int sumVoucher = voucher10 + voucher20 + voucher50;
        int i = 0;
        for (Booking item : bookingSet) {
            if (i < sumVoucher && i < bookingSet.size()) {
                bookingStack.push(item);
            }
            i++;
        }
        while (voucher10 > 0 && !bookingStack.isEmpty()) {
            System.out.println(bookingStack.pop() + "Voucher khuyến mãi 10%!");
            voucher10--;
        }
        while (voucher20 > 0 && !bookingStack.isEmpty()) {
            System.out.println(bookingStack.pop() + "Voucher khuyến mãi 20%!");
            voucher20--;
        }
        while (voucher50 > 0 && !bookingStack.isEmpty()) {
            System.out.println(bookingStack.pop() + "Voucher khuyến mãi 10%!");
            voucher50--;
        }
    }
}
