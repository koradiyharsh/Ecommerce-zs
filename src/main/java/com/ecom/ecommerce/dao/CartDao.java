package com.ecom.ecommerce.dao;

import com.ecom.ecommerce.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartDao extends JpaRepository<CartItem, Integer> {

    @Query("select c from CartItem c where c.sessionid = (:sid)")
    List<CartItem> findCartItem(@Param("sid") Integer sid);

    @Query("select c from CartItem c where c.product.id = (:pid)")
    CartItem findIdByProduct(@Param("pid") Integer pid);

    @Query("select c from CartItem c where c.product.id = (:pid) and c.sessionid = (:sid)")
    CartItem findIdByProductAndSId(@Param("pid") Integer pid, @Param("sid") Integer sid);
}
