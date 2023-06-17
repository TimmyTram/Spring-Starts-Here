package com.tram.sqch12ex1.models;

import java.math.BigDecimal;

public class Purchase {
    
    private int id;
    private String product;
    
    // we use BigDecimal for better precision.
    private BigDecimal price;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
