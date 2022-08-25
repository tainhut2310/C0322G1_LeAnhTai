package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;

    @Column(name = "product_pescription")
    private String productDescription;

    private String producer;

    public Product() {
    }

    public Product(String name, Double price, String productDescription, String producer) {
        this.name = name;
        this.price = price;
        this.productDescription = productDescription;
        this.producer = producer;
    }

    public Product(Integer id, String name, Double price, String productDescription, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productDescription = productDescription;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public Product clone() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setProducer(producer);
        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productDescription='" + productDescription + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
