package com.sage.exp.expenseaccount.controllers;

import com.sage.exp.expenseaccount.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationController {
    private Stage stage;

    public NavigationController(Stage stage) {
        this.stage = stage;
    }

    public NavigationController() {
        this.stage = new Stage();
    }


    public void switchTo(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dashboard.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }
}
