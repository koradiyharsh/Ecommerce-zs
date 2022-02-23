package com.ecom.ecommerce.controller;

import com.ecom.ecommerce.entities.Product;
import com.ecom.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    ProductController(ProductService productService){
        this.productService =  productService;
    }

    @GetMapping("/hello")
    public String getHelloworld(){
        return "Hello Angad";
    }
    /**
     * @param categoryId  have  the product id
     * method is use for the return the list of the product after the given valid category id
     * @return the list of product
     */
    @GetMapping("/ecommerce/products/{categoryId}")
    ResponseEntity<?> findProductByCategory(@PathVariable Integer categoryId) {

        try{
            return ResponseEntity.ok().body(  productService.findProductByCategory(categoryId));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentException.getMessage());
        }

    }

    /**
     * @param id  have the product id
     * @return the product if its id present into the database
     */
    @GetMapping("/ecommerce/product/{id}")
    public ResponseEntity<?> findByProductId(@PathVariable Integer id) {

        try{
          return ResponseEntity.ok().body( productService.findProductById(id));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentException.getMessage());
        }
    }

    /**
     * @param product  have the poduct object
     * method is use for the save into the database
     * @return  the product after save it
     */
    @PostMapping("/ecommerce/product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        try {
           return ResponseEntity.ok().body(productService.saveProduct(product));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentException.getMessage());
        }
    }

    /**
     * @return  the list of the products which present into the database
     */
    @GetMapping("/ecommerce/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
