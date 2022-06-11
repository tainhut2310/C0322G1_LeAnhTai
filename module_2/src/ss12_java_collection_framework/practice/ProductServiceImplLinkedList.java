package ss12_java_collection_framework.practice;

import ss12_java_collection_framework.exercise.using_arraylist_linkedlist.model.Product;
import ss12_java_collection_framework.exercise.using_arraylist_linkedlist.service.IProductService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImplLinkedList implements IProductService {
    private static List<Product> productList = new LinkedList<>();
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
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
    }

    @Override
    public void displayList() {

    }

    @Override
    public void addNewProduct() {

    }

    @Override
    public void SearchProduct() {

    }

    @Override
    public void DeleteProduct() {

    }

    @Override
    public void UpdateProduct() {

    }

    @Override
    public void SortProduct() {

    }
}
