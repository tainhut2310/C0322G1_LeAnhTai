package com.codegym.service;

import com.codegym.dto.ProductDto;
import com.codegym.model.Cart;

public interface ICartService {
    void addProduct(Cart cart, ProductDto productDto);

    void reduceQuantity(Cart cart,ProductDto productDto);
}
