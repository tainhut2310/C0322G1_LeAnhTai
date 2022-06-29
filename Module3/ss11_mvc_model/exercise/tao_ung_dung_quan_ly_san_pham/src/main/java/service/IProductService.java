package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void create(Product student);

    void update(int id, Product product);

    void delete(int id);

    Product seeProductDetails();

    List<Product> findByName(String name);

    Product findById(int id);

}
