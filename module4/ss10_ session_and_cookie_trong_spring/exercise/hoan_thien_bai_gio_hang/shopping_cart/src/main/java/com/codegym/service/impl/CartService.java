package com.codegym.service.impl;

import com.codegym.dto.ProductDto;
import com.codegym.model.Cart;
import com.codegym.service.ICartService;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {

    @Override
    public void addProduct(Cart cart, ProductDto productDto) {
        if (cart.getProducts().containsKey(productDto)) {
            Integer currentValue = cart.getProducts().get(productDto);
            cart.getProducts().replace(productDto, currentValue + 1);
        } else {
            cart.getProducts().put(productDto, 1);
        }
    }

    @Override
    public void reduceQuantity(Cart cart, ProductDto productDto) {
        if (cart.getProducts().containsKey(productDto)) {
            Integer currentValue = cart.getProducts().get(productDto);
            cart.getProducts().replace(productDto, currentValue - 1);
            if (currentValue == 0) {
                cart.getProducts().replace(productDto, 0);

            }
        }
    }
}
