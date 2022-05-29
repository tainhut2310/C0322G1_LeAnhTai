package services.impl;

import models.Facility;
import models.House;
import models.Room;
import models.Villa;
import services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + element.getKey() + "số lần đã thuê " + element.getValue());
        }
    }

    @Override
    public void addNewVilla() {
        System.out.print("Nhập mã dịch vụ: ");
        String idFacility = scanner.nextLine();
        System.out.print("Nhập tên dịch vụ: ");
        String nameService = scanner.nextLine();
        System.out.print("Nhập diện tích sử dụng: ");
        double usableArea = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập chi phí thuê: ");
        double rentalCosts = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng người tối đa: ");
        int maximumNumberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.print("Nhập tiêu chuẩn phòng: ");
        String typeVilla = scanner.nextLine();
        System.out.print("Nhập diện tích hồ bơi: ");
        double areaPool = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số tầng: ");
        int floors = Integer.parseInt(scanner.nextLine());
        Villa villa = new Villa(idFacility, nameService, usableArea, rentalCosts, maximumNumberOfPeople, rentalType, typeVilla, areaPool, floors);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Đã thêm mới thành công!");
    }

    @Override
    public void addNewHouse() {
        System.out.print("Nhập mã dịch vụ: ");
        String idFacility = scanner.nextLine();
        System.out.print("Nhập tên dịch vụ: ");
        String nameService = scanner.nextLine();
        System.out.print("Nhập diện tích sử dụng: ");
        double usableArea = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập chi phí thuê: ");
        double rentalCosts = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng người tối đa: ");
        int maximumNumberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.print("Nhập tiêu chuẩn phòng: ");
        String typeHouse = scanner.nextLine();
        System.out.println("Nhập số tầng: ");
        int floors = Integer.parseInt(scanner.nextLine());
        House house = new House(idFacility, nameService, usableArea, rentalCosts, maximumNumberOfPeople, rentalType, typeHouse, floors);
        facilityIntegerMap.put(house, 0);
        System.out.println("Đã thêm mới thành công!");
    }

    @Override
    public void addNewRoom() {
        System.out.print("Nhập mã dịch vụ: ");
        String idFacility = scanner.nextLine();
        System.out.print("Nhập tên dịch vụ: ");
        String nameService = scanner.nextLine();
        System.out.print("Nhập diện tích sử dụng: ");
        double usableArea = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập chi phí thuê: ");
        double rentalCosts = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng người tối đa: ");
        int maximumNumberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập kiểu thuê: ");
        String rentalType = scanner.nextLine();
        System.out.print("Nhập dịch vụ miễn phí: ");
        String serviceFree = scanner.nextLine();
        Room room = new Room(idFacility, nameService, usableArea, rentalCosts, maximumNumberOfPeople, rentalType, serviceFree);
        facilityIntegerMap.put(room, 0);
        System.out.println("Đã thêm mới thành công!");
    }
}
