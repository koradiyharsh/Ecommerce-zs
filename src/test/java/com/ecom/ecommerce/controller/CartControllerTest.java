package com.ecom.ecommerce.controller;

import com.ecom.ecommerce.entities.CartItem;
import com.ecom.ecommerce.entities.Category;
import com.ecom.ecommerce.entities.Product;
import com.ecom.ecommerce.service.CartService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CartControllerTest {

    CartService cartService = Mockito.mock(CartService.class);
    private static Logger logger  = Logger.getLogger(CartControllerTest.class);

    @Test
    public void TestOfSessionIdIsNull()
    {
        CartController cartController = new CartController(cartService);
        CartItem cartItem = new CartItem(1 , null, new Product(1 , "watch" , BigDecimal.valueOf(2000) ,2 , new Category(101 , "fashion")),200);
        Mockito.when(cartController.shoppingCart(cartItem.getSessionid())).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = cartController.shoppingCart(cartItem.getSessionid());
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());
    }

    @Test
    public void TestOfSessionIdIsZero()
    {
        CartController cartController = new CartController(cartService);
        CartItem cartItem = new CartItem(1 , 0, new Product(1 , "watch" , BigDecimal.valueOf(2000) ,2 , new Category(101 , "fashion")),200);
        Mockito.when(cartController.shoppingCart(cartItem.getSessionid())).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = cartController.shoppingCart(cartItem.getSessionid());
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());
    }



}