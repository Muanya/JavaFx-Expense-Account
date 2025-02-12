package com.sage.exp.expenseaccount.managers;

import com.google.inject.Inject;
import com.sage.exp.expenseaccount.utils.ApplicationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    ApplicationUtil props;

    @Inject
    public DatabaseManager(ApplicationUtil props)  {
        this.props = props;
        initDatabase();
    }

    private void initDatabase() {
        try(Connection conn = getConnection();
            Statement statement = conn.createStatement()) {
            String schema = new String(Files.readAllBytes(Paths.get("src/main/resources/schema/init.sql")));
            String[] queries = schema.split(";");
            for (String query : queries){
                if(!query.trim().isEmpty()){
                    statement.execute(query.trim());
                }
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(props.getDbUrl(), props.getDbUsername(), props.getDbPassword());
    }
}
