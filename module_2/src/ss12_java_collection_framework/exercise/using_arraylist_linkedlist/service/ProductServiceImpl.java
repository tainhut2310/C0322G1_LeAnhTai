package ss12_java_collection_framework.excrecise.using_arraylist_linkedlist.service;

import javafx.print.Collation;
import ss12_java_collection_framework.excrecise.using_arraylist_linkedlist.model.Product;
import ss12_java_collection_framework.excrecise.using_arraylist_linkedlist.util.ProductPriceComparator;
import ss12_java_collection_framework.excrecise.using_arraylist_linkedlist.util.ProductPriceComparatorMin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements IProductService {
    public static List<Product> productsList = new ArrayList<>();
    public static int count;
    public static Scanner input = new Scanner(System.in);

    static {
        Product product1 = new Product(1, "iPhone 13", 100, 10, "Apple");
        Product product2 = new Product(2, "Ultra 22", 600, 14, "Samsung");
        Product product3 = new Product(3, "iPhone 12", 200, 10, "Apple");
        Product product4 = new Product(4, "N 85", 700, 10, "Nokia");
        Product product5 = new Product(5, "iPhone 13", 300, 10, "Apple");
        Product product6 = new Product(6, "iPhone 13", 400, 10, "Apple");
        Product product7 = new Product(7, "iPhone 13", 500, 10, "Apple");
        count = 7;
        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);
        productsList.add(product4);
        productsList.add(product5);
        productsList.add(product6);
        productsList.add(product7);
    }

    @Override
    public void displayList() {
        for (Product item : productsList) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void addNewProduct() {
        System.out.println("Nhập tên:");
        String name = input.nextLine();
        System.out.println("Nhập giá:");
        double price = Double.parseDouble(input.nextLine());
        System.out.println("Nhập số lượng:");
        int amount = Integer.parseInt(input.nextLine());
        System.out.println("Nhập nhà sản xuất:");
        String production = input.nextLine();

        Product product = new Product(count + 1, name, price, amount, production);
        productsList.add(product);
        count++;
    }

    @Override
    public void SearchProduct() {
        System.out.print("Nhập tên sản phẩm muốn tìm:");
        String find = input.nextLine();
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i) != null && (productsList.get(i).getName().contains(find))) {
                System.out.println(productsList.get(i));
            }
        }
    }

    @Override
    public void DeleteProduct() {
        System.out.print("Nhập id muốn xóa: ");
        int placeId = Integer.parseInt(input.nextLine());
        for (int i = 0; i < productsList.size(); i++) {
            if (placeId == productsList.get(i).getId()) {
                productsList.remove(placeId);
                break;
            }
        }
        displayList();
    }

    @Override
    public void UpdateProduct() {
        System.out.print("Nhập id muốn update: ");
        int placeId = Integer.parseInt(input.nextLine());
        System.out.print("Nhập tên: ");
        String name = input.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(input.nextLine());
        System.out.print("Nhập số lượng: ");
        int amount = Integer.parseInt(input.nextLine());
        System.out.print("Nhập nhà sản xuất: ");
        String production = input.nextLine();
        for (int i = 0; i < productsList.size(); i++) {
            if (placeId == productsList.get(i).getId()) {
                productsList.set(i, new Product(i + 1, name, price, amount, production));
                break;
            }
        }
        displayList();
    }

    @Override
    public void SortProduct() {
        System.out.println("1. Sort products in ascending order by price");
        System.out.println("2. Sort products in descending order by price");
        int choose = Integer.parseInt(input.nextLine());
        ProductPriceComparator comparator = new ProductPriceComparator();
        ProductPriceComparatorMin productPriceComparatorMin = new ProductPriceComparatorMin();
        switch (choose) {
            case 1:
                productsList.sort(comparator);
                break;
            case 2:
                productsList.sort(productPriceComparatorMin);
        }

    }
}
