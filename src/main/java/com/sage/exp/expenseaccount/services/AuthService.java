package com.sage.exp.expenseaccount.services;

import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.sage.exp.expenseaccount.managers.DatabaseManager;
import com.sage.exp.expenseaccount.models.Admin;

import java.sql.SQLException;
import java.util.List;

public class AuthService {
    DatabaseManager manager;

    @Inject
    public AuthService(DatabaseManager manager) {
        this.manager = manager;
    }

    public boolean authenticate(String username, String password) {
        try {
            Dao<Admin, Long> dao = DaoManager.createDao(manager.getConnection(), Admin.class);
            List<Admin> admin = dao.queryBuilder().where().eq("USERNAME", username)
                    .and().eq("PASSWORD", password).query();
            return admin.size() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
