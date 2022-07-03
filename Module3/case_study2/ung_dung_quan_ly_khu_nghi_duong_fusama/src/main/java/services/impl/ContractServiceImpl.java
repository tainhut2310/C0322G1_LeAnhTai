package services.impl;

import models.Booking;
import models.Contract;
import models.Customer;
import services.ContractService;

import java.util.*;

public class ContractServiceImpl implements ContractService {
    static List<Contract> contractList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void creatNew() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = BookingServiceImpl.sendBooking();
        for (Booking item : bookingSet) {
            bookingQueue.add(item);
        }
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomerCode();
            System.out.println("Đang tạo hợp đồng cho booking có thông tin: " + booking.toString());
            System.out.println("Đang tạo hợp đồng cho khách hàng có thông tin: " + customer.toString());

            System.out.print("Nhập số hợp đồng: ");
            String contractNumber = scanner.nextLine();

            System.out.print("Nhập số tiền trả trước: ");
            double prepaidMoney = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập tổng tiền phải trả: ");
            double sumMoney = Double.parseDouble(scanner.nextLine());

            Contract contract = new Contract(contractNumber, booking, prepaidMoney, sumMoney, customer);
            contractList.add(contract);
            System.out.println("Đã tạo hợp đồng thành công!");
        }
    }

    @Override
    public void displayList() {
        for (Contract item : contractList) {
            System.out.println(item);
        }
    }

    @Override
    public void edit() {
        System.out.print("Nhập số hợp đồng bạn muốn edit: ");
        String contractNumber;
        boolean check = true;
        do {
            contractNumber = scanner.nextLine();
            for (int i = 0; i < contractList.size(); i++) {
                if (contractNumber.equals(contractList.get(i).getContractNumber())) {
                    check = false;

                    Booking booking = contractList.get(i).getBookingCode();
                    Customer customer = contractList.get(i).getCustomerCode();

                    System.out.print("Nhập số hợp đồng mới: ");
                    String newContractNumber = scanner.nextLine();

                    System.out.print("Nhập số tiền trả trước: ");
                    double newPrepaidMoney = Double.parseDouble(scanner.nextLine());

                    System.out.print("Nhập tổng tiền phải trả: ");
                    double newSumMoney = Double.parseDouble(scanner.nextLine());

                    contractList.set(i, new Contract(newContractNumber, booking, newPrepaidMoney, newSumMoney, customer));
                    System.out.println("Đã edit hợp đồng thành công!");
                    break;
                }
            }
            if (check) {
                System.out.print("Số hợp đồng không tồn tại! Xin nhập lại:");
            }
        } while (check);
    }
}
