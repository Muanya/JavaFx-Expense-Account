package com.sage.exp.expenseaccount.services;

import com.google.inject.Inject;
import com.sage.exp.expenseaccount.managers.DatabaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {
    DatabaseManager manager;

    @Inject
    public AuthService(DatabaseManager manager) {
        this.manager = manager;
    }

    public boolean authenticate(String username, String password) {
        Connection conn;
        try {
            conn = manager.getConnection();
            String query = "SELECT * FROM admin WHERE name = ? and password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();

            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
