package com.ecom.ecommerce.controller;

import com.ecom.ecommerce.entities.Category;
import com.ecom.ecommerce.service.CategoryService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryControllerTest {

    CategoryService categoryService = Mockito.mock(CategoryService.class);
    private static final Logger logger = Logger.getLogger(CategoryControllerTest.class);

    @Test
    public void TestOfCategoryNull(){
        CategoryController categoryController = new CategoryController(categoryService);
        Category category = new Category();
        Mockito.when(categoryController.saveCategory(category)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveCategory(category);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());
    }
    @Test
    public void TestOfCategoryIdZero(){
        CategoryController categoryController = new CategoryController(categoryService);
        Category category = new Category(0 , "electronics");
        Mockito.when(categoryController.saveCategory(category)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveCategory(category);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());
    }
    @Test
    public void TestOfCategoryIdIsNull(){
        CategoryController categoryController = new CategoryController(categoryService);
        Category category = new Category(null , "electronics");
        Mockito.when(categoryController.saveCategory(category)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveCategory(category);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());
    }
    @Test
    public void TestOfCategoryNameIsNull(){
        CategoryController categoryController = new CategoryController(categoryService);
        Category category = new Category(1 , null);
        Mockito.when(categoryController.saveCategory(category)).thenThrow(IllegalArgumentException.class);
        ResponseEntity<?> expectedEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ResponseEntity<?> resultEntity = categoryController.saveCategory(category);
        assertEquals(expectedEntity.getStatusCode(), resultEntity.getStatusCode());
    }

}