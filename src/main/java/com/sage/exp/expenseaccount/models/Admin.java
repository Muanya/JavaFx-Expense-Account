package com.sage.exp.expenseaccount.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "ADMIN")
public class Admin extends BaseModel{
    @DatabaseField(columnName = "USERNAME", canBeNull = false)
    private String username;

    @DatabaseField(columnName = "PASSWORD", canBeNull = false)
    private  String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
