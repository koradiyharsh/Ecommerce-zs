package com.ecom.ecommerce.service;

import com.ecom.ecommerce.dao.ProductDao;
import com.ecom.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    ProductService(ProductDao productDao){
        this.productDao = productDao;
    }

    /**
     * @param catId have the product id
     * @return the list of product base on  the category id
     */
    public List<Product> findProductByCategory(Integer catId) throws IllegalArgumentException {
        if (catId == null) {
            throw new IllegalArgumentException("category is null");
        } else if (catId == 0) {
            throw new IllegalArgumentException("category value is zero");
        }
        return productDao.findProduct(catId);
    }

    /**
     * @param product have the product object
     * @return the product after save into the database
     */
    public Product saveProduct(Product product) throws IllegalArgumentException {
        if (product == null) {
            throw new IllegalArgumentException("Product is not found!!");
        } else if ((product.getId() == 0)) {
            throw new IllegalArgumentException("Product ID is zero");
        } else if (product.getStock() == 0) {
            throw new IllegalArgumentException("Product stock is zero");
        }else if(product.getStock() == null){
            throw new IllegalArgumentException("Product stock is null");
        }
        else if (product.getPrice().equals(null)) {
            throw new IllegalArgumentException("Product price  is Empty.");
        } else if (product.getName().isEmpty() || product.getCategory().equals(null)) {
            throw new IllegalArgumentException("Incomplete information");
        }
        return productDao.save(product);
    }

    /**
     * @return the list of the product which have present into the database
     */
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    /**
     * @param id have the product id
     * @return the product if the present into the database.
     */
    public Optional<Product> findProductById(Integer id) throws IllegalArgumentException {

        if (id.equals(null)) {
            throw new IllegalArgumentException("Product Id is not null");
        } else if (id == 0) {
            throw new IllegalArgumentException("product Id is zero");
        }
        return productDao.findById(id);
    }

}
