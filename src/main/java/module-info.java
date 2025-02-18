module com.sage.exp.expenseaccount {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;
    requires ormlite.jdbc;
    requires spring.beans;
    requires spring.context;
    requires spring.core;

    opens com.sage.exp.expenseaccount to javafx.fxml;
    opens com.sage.exp.expenseaccount.config to javafx.fxml, spring.core;
    opens com.sage.exp.expenseaccount.managers to spring.core;
    opens com.sage.exp.expenseaccount.services to spring.core;
    opens com.sage.exp.expenseaccount.controllers to spring.core, javafx.fxml;
    opens com.sage.exp.expenseaccount.models to ormlite.jdbc;


    exports com.sage.exp.expenseaccount;
    exports com.sage.exp.expenseaccount.controllers;
    exports com.sage.exp.expenseaccount.services;
    exports com.sage.exp.expenseaccount.config;
    exports com.sage.exp.expenseaccount.managers;
    exports com.sage.exp.expenseaccount.models;


}