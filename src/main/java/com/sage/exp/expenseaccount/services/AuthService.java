package com.sage.exp.expenseaccount.services;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.sage.exp.expenseaccount.managers.DatabaseManager;
import com.sage.exp.expenseaccount.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    DatabaseManager manager;

    public AuthService() {
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
