package com.example.repositories.mappers;

import com.example.model.Purchase;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PurchaseRowMapper implements RowMapper<Purchase> {

    @Override
    public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
        Purchase p = new Purchase();

        p.setId(rs.getInt("id"));
        p.setProduct(rs.getInt("product"));
        p.setPrice(rs.getBigDecimal("price"));

        return p;
    }
}
