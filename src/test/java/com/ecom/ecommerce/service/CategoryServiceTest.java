package com.ecom.ecommerce.service;

import com.ecom.ecommerce.dao.CategoryDao;
import com.ecom.ecommerce.entities.Category;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryServiceTest {

    @Mock
    CategoryDao categoryDao = Mockito.mock(CategoryDao.class);
    private static final Logger logger  = Logger.getLogger(CategoryServiceTest.class.getName());

    @Test
    public void TestOfCategory(){
        Category expectedCategory = new Category(1 , "electronic");
        Mockito.when(categoryDao.save(Mockito.any(Category.class))).thenReturn(expectedCategory);
        CategoryService categoryService = new CategoryService(categoryDao);
        Category resultCategory =  categoryService.save(new Category(101 , "electro"));
        assertEquals(expectedCategory , resultCategory);
    }

    @Test
    public void TestOfCategoryList(){
        List<Category> expectedCategoryList = new ArrayList<>();
        expectedCategoryList.add(new Category(101 ,"electronics"));
        expectedCategoryList.add(new Category(102 , "beauty"));
        Mockito.when(categoryDao.findAll()).thenReturn(expectedCategoryList);
        CategoryService categoryService = new CategoryService(categoryDao);
        List<Category> resultCategoryList =  categoryService.getALLCategories();
        assertEquals(resultCategoryList , expectedCategoryList);
    }
}