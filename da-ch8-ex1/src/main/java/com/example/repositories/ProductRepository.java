package com.example.repositories;

import com.example.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    private final DataSource dataSource;

    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Product findProduct(int id) throws SQLException {
        String sql = "SELECT * FROM product WHERE id = ?";

        Connection con = dataSource.getConnection();
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                Product p = new Product();
                p.setId(result.getInt("id"));
                p.setName(result.getString("name"));
                return p;
            }
        }
        return null;
    }
}
