package com.ecom.ecommerce.service;

import com.ecom.ecommerce.dao.CartDao;
import com.ecom.ecommerce.entities.CartItem;
import com.ecom.ecommerce.entities.Category;
import com.ecom.ecommerce.entities.Product;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartServiceTest {

    @Mock
    CartDao cartDao = Mockito.mock(CartDao.class);
    private static final Logger logger  = Logger.getLogger(CategoryServiceTest.class.getName());

    @Test
    public void TestOfGetProductsInCart(){

        List<CartItem> expectedCartList =  new ArrayList<>();
        expectedCartList.add(new CartItem(1 , 1 , new Product(1 , "lenovo" , BigDecimal.valueOf(100) , 100 , new Category(1 , "electronics")), 10));
        expectedCartList.add(new CartItem(2 , 1 , new Product(2 , "Iphone" , BigDecimal.valueOf(23) , 50 , new Category(1 , "electronics")), 10));
        Mockito.when(cartDao.findCartItem(Mockito.any(Integer.class))).thenReturn(expectedCartList);
        CartService cartService = new CartService(cartDao);
        List<CartItem> resultCartList =   cartService.getProductsInCart(2);
        assertEquals(expectedCartList , resultCartList);

    }

    @Test
    public void TestOfAddProductInCart(){

        CartItem expectedCartItem = new CartItem(1 , 1 , new Product(1 , "lenovo" , BigDecimal.valueOf(100) , 100 , new Category(1 , "electronics")), 10);
        Mockito.when(cartDao.save(Mockito.any(CartItem.class))).thenReturn(expectedCartItem);
        CartService cartService = new CartService(cartDao);
        CartItem resultCartItem = cartService.addProduct(1 , new Product(1 , "iphone" , BigDecimal.valueOf(2000) , 2 , new Category(1 , "electro")));
        assertEquals(expectedCartItem , resultCartItem);
    }


}