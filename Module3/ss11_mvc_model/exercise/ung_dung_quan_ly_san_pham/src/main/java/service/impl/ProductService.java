package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository repositoryProduct = new ProductRepository();
    @Override
    public List<Product> fillAll() {
        return repositoryProduct.fillAll();
    }

    @Override
    public void save(Product product) {
        repositoryProduct.save(product);
    }

    @Override
    public Product findById(int id) {
        return repositoryProduct.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return repositoryProduct.findByName(name);
    }

    @Override
    public void update(Product product) {
        repositoryProduct.update(product);
    }

    @Override
    public void remove(int id) {
        repositoryProduct.remove(id);
    }
}
