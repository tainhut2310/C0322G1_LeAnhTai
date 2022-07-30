package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.*;

public class ProductRepositoryImpl implements IProductRepository {
    static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "iPhone 12Pro", 1500, "Hàng chính hãng 100%", "Apple"));
        productMap.put(2, new Product(2, "A15", 500, "Hàng chính hãng 100%", "Samsung"));
        productMap.put(3, new Product(3, "iPhone 12", 1000, "Hàng chính hãng 100%", "Apple"));
        productMap.put(4, new Product(4, "Astra", 1000, "Hàng chính hãng 100%", "Samsung"));
        productMap.put(5, new Product(5, "iPhone 12Pro", 1500, "Hàng chính hãng 100%", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product student) {
        productMap.put(student.getId(), student);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            if (entry.getValue().getName().contains(name)) {
                searchList.add(entry.getValue());
            }
        }
        return searchList;
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }
}
