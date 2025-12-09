package com.pluralsight.NorthwindTradersAPI2.controllers;

import com.pluralsight.NorthwindTradersAPI2.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private List<Product> products;

    public ProductsController() {
        products = new ArrayList<>();

        products.add(new Product(1, "Crab", 1, 34.99));
        products.add(new Product(2, "Egg", 2, 8.99));
        products.add(new Product(3, "Chicken", 3, 55.68));
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return products;
    }

    @RequestMapping(path = "/products/{productID}", method = RequestMethod.GET)
    public Product getProductByID (@PathVariable int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }
}
