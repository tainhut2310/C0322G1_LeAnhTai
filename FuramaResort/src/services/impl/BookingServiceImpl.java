package services.impl;

import models.*;
import services.BookingService;
import utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    static {
        customerList.add(new Customer(1, "Hùng", 25, "Male", "3432454545", "645655655465", "hung@gmail.com", "Vip", "ĐN"));
        customerList.add(new Customer(2, "Minh", 25, "Male", "3437674545", "66585465", "minh@gmail.com", "Vip", "ĐN"));
        customerList.add(new Customer(3, "Thủy", 25, "Female", "3468654545", "6457665655465", "thuy@gmail.com", "Vip", "ĐN"));

        facilityIntegerMap.put(new Villa("1", "Villa", 150, 500, 50, "Day", "Villa1", 10, 5), 0);
        facilityIntegerMap.put(new Villa("2", "Villa", 100, 400, 40, "Day", "Villa2", 10, 5), 0);
        facilityIntegerMap.put(new Villa("3", "Villa", 90, 300, 30, "Day", "Villa3", 10, 5), 0);
        facilityIntegerMap.put(new House("4", "House", 90, 300, 30, "Day", "House 1", 10), 0);
        facilityIntegerMap.put(new House("5", "House", 90, 300, 30, "Day", "House 2", 5), 0);

    }

    @Override
    public void displayBooking() {
        for (Booking item : bookingSet) {
            System.out.println(item);
        }
    }

    @Override
    public void addNewBooking() {
        int idBooking = 1;
        if (!bookingSet.isEmpty()) {
            idBooking = bookingSet.size() + 1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.print("Nhập ngày bắt đầu: ");
        String startDate = scanner.nextLine();
        System.out.print("Nhập ngày kết thúc: ");
        String endDate = scanner.nextLine();
        Booking booking = new Booking(idBooking, startDate, endDate, customer, facility, facility);
        bookingSet.add(booking);
        System.out.println("Đã booking thành công!");
    }

    public static Set<Booking> sendBooking() {
        return bookingSet;
    }

    public static Customer chooseCustomer() {
        System.out.println("Danh sách khách hàng:");
        for (Customer item : customerList) {
            System.out.println(item);
        }
        System.out.print("Nhập Id khách hàng: ");
        int idCustomer = Integer.parseInt(scanner.nextLine());
        boolean check = true;
        while (check) {
            for (Customer item : customerList) {
                if (idCustomer == item.getId()) {
                    check = false;
                    return item;
                }
            }
            if (check) {
                System.out.print("Nhập ID không có trong danh sách, xin nhập lại: ");
                idCustomer = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility() {
        System.out.println("Danh sách dịch vụ:");
        for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
            System.out.println(item);
        }
        System.out.print("Nhập mã dịch vụ: ");
        String nameService = scanner.nextLine();
        boolean check = true;
        while (check) {
            for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
                if (nameService.equals(item.getKey().getIdFacility())) {
                    check = false;
                    item.setValue(item.getValue() + 1);
                    return item.getKey();
                }
            }
            if (check) {
                System.out.print("Nhập ID không có trong danh sách, xin nhập lại: ");
                nameService = scanner.nextLine();
            }
        }
        return null;
    }
}
