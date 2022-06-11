package services.impl;

import models.*;
import services.FacilityService;
import utils.ReadAndWrite;
import utils.RegexData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_ID_HOUSE = "(SVHO)[-][\\d]{4}";
    public static final String REGEX_ID_ROOM = "(SVRO)[-][\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "[1-9][0-9]*";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})$";

    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        List<String[]> list = ReadAndWrite.readFile("src\\data\\villa.csv");
        facilityIntegerMap.clear();
        for (String[] item : list) {
            Villa villa = new Villa(item[0],
                    item[1],
                    Double.parseDouble(item[2]),
                    Double.parseDouble(item[3]),
                    Integer.parseInt(item[4]),
                    item[5],
                    item[6],
                    Double.parseDouble(item[7]),
                    Integer.parseInt(item[8]));
            facilityIntegerMap.put(villa, 0);
        }
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + element.getKey() + "số lần đã thuê " + element.getValue());
        }
        list.clear();
        list = ReadAndWrite.readFile("src\\data\\house.csv");
        facilityIntegerMap.clear();
        for (String[] item : list) {
            House house = new House(item[0],
                    item[1],
                    Double.parseDouble(item[2]),
                    Double.parseDouble(item[3]),
                    Integer.parseInt(item[4]),
                    item[5],
                    item[6],
                    Integer.parseInt(item[7]));
            facilityIntegerMap.put(house, 0);
        }
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + element.getKey() + "số lần đã thuê " + element.getValue());
        }
        list.clear();
        list = ReadAndWrite.readFile("src\\data\\room.csv");
        facilityIntegerMap.clear();
        for (String[] item : list) {
            Room room = new Room(item[0],
                    item[1],
                    Double.parseDouble(item[2]),
                    Double.parseDouble(item[3]),
                    Integer.parseInt(item[4]),
                    item[5],
                    item[6]);
            facilityIntegerMap.put(room, 0);
        }
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + element.getKey() + "số lần đã thuê " + element.getValue());
        }
    }

    @Override
    public void addNewVilla() {
        List<String[]> listStr = ReadAndWrite.readFile("src\\data\\villa.csv");
        facilityIntegerMap.clear();
        for (String[] item : listStr) {
            Villa villa = new Villa(item[0],
                    item[1],
                    Double.parseDouble(item[2]),
                    Double.parseDouble(item[3]),
                    Integer.parseInt(item[4]),
                    item[5],
                    item[6],
                    Double.parseDouble(item[7]),
                    Integer.parseInt(item[8]));
            facilityIntegerMap.put(villa, 0);
        }
        String idFacility = inputIdVilla();

        String nameService = inputNameService();

        double rentalCosts = Double.parseDouble(rentalCosts());

        double usableArea = Double.parseDouble(usableArea());

        int maximumNumberOfPeople = Integer.parseInt(maximumNumberOfPeople());

        String rentalType = rentalType();

        String typeVilla = typeService();

        double areaPool = Double.parseDouble(areaPool());

        int floors = Integer.parseInt(floors());

        Villa villa = new Villa(idFacility, nameService, usableArea, rentalCosts, maximumNumberOfPeople, rentalType, typeVilla, areaPool, floors);
        facilityIntegerMap.put(villa, 0);
        System.out.println("Đã thêm mới thành công!");
        String line = "";
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            line += element.getKey().getInfo();
        }
        ReadAndWrite.writeFile("src\\data\\villa.csv", line);
    }

    @Override
    public void addNewHouse() {
        List<String[]> listStr = ReadAndWrite.readFile("src\\data\\house.csv");
        facilityIntegerMap.clear();
        for (String[] item : listStr) {
            House house = new House(item[0],
                    item[1],
                    Double.parseDouble(item[2]),
                    Double.parseDouble(item[3]),
                    Integer.parseInt(item[4]),
                    item[5],
                    item[6],
                    Integer.parseInt(item[7]));
            facilityIntegerMap.put(house, 0);
        }
        String idFacility = inputIdHouse();

        String nameService = inputNameService();

        double usableArea = Double.parseDouble(usableArea());

        double rentalCosts = Double.parseDouble(rentalCosts());

        int maximumNumberOfPeople = Integer.parseInt(maximumNumberOfPeople());

        String rentalType = rentalType();

        String typeHouse = typeService();

        int floors = Integer.parseInt(floors());

        House house = new House(idFacility, nameService, usableArea, rentalCosts, maximumNumberOfPeople, rentalType, typeHouse, floors);
        facilityIntegerMap.put(house, 0);
        System.out.println("Đã thêm mới thành công!");
        String line = "";
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            line += element.getKey().getInfo();
        }
        ReadAndWrite.writeFile("src\\data\\house.csv", line);
    }

    @Override
    public void addNewRoom() {
        List<String[]> listStr = ReadAndWrite.readFile("src\\data\\room.csv");
        facilityIntegerMap.clear();
        for (String[] item : listStr) {
            Room room = new Room(item[0],
                    item[1],
                    Double.parseDouble(item[2]),
                    Double.parseDouble(item[3]),
                    Integer.parseInt(item[4]),
                    item[5],
                    item[6]);
            facilityIntegerMap.put(room, 0);
        }
        String idFacility = inputIdRoom();

        String nameService = inputNameService();

        double usableArea = Double.parseDouble(usableArea());

        double rentalCosts = Double.parseDouble(rentalCosts());

        int maximumNumberOfPeople = Integer.parseInt(maximumNumberOfPeople());

        String rentalType = rentalType();

        String serviceFree = typeService();

        Room room = new Room(idFacility, nameService, usableArea, rentalCosts, maximumNumberOfPeople, rentalType, serviceFree);
        facilityIntegerMap.put(room, 0);
        System.out.println("Đã thêm mới thành công!");
        String line = "";
        for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) {
            line += element.getKey().getInfo();
        }
        ReadAndWrite.writeFile("src\\data\\room.csv", line);
    }

    private String inputIdVilla() {
        System.out.print("Nhập mã dịch vụ: ");
        return RegexData.regexVilla(scanner.nextLine(), REGEX_ID_VILLA);
    }

    private String inputIdHouse() {
        System.out.print("Nhập mã dịch vụ: ");
        return RegexData.regexHouse(scanner.nextLine(), REGEX_ID_HOUSE);
    }

    private String inputIdRoom() {
        System.out.print("Nhập mã dịch vụ: ");
        return RegexData.regexRoom(scanner.nextLine(), REGEX_ID_ROOM);
    }

    private String inputNameService() {
        System.out.print("Nhập tên dịch vụ: ");
        return RegexData.regexString(REGEX_STR);
    }

    private String rentalCosts() {
        System.out.print("Nhập chi phí thuê: ");
        return RegexData.regexInt(REGEX_INT);
    }

    private String areaPool() {
        System.out.print("Nhập diện tích hồ bơi: ");
        return RegexData.regexArea(REGEX_AREA);
    }

    private String usableArea() {
        System.out.print("Nhập diện tích sử dụng: ");
        return RegexData.regexArea(REGEX_AREA);
    }

    private String maximumNumberOfPeople() {
        System.out.print("Nhập số lượng người tối đa: ");
        return RegexData.regexMount(scanner.nextLine(),REGEX_AMOUNT);
    }

    private String rentalType() {
        System.out.print("Nhập kiểu thuê: ");
        return RegexData.regexString(REGEX_STR);
    }

    private String typeService() {
        System.out.print("Nhập kiểu dịch vụ: ");
        return RegexData.regexString(REGEX_STR);
    }

    private String floors() {
        System.out.print("Nhập số tầng: ");
        return RegexData.regexInt(REGEX_INT);
    }
}
// for (Map.Entry<Facility, Integer> element : facilityIntegerMap.entrySet()) { Lấy giá trị từ Map ép kiểu dữ liệu
//        line += element.getKey().getIdFacility() + ","
//        + element.getKey().getNameService() + ","
//        + element.getKey().getUsableArea() + ","
//        + element.getKey().getRentalCosts() + ","
//        + element.getKey().getMaximumNumberOfPeople() + ","
//        + element.getKey().getRentalType() + ","
//        + ((Villa) element.getKey()).getTypeVilla() + ","
//        + ((Villa) element.getKey()).getAeaPool() + ","
//        + ((Villa) element.getKey()).getFloors() + ","
//        + element.getValue() + "\n";

//