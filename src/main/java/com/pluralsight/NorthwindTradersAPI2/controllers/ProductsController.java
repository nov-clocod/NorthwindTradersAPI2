package com.pluralsight.NorthwindTradersAPI2.controllers;

import com.pluralsight.NorthwindTradersAPI2.models.Product;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/products/filterName", method = RequestMethod.GET)
    public List<Product> filterProductsByName(@RequestParam String productName) {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    @RequestMapping(path = "/products/filterCategoryID", method = RequestMethod.GET)
    public List<Product> filterProductsByCategoryID(@RequestParam int productCategoryID) {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategoryID() == productCategoryID) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    @RequestMapping(path = "/products/filterPrice", method = RequestMethod.GET)
    public List<Product> filterProductsByPriceRange(@RequestParam double minPrice,
                                                    @RequestParam double maxPrice) {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getUnitPrice() >= minPrice && product.getUnitPrice() <= maxPrice) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }
}
