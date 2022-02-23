package com.ecom.ecommerce.controller;

import com.ecom.ecommerce.entities.Product;
import com.ecom.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    CartService cartService;
    CartController(CartService cartService){
        this.cartService =  cartService;
    }

    /**
     *
     * @param sid have the user session id
     * method is use for the return the list of the cartItem based on the sesion id
     * @return the list of the cart based on the input the session id
     */
    @GetMapping("/shoppingCart/{sid}")
    public ResponseEntity<?> shoppingCart(@PathVariable Integer sid) {
        try
        {

            return ResponseEntity.ok().body( cartService.getProductsInCart(sid));
        }
        catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentException.getMessage());
        }

    }

    /**
     *
     * @param sId have the session id
     * @param productId have the product id
     * method is use for the add the product into the database
     * @return   the product object
     */
    @PostMapping("/shoppingCart/product/{sid}/{productId}")
    public ResponseEntity<?> addProductToCart(@PathVariable("sid") int sId, @PathVariable("productId") Integer productId) {

        try{

            Optional<Product> product =  this.cartService.getProductServices().findProductById(productId);
            return ResponseEntity.ok().body(cartService.addProduct(sId, product.get()));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentException.getMessage());
        }


    }

    /**
     * @param sId  have the session id
     * @param productId have the product id
     * @return the result which one the product deleted after the give the id
     */
    @DeleteMapping("/shoppingCart/product/{sid}/{productId}")
    public ResponseEntity<?> removeProductFromCart(@PathVariable("sid") int sId, @PathVariable("productId") Integer productId) {


        try{
            Optional<Product> product = this.cartService.getProductServices().findProductById(productId);
            return ResponseEntity.ok().body(String.valueOf(cartService.removeProduct(sId, product.get())));
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(400).body(illegalArgumentException.getMessage());
        }

    }

}
