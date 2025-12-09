package com.pluralsight.NorthwindTradersAPI2.controllers;

import com.pluralsight.NorthwindTradersAPI2.models.Category;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/categories/filter", method = RequestMethod.GET)
    public List<Category> filterCategoriesByName(@RequestParam String categoryName) {
        List<Category> matchingCategory = new ArrayList<>();

        for (Category category : categories) {
            if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                matchingCategory.add(category);
            }
        }
        return matchingCategory;
    }
}
