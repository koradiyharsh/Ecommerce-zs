package com.ecom.ecommerce.service;

import com.ecom.ecommerce.dao.CartDao;
import com.ecom.ecommerce.entities.CartItem;
import com.ecom.ecommerce.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartService {

    static private Map<Product, Integer> productList = new HashMap<>();
    @Autowired
    CartDao cartDao;

    @Autowired
    public ProductService productService;

    public ProductService getProductServices() {
        return this.productService;
    }
    public CartService(CartDao cartDao){
        this.cartDao =  cartDao;
    }


    /**
     * @param sid have the session id
     * @return the list of the cartItem which have the session id
     */
    public List<CartItem> getProductsInCart(Integer sid) {
        if (sid.equals(null)) {
            throw new IllegalArgumentException("session id is null");
        }
        return cartDao.findCartItem(sid);
    }

    /**
     * @param sId     have the session id
     * @param product have the product object
     *                method is use for the save the product into the cart .
     * @return the cartItem  after the save into  the database
     */
    public CartItem addProduct(Integer sId, Product product) throws IllegalArgumentException {
        if (sId.equals(null)) {
            throw new IllegalArgumentException("sId is null please enter valid ");
        } else if (product.getId().equals(null)) {
            throw new IllegalArgumentException("product id  is null");

        } else if (product.getCategory().equals(null)) {
            throw new IllegalArgumentException("category is null");
        } else if (product.getPrice().equals(null)) {
            throw new IllegalArgumentException("price value is zero");
        }
        CartItem cartItem = new CartItem();
        CartItem existCartItemQty = cartDao.findIdByProduct(product.getId());
        if (existCartItemQty == null) {
            cartItem.setSessionid(sId);
            cartItem.setProduct(product);
            cartItem.setQty(1);
        } else {
            cartItem.setCartid(existCartItemQty.getCartid());
            cartItem.setSessionid(existCartItemQty.getSessionid());
            cartItem.setProduct(existCartItemQty.getProduct());
            cartItem.setQty(existCartItemQty.getQty() + 1);
        }
        return cartDao.save(cartItem);
    }

    /**
     * @param sId     have the session id
     * @param product have the product object
     *                method is use for the remove the product which present into the sesion id
     * @return the cartAfter after change into the database
     */
    public CartItem removeProduct(Integer sId, Product product) {
        if (sId.equals(null)) {
            throw new IllegalArgumentException("sId is null please enter valid ");
        } else if (product.getId().equals(null)) {
            throw new IllegalArgumentException("product id  is null");
        } else if (product.getCategory().equals(null)) {
            throw new IllegalArgumentException("category is null");
        } else if (product.getPrice().equals(null)) {
            throw new IllegalArgumentException("price value is zero");
        }
        CartItem cartItem = new CartItem();
        CartItem existCartItemQty = cartDao.findIdByProductAndSId(product.getId(), sId);
        if (existCartItemQty.getQty() > 1) {
            cartItem.setSessionid(existCartItemQty.getSessionid());
            cartItem.setProduct(existCartItemQty.getProduct());
            cartItem.setCartid(existCartItemQty.getCartid());
            cartItem.setQty(existCartItemQty.getQty() - 1);
            return cartDao.save(cartItem);
        } else {
            cartDao.delete(existCartItemQty);
            return existCartItemQty;
        }

    }
}
