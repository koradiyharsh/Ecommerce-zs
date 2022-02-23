package com.ecom.ecommerce.controller;

import com.ecom.ecommerce.entities.Category;
import com.ecom.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    /**
     *
     * @param category have the category object
     * method is use for the save the category
     * @return the the category after the save into the database
     */
    @PostMapping("/ecommerce/category")
    public ResponseEntity<?> saveCategory(@RequestBody Category category){

        try{
            return ResponseEntity.ok().body(categoryService.save(category));
        }
        catch (IllegalArgumentException illegalArgumentException){
           return ResponseEntity.status(400).body(illegalArgumentException.getMessage());
        }


    }

    /**
     * @return  the list of all the categories
     */
    @GetMapping("/ecommerce/category")
    public List<Category> getAllCategories() {
        return categoryService.getALLCategories();

    }

}

