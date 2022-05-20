package ss12_java_collection_framework.excrecise.using_arraylist_linkedlist.controller;

import ss12_java_collection_framework.excrecise.using_arraylist_linkedlist.service.ProductServiceImpl;
import ss12_java_collection_framework.excrecise.using_arraylist_linkedlist.util.ProductPriceComparator;

import java.util.Scanner;

public class ProductController {
    public static Scanner input = new Scanner(System.in);

    public static void menu() {
        ProductServiceImpl productService = new ProductServiceImpl();
        do {
            System.out.println("-------------Product Management-----------");
            System.out.println("1. Display list Product");
            System.out.println("2. Add new Product");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Update Product");
            System.out.println("6. Sort Product");
            System.out.println("7. Exit");
            System.out.print("Choose options: ");
            int choose = Integer.parseInt(input.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("Display list");
                    productService.displayList();
                    break;
                case 2:
                    System.out.println("Add new");
                    productService.addNewProduct();
                    break;
                case 3:
                    System.out.println("Search Product");
                    productService.SearchProduct();
                    break;
                case 4:
                    System.out.println("Delete Product");
                    productService.DeleteProduct();
                    break;
                case 5:
                    System.out.println("Update Product");
                    productService.UpdateProduct();
                    break;
                case 6:
                    System.out.println("Sort Product");
                    productService.SortProduct();
                    productService.displayList();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }
}
