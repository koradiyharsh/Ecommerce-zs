package com.ecom.ecommerce.controller;

import com.ecom.ecommerce.entities.Category;
import com.ecom.ecommerce.entities.Product;
import com.ecom.ecommerce.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductControllerTest {

    ProductService productService = Mockito.mock(ProductService.class);

    @Test
    public void TestOfProductIsNull(){

        ProductController categoryController = new ProductController(productService);
        Product product = new Product();
        Mockito.when(categoryController.saveProduct(product)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveProduct(product);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());

    }
    @Test
    public void TestOfProductIdIsZero(){

        ProductController categoryController = new ProductController(productService);
        Product product = new Product(0 , "watch" , BigDecimal.valueOf(2000) , 2 , new Category(1 , "fashion"));
        Mockito.when(categoryController.saveProduct(product)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveProduct(product);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());

    }
    @Test
    public void TestOfProductIdIsNull(){

        ProductController categoryController = new ProductController(productService);
        Product product = new Product(null, "watch" , BigDecimal.valueOf(2000) , 2 , new Category(1 , "fashion"));
        Mockito.when(categoryController.saveProduct(product)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveProduct(product);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());

    }
    @Test
    public void TestOfProductNameIsNull(){

        ProductController categoryController = new ProductController(productService);
        Product product = new Product(10 , null , BigDecimal.valueOf(2000) , 2 , new Category(1 , "fashion"));
        Mockito.when(categoryController.saveProduct(product)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveProduct(product);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());

    }
    @Test
    public void TestOfProductStockIsZero(){

        ProductController categoryController = new ProductController(productService);
        Product product = new Product(10 , "watch" , BigDecimal.valueOf(2000) , 0 , new Category(1 , "fashion"));
        Mockito.when(categoryController.saveProduct(product)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveProduct(product);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());

    }
    @Test
    public void TestOfProductStockIsNull(){

        ProductController categoryController = new ProductController(productService);
        Product product = new Product(10 , "watch" , BigDecimal.valueOf(2000) , null , new Category(1 , "fashion"));
        Mockito.when(categoryController.saveProduct(product)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveProduct(product);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());

    }
    @Test
    public void TestOfProductPriceIsZero(){

        ProductController categoryController = new ProductController(productService);
        Product product = new Product(0 , "watch" , BigDecimal.valueOf(0) , 2 , new Category(1 , "fashion"));
        Mockito.when(categoryController.saveProduct(product)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveProduct(product);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());

    }
    @Test
    public void TestOfCategoryIdIsZero(){

        ProductController categoryController = new ProductController(productService);
        Product product = new Product(10 , "watch" , BigDecimal.valueOf(2000) , 2 , new Category(0 , "fashion"));
        Mockito.when(categoryController.saveProduct(product)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveProduct(product);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());

    }
    @Test
    public void TestOfCategoryIdIsNull(){

        ProductController categoryController = new ProductController(productService);
        Product product = new Product(10 , "watch" , BigDecimal.valueOf(2000) , 2 , new Category(null , "fashion"));
        Mockito.when(categoryController.saveProduct(product)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveProduct(product);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());

    }

}