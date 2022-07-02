package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iPhone 12Pro", 1500, "Hàng chính hãng 100%", "Apple"));
        productList.add(new Product(2, "A15", 500, "Hàng chính hãng 100%", "Samsung"));
        productList.add(new Product(3, "iPhone 12", 1000, "Hàng chính hãng 100%", "Apple"));
        productList.add(new Product(4, "Astra", 1000, "Hàng chính hãng 100%", "Samsung"));
        productList.add(new Product(5, "iPhone 12Pro", 1500, "Hàng chính hãng 100%", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void create(Product student) {
        productList.add(student);
    }

    @Override
    public void update(int id, Product product) {
        productList.set(id - 1, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id - 1);
    }

    @Override
    public Product seeProductDetails() {
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product item : productList) {
            if (item.getName().contains(name)) {
                searchList.add(item);
            }
        }
        return searchList;
    }

    @Override
    public Product findById(int id) {
        return productList.get(id - 1);
    }
}
