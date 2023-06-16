package com.tram.sqch8ex5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tram.sqch8ex5.model.Product;
import com.tram.sqch8ex5.services.ProductService;

@Controller
public class ProductsController {
    
    private final ProductService productService;


    // this uses DEPENDENCY INJECTION to get service bean from spring context
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    // GET
    //@RequestMapping("/products")

    // this one is better
    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    // POST (need method = RequestMethod.POST because by default is is get if you do not specify)
    //@RequestMapping(path = "/products", method = RequestMethod.POST)

    // This one is better
    // @PostMapping("/products")
    // public String addProduct(
    //     @RequestParam String name,
    //     @RequestParam double price,
    //     Model model
    // ) {
    //         Product p = new Product();
    //         p.setName(name);
    //         p.setPrice(price);
    //         productService.addProduct(p);

    //         var products = productService.findAll();
    //         model.addAttribute("products", products);
    //         return "products.html";
    // }
    

    // don't actually neeed @RequestParam, can just add model class directly as param
    // and Spring is smart enough to create object instance for us.
    @PostMapping("/products")
    public String addProduct(Product p, Model model) {
        productService.addProduct(p);

        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }


}
