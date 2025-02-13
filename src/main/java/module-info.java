module com.sage.exp.expenseaccount {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.guice;
    requires java.sql;
    requires com.h2database;
    requires ormlite.jdbc;

    opens com.sage.exp.expenseaccount to javafx.fxml;
    opens com.sage.exp.expenseaccount.utils to javafx.fxml;
    opens com.sage.exp.expenseaccount.controllers to javafx.fxml, com.google.guice;
    opens com.sage.exp.expenseaccount.managers to com.google.guice;
    opens com.sage.exp.expenseaccount.services to com.google.guice;
    opens com.sage.exp.expenseaccount.models to ormlite.jdbc;


    exports com.sage.exp.expenseaccount;
    exports com.sage.exp.expenseaccount.controllers;
    exports com.sage.exp.expenseaccount.utils;
    exports com.sage.exp.expenseaccount.managers;
    exports com.sage.exp.expenseaccount.models;


}