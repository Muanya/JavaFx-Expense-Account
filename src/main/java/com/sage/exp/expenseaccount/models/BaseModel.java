package com.sage.exp.expenseaccount.models;

import com.j256.ormlite.field.DatabaseField;

public class BaseModel {
    @DatabaseField(generatedId = true)
    private long id;

    public long getId() {
        return id;
    }
}
