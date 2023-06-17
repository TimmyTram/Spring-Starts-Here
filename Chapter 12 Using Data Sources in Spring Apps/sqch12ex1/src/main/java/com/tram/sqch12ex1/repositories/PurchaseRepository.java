package com.tram.sqch12ex1.repositories;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tram.sqch12ex1.models.Purchase;

@Repository
public class PurchaseRepository {
    
    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {
        // page 276 states "INSERT INTO purchase VALUES (NULL, ?, ?)", that does not work
        // with newest version of h2, use DEFAULT instead.
        String sql = "INSERT INTO purchase VALUES (DEFAULT, ?, ?)";
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchase";

       RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(r.getInt("id"));
            rowObject.setProduct(r.getString("product"));
            rowObject.setPrice(r.getBigDecimal("price"));
            return rowObject;
       };

       return jdbc.query(sql, purchaseRowMapper);
    }

}
