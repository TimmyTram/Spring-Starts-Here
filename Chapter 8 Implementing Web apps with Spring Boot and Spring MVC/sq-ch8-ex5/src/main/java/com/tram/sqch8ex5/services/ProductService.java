package com.tram.sqch8ex5.services; // this is very important to have or else we cannot import properly.

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import com.tram.sqch8ex5.model.Product;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>(); // this is not thread-safe, using for sake of example.

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> findAll() {
        return products;
    }
}