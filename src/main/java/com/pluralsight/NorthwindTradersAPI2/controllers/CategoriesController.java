package com.pluralsight.NorthwindTradersAPI2.controllers;

import com.pluralsight.NorthwindTradersAPI2.models.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    private List<Category> categories;

    public CategoriesController() {
        categories = new ArrayList<>();

        categories.add(new Category(1, "Seafood"));
        categories.add(new Category(2, "Dairy"));
        categories.add(new Category(3, "Poultry"));
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categories;
    }

    @RequestMapping(path = "/categories/{categoryID}", method = RequestMethod.GET)
    public Category getCategoryByID (@PathVariable int categoryID) {
        for (Category category : categories) {
            if (category.getCategoryID() == categoryID){
                return category;
            }
        }
        return null;
    }
}
