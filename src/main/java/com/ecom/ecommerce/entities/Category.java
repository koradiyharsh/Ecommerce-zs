package com.ecom.ecommerce.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ecom_category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catId")
    private Integer catId;

    @Column(name = "cat_name")
    private String catName;

    public Category(Integer catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }
    public Category(){}
}