package com.sage.exp.expenseaccount.managers;

import com.google.inject.Inject;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sage.exp.expenseaccount.models.Admin;
import com.sage.exp.expenseaccount.utils.ApplicationUtil;

import java.sql.SQLException;

public class DatabaseManager {

    private final ApplicationUtil props;
    private ConnectionSource connectionSource;

    @Inject
    public DatabaseManager(ApplicationUtil props) {
        this.props = props;
        initDatabase();
    }

    private void initDatabase() {
        try {
            connectionSource = new JdbcConnectionSource(props.getDbUrl(), props.getDbUsername(), props.getDbPassword());
            TableUtils.createTableIfNotExists(connectionSource, Admin.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ConnectionSource getConnection() throws SQLException {
        return connectionSource;
    }
}
