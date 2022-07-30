package repository;

import model.Product;

import java.util.List;

public interface IRepositoryProduct {
    List<Product> fillAll();

    void save(Product product);

    Product findById(int id);

    List<Product> findByName(String name);

    void update(Product product);

    void remove(int id);
}
