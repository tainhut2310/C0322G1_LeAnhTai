package com.codegym.controller;

import com.codegym.dto.ProductDto;
import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.ICartService;
import com.codegym.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICartService cartService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/product_list");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart, @RequestParam(name = "action", defaultValue = "") String action) {
        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            if (action.equals("more") || action.equals("")) {
                cartService.addProduct(cart, productDto);
            } else if (action.equals("reduce")) {
                cartService.reduceQuantity(cart, productDto);
            }
        }
        return "cart_list";
    }

    @GetMapping("/pay")
    public String pay(@ModelAttribute("cart") Cart cart) {
        cart.getProducts().clear();
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        model.addAttribute("product", this.productService.findById(id).get());
        return "detail";
    }

}
