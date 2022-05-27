package ss17_io_binary_file_serialization.exercise.product_management_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        do {
            System.out.println("-------------Product Management-----------");
            System.out.println("1. Display list Product");
            System.out.println("2. Add new Product");
            System.out.println("3. Search Product");
            System.out.println("4. Exit");
            System.out.print("Choose options: ");
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Display list");
                    displayList();
                    break;
                case 2:
                    System.out.println("Add new");
                    addNewProduct();
                    break;
                case 3:
                    System.out.println("Search Product");
                    searchProduct();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }

    public static Scanner input = new Scanner(System.in);
    public static List<Product> productsList = new ArrayList<>();
    public static int count;

    static {
        productsList.add(new Product(1, "iPhone 13", "Apple", 100, "Other"));
        productsList.add(new Product(2, "Ultra 22", "Samsung", 200, "Other"));
        productsList.add(new Product(3, "iPhone 12", "Apple", 300, "Other"));
        productsList.add(new Product(4, "N 85", "Nokia", 400, "Other"));
        productsList.add(new Product(5, "iPhone 13", "Apple", 500, "Other"));
        productsList.add(new Product(6, "iPhone 13", "Apple", 600, "Other"));
        productsList.add(new Product(7, "iPhone 13", "Apple", 700, "Other"));
        count = 7;
    }

    public static void displayList() {
        writeProduct("src\\ss17_io_binary_file_serialization\\exercise\\product_management_binary_file\\file_product.txt", productsList);
        List<Product> productList = readProduct("src\\ss17_io_binary_file_serialization\\exercise\\product_management_binary_file\\file_product.txt");
        for (Product item : productList) {
            System.out.println(item);
        }
    }

    public static void addNewProduct() {
        System.out.println("Nhập tên:");
        String nameProduct = input.nextLine();
        System.out.println("Nhập nhà sản xuất:");
        String production = input.nextLine();
        System.out.println("Nhập giá:");
        double price = Double.parseDouble(input.nextLine());
        System.out.println("Nhập mô tả khác:");
        String otherProduct = input.nextLine();
        productsList.add(new Product(count + 1, nameProduct, production, price, otherProduct));
        count++;
        writeProduct("src\\ss17_io_binary_file_serialization\\exercise\\product_management_binary_file\\file_product.txt", productsList);
    }

    public static void searchProduct() {
        System.out.print("Nhập tên sản phẩm hoặc hãng sản xuất muốn tìm:");
        String find = input.nextLine();
        List<Product> productList = readProduct("src\\ss17_io_binary_file_serialization\\exercise\\product_management_binary_file\\file_product.txt");
        boolean check = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) != null && (productList.get(i).getName().contains(find) || productList.get(i).getProduction().contains(find))) {
                check = true;
                System.out.println(productList.get(i));
            }
        }
        if (!check) {
            System.out.println("Không tìm thấy sản phẩm bạn muốn tìm!");
        }
    }

    public static void writeProduct(String path, List<Product> list) {
        File file = new File(path);
        FileOutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            os = new FileOutputStream(file);
            oos = new ObjectOutputStream(os);
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Product> readProduct(String path) {
        File file = new File(path);
        FileInputStream is = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(file);
            ois = new ObjectInputStream(is);
            List<Product> list;
            list = (List<Product>) ois.readObject();
            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
