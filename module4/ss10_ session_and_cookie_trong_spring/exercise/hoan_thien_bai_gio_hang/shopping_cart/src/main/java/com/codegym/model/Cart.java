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

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

}
