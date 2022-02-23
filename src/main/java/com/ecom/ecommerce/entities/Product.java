package com.ecom.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ecom_product")
@Data
public class Product {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    public Product() {
    }

    @ManyToOne(targetEntity = Category.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "catid", referencedColumnName = "catId")
    private Category category;

    public Product(Integer id, String name, BigDecimal price, Integer stock, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
}