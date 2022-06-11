package services.impl;

import exception.CheckException;
import models.*;
import services.BookingService;
import utils.BookingComparator;
import utils.ReadAndWrite;
import utils.RegexData;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    public static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    @Override
    public void display() {
        List<String[]> list = ReadAndWrite.readFile("src\\data\\booking.csv");
        List<String[]> customerList = ReadAndWrite.readFile("src\\data\\customer.csv");
        List<String[]> villaList = ReadAndWrite.readFile("src\\data\\villa.csv");
        List<String[]> houseList = ReadAndWrite.readFile("src\\data\\house.csv");
        List<String[]> roomList = ReadAndWrite.readFile("src\\data\\room.csv");
        bookingSet.clear();
        for (String[] item : list) {
            Customer customer = null;
            for (String[] itemCustomer : customerList) {
                if (item[3].equals(itemCustomer[0])) {
                    customer = new Customer(itemCustomer[0],
                            itemCustomer[1],// thêm đủ thông tin Customer
                            itemCustomer[2],
                            itemCustomer[3],
                            itemCustomer[4],
                            itemCustomer[5],
                            itemCustomer[6],
                            itemCustomer[7],
                            itemCustomer[8]);
                    break;
                }
            }
            Facility facility = null;
            for (String[] itemVilla : villaList) {
                if (item[4].equals(itemVilla[0])) {
                    facility = new Villa(itemVilla[0],
                            itemVilla[1],
                            Double.parseDouble(itemVilla[2]),
                            Double.parseDouble(itemVilla[3]),
                            Integer.parseInt(itemVilla[4]),
                            itemVilla[5],
                            itemVilla[6],
                            Double.parseDouble(itemVilla[7]),
                            Integer.parseInt(itemVilla[8]));
                    break;
                }
            }
            for (String[] itemHouse : houseList) {
                if (item[4].equals(itemHouse[0])) {
                    facility = new House(itemHouse[0],
                            itemHouse[1],
                            Double.parseDouble(itemHouse[2]),
                            Double.parseDouble(itemHouse[3]),
                            Integer.parseInt(itemHouse[4]),
                            itemHouse[5],
                            itemHouse[6],
                            Integer.parseInt(itemHouse[7]));
                    break;
                }
            }
            for (String[] itemRoom : roomList) {
                if (item[4].equals(itemRoom[0])) {
                    facility = new Room(itemRoom[0],
                            itemRoom[1],
                            Double.parseDouble(itemRoom[2]),
                            Double.parseDouble(itemRoom[3]),
                            Integer.parseInt(itemRoom[4]),
                            itemRoom[5],
                            itemRoom[6]);
                    break;
                }
            }
            Booking booking = new Booking(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    customer,
                    facility);
            bookingSet.add(booking);
        }
        for (Booking item : bookingSet) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        List<String[]> list = ReadAndWrite.readFile("src\\data\\booking.csv");
        List<String[]> customerList = ReadAndWrite.readFile("src\\data\\customer.csv");
        List<String[]> villaList = ReadAndWrite.readFile("src\\data\\villa.csv");
        List<String[]> houseList = ReadAndWrite.readFile("src\\data\\house.csv");
        List<String[]> roomList = ReadAndWrite.readFile("src\\data\\room.csv");
        bookingSet.clear();
        for (String[] item : list) {
            Customer customer = null;
            for (String[] itemCustomer : customerList) {
                if (item[3].equals(itemCustomer[0])) {
                    customer = new Customer(itemCustomer[0],
                            itemCustomer[1],// thêm đủ thông tin Customer
                            itemCustomer[2],
                            itemCustomer[3],
                            itemCustomer[4],
                            itemCustomer[5],
                            itemCustomer[6],
                            itemCustomer[7],
                            itemCustomer[8]);
                    break;
                }
            }
            Facility facility = null;
            for (String[] itemVilla : villaList) {
                if (item[4].equals(itemVilla[0])) {
                    facility = new Villa(itemVilla[0],
                            itemVilla[1],
                            Double.parseDouble(itemVilla[2]),
                            Double.parseDouble(itemVilla[3]),
                            Integer.parseInt(itemVilla[4]),
                            itemVilla[5],
                            itemVilla[6],
                            Double.parseDouble(itemVilla[7]),
                            Integer.parseInt(itemVilla[8]));
                    break;
                }
            }
            for (String[] itemHouse : houseList) {
                if (item[4].equals(itemHouse[0])) {
                    facility = new House(itemHouse[0],
                            itemHouse[1],
                            Double.parseDouble(itemHouse[2]),
                            Double.parseDouble(itemHouse[3]),
                            Integer.parseInt(itemHouse[4]),
                            itemHouse[5],
                            itemHouse[6],
                            Integer.parseInt(itemHouse[7]));
                    break;
                }
            }
            for (String[] itemRoom : roomList) {
                if (item[4].equals(itemRoom[0])) {
                    facility = new Room(itemRoom[0],
                            itemRoom[1],
                            Double.parseDouble(itemRoom[2]),
                            Double.parseDouble(itemRoom[3]),
                            Integer.parseInt(itemRoom[4]),
                            itemRoom[5],
                            itemRoom[6]);
                    break;
                }
            }
            Booking booking = new Booking(Integer.parseInt(item[0]),
                    item[1],
                    item[2],
                    customer,
                    facility);
            bookingSet.add(booking);
        }
        int idBooking = 1;
        if (!bookingSet.isEmpty()) {
            idBooking = bookingSet.size() + 1;
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
            System.out.print("Nhập ngày bắt đầu: ");
            String startDate = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);

            System.out.print("Nhập ngày kết thúc: ");
            String endDate = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);

            Booking booking = new Booking(idBooking, startDate, endDate, customer, facility);
            bookingSet.add(booking);
            System.out.println("Đã booking thành công!");
        String line = "";
        for (Booking item : bookingSet) {
            line += item.getBookingCode() + ","
                    + item.getStartDate() + ","
                    + item.getEndDate() + ","
                    + item.getCustomerCode().getId() + ","
                    + item.getIdFacility().getIdFacility() + "\n";
        }
        ReadAndWrite.writeFile("src\\data\\booking.csv", line);
    }

    public static Set<Booking> sendBooking() {
        return bookingSet;
    }

    public static Customer chooseCustomer() {
        List<String[]> listStr = ReadAndWrite.readFile("src\\data\\customer.csv");
        customerList.clear();
        for (String[] item : listStr) {
            Customer customer = new Customer(item[0],
                    item[1],
                    item[2],
                    item[3],
                    item[4],
                    item[5],
                    item[6],
                    item[7],
                    item[8]);
            customerList.add(customer);
        }
        System.out.println("Danh sách khách hàng:");
        for (Customer item : customerList) {
            System.out.println(item);
        }
        System.out.print("Nhập Id khách hàng: ");
        boolean check = true;
        String idCustomer;
        while (check) {
                idCustomer = CheckException.checkString(scanner.nextLine());
                for (Customer item : customerList) {
                    if (idCustomer.equals(item.getId())) {
                        check = false;
                        return item;
                    }
                }
                if (check) {
                    System.out.print("Nhập ID không có trong danh sách, xin nhập lại: ");
                }
        }
        return null;
    }

    public static Facility chooseFacility() {
        List<String[]> villaList = ReadAndWrite.readFile("src\\data\\villa.csv");
        List<String[]> houseList = ReadAndWrite.readFile("src\\data\\house.csv");
        List<String[]> roomList = ReadAndWrite.readFile("src\\data\\room.csv");
        facilityIntegerMap.clear();
        for (String[] item : villaList) {
            Villa villa = new Villa(item[0],
                    item[1],
                    Double.parseDouble(item[2]),
                    Double.parseDouble(item[3]),
                    Integer.parseInt(item[4]),
                    item[5],
                    item[6],
                    Double.parseDouble(item[7]),
                    Integer.parseInt(item[8]));
            facilityIntegerMap.put(villa,0);
        }
        for (String[] itemHouse : houseList) {
            House house = new House(itemHouse[0],
                    itemHouse[1],
                    Double.parseDouble(itemHouse[2]),
                    Double.parseDouble(itemHouse[3]),
                    Integer.parseInt(itemHouse[4]),
                    itemHouse[5],
                    itemHouse[6],
                    Integer.parseInt(itemHouse[7]));
            facilityIntegerMap.put(house,0);
        }
        for (String[] itemRoom : roomList) {
                Room room = new Room(itemRoom[0],
                        itemRoom[1],
                        Double.parseDouble(itemRoom[2]),
                        Double.parseDouble(itemRoom[3]),
                        Integer.parseInt(itemRoom[4]),
                        itemRoom[5],
                        itemRoom[6]);
                facilityIntegerMap.put(room,0);
            }
        System.out.println("Danh sách dịch vụ:");
        for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
            System.out.println(item);
        }
        System.out.print("Nhập mã dịch vụ: ");
        String nameService;
        boolean check = true;
        while (check) {
            nameService = CheckException.checkString(scanner.nextLine());
            for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
                if (nameService.equals(item.getKey().getIdFacility())) {
                    check = false;
                    item.setValue(item.getValue() + 1);
                    return item.getKey();
                }
            }
            if (check) {
                System.out.print("Nhập ID không có trong danh sách, xin nhập lại: ");
            }
        }
        return null;
    }
}
