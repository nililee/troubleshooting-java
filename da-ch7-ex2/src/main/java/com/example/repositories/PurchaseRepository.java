package com.example.repositories;

import com.example.model.Purchase;
import com.example.repositories.mappers.PurchaseRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Purchase> findAll() {
        String sql = "SELECT * FROM purchase";
        return jdbcTemplate.query(sql, new PurchaseRowMapper());
    }
}
