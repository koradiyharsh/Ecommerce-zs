package com.ecom.ecommerce.service;

import com.ecom.ecommerce.dao.CategoryDao;
import com.ecom.ecommerce.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    CategoryService(CategoryDao categoryDao){
        this.categoryDao =  categoryDao;
    }
    /**
     * @param category have the category object
     *                 method is use for the save into the database
     * @return the category after the save it
     */
    public Category save(Category category) throws IllegalArgumentException {

        if (category.equals(null)) {
            throw new IllegalArgumentException("Category is null please enter category object");
        } else if (category.getCatId() == 0) {
            throw new IllegalArgumentException("You enter zero as category id");
        } else if (category.getCatId().equals(null)) {
            throw new IllegalArgumentException("please enter category id ");
        } else if (category.getCatName().equals(null)) {
            throw new IllegalArgumentException("category name is null");
        }
        return this.categoryDao.save(category);
    }

    /**
     * @return the list of the category
     */
    public List<Category> getALLCategories() {
        return this.categoryDao.findAll();
    }
}
