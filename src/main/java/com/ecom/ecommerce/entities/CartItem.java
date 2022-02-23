package com.ecom.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ecom_cartitem")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartid")
    private Integer cartid;

    @Column(name = "sessionid")
    private Integer sessionid;

    @ManyToOne(targetEntity = Product.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "prod_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "qty")
    private Integer qty;

    public CartItem(Integer cartid, Integer sessionid, Product product, Integer qty) {
        this.cartid = cartid;
        this.sessionid = sessionid;
        this.product = product;
        this.qty = qty;
    }
    public CartItem(){

    }

}
