package com.codegym.model;

import com.codegym.dto.ProductDto;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<ProductDto, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public void addProduct(ProductDto productDto) {
        if (products.containsKey(productDto)) {
            Integer currentValue = products.get(productDto);
            products.replace(productDto, currentValue + 1);
        } else {
            products.put(productDto, 1);
        }
    }
}
