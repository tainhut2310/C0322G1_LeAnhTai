package service.impl;

import model.Product;
import repository.IRepositoryProduct;
import repository.impl.RepositoryProduct;
import service.IServiceProduct;

import java.util.List;

public class ServiceProduct implements IServiceProduct {
    private IRepositoryProduct repositoryProduct = new RepositoryProduct();
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
