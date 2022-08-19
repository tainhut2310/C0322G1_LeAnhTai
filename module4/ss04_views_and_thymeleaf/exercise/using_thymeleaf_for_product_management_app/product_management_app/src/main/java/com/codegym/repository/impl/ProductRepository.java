package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iPhone 12Pro", 1500, "Hàng chính hãng 100%", "Apple"));
        productList.add(new Product(2, "A15", 500, "Hàng xách tay", "Samsung"));
        productList.add(new Product(3, "iPhone 12", 1000, "Hàng 99%", "Apple"));
        productList.add(new Product(4, "Ultra", 1000, "Hàng chính hãng 100%", "Samsung"));
        productList.add(new Product(5, "iPhone 12Pro", 1500, "Hàng chính hãng 100%", "Apple"));
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product item : productList) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAllSearch(String name) {
        List<Product> list = new ArrayList<>();
        for (Product item : productList) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(item);
            }
        }
        return list;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, product);
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(productList.get(i));
            }
        }
    }
}
