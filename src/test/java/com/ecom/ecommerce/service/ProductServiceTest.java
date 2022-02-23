package com.ecom.ecommerce.service;

import com.ecom.ecommerce.dao.ProductDao;
import com.ecom.ecommerce.entities.Category;
import com.ecom.ecommerce.entities.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductServiceTest {

    @Mock
    ProductDao productDao = Mockito.mock(ProductDao.class);
    private static final Logger logger  = Logger.getLogger(ProductServiceTest.class.getName());

    @Test
    public void TestOfSaveProduct(){

        Category category = new Category(1 , "electronic");
        Product expectedProduct = new Product(101 , "Iphone" , BigDecimal.valueOf(2000) , 2 , category);
        Mockito.when(productDao.save(Mockito.any(Product.class))).thenReturn(expectedProduct);
        ProductService productService = new ProductService(productDao);
        Product resultProduct = productService.saveProduct(new Product(2 , "phone" , BigDecimal.valueOf(1000) , 3 , new Category(2 , "electro")));
        assertEquals(resultProduct , expectedProduct);

    }

    @Test
    public void TestOfFindByProductId(){
        Optional<Product> expectedProduct  = Optional.of(new Product(101, "Iphone", BigDecimal.valueOf(2000), 2, new Category(101, "Electronic")));
        Mockito.when(productDao.findById(Mockito.any(Integer.class))).thenReturn(expectedProduct);
        ProductService productService = new ProductService(productDao);
        Optional<Product> resultProduct = productService.findProductById(3);
        assertEquals(expectedProduct, resultProduct);

    }

    @Test
    public void TestOfProductsByCategoryId(){
        List<Product> expectedProductList  = new ArrayList<>();
        expectedProductList.add(new Product(101, "Iphone", BigDecimal.valueOf(20000), 2, new Category(101, "Electronic")));
        expectedProductList.add(new Product(102, "lenovo", BigDecimal.valueOf(2000), 2, new Category(101, "Electronic")));
        Mockito.when(productDao.findProduct(Mockito.any(Integer.class))).thenReturn(expectedProductList);
        ProductService productService = new ProductService(productDao);
        List<Product> resultProduct = productService.findProductByCategory(2);
        assertEquals(expectedProductList, resultProduct);
    }
    @Test
    public void TestListOfProduct(){
        List<Product> expectedProductList  = new ArrayList<>();
        expectedProductList.add(new Product(101, "Iphone", BigDecimal.valueOf(20000), 2, new Category(101, "Electronic")));
        expectedProductList.add(new Product(102, "lenovo", BigDecimal.valueOf(2000), 2, new Category(101, "Electronic")));
        Mockito.when(productDao.findAll()).thenReturn(expectedProductList);
        ProductService productService = new ProductService(productDao);
        List<Product> resultProduct =  productService.getAllProducts();
        assertEquals(expectedProductList , resultProduct);

    }


}