package excercise_module2.product_management;

import java.util.Scanner;

public class Main {
    public static Product[] productsList = new Product[100];
    public static int count;
    static Scanner input = new Scanner(System.in);
    static {
        productsList[0]= new Product(1, "iPhone 13",500, 10,"Apple");
        productsList[1]= new Product(2, "Ultra 22",500, 14,"Samsung");
        productsList[2]= new Product(3, "iPhone 12",500, 10,"Apple");
        productsList[3]= new Product(4, "N 85",500, 10,"Nokia");
        productsList[4]= new Product(5, "iPhone 13",500, 10,"Apple");
        productsList[5]= new Product(6, "iPhone 13",500, 10,"Apple");
        productsList[6]= new Product(7, "iPhone 13",500, 10,"Apple");
        count = 7;
    }

    public static void displayList() {
        for (Product item : productsList) {
            if(item != null ) {
                System.out.println(item);
            }
        }
    }

    public static void addNewProduct() {
        System.out.println("Nhập tên:");
        String name = input.nextLine();
        System.out.println("Nhập giá:");
        double price = Double.parseDouble(input.nextLine());
        System.out.println("Nhập số lượng:");
        int amount = Integer.parseInt(input.nextLine());
        System.out.println("Nhập nhà sản xuất:");
        String production = input.nextLine();

        Product product = new Product(count +1, name, price, amount, production);
        productsList[count] = product;
        count++;
    }

    public static void searchProduct() {
        System.out.print("Nhập tên sản phẩm hoặc hãng sản xuất muốn tìm:");
        String find = input.nextLine();
        for (int i = 0; i < productsList.length ; i++) {
            if(productsList[i] != null && (productsList[i].getName().contains(find) || productsList[i].getProduction().contains(find))) {
                System.out.println(productsList[i]);
            }
        }
    }

    public static void deleteProduct() {
        System.out.print("Nhập id muốn xóa: ");
        int placeId = Integer.parseInt(input.nextLine());
        for (int i = 0; i < productsList.length ; i++) {
            if(placeId == productsList[i].getId()){
                productsList[i] = null;
                break;
            }
        }
        displayList();
    }

    public static void updateProduct() {
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
        for (int i = 0; i < productsList.length; i++) {
            if (placeId == productsList[i].getId()) {
                productsList[i] = new Product(i+1, name, price, amount, production);
                break;
            }
        }
        displayList();
    }
    public static void main(String[] args) {
        do {
            System.out.println("-------------Product Management-----------");
            System.out.println("1. Display list Product");
            System.out.println("2. Add new Product");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Update Product");
            System.out.println("6. Exit");
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
                    System.out.println("Delete Product");
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Update Product");
                    updateProduct();
                    break;
                case 6:
                    System.exit(0);
            }
        } while(true);
    }
}
