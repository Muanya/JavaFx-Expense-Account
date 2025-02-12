package com.sage.exp.expenseaccount;

import com.google.inject.Guice;
import com.google.inject.Injector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {
    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage stage) throws IOException {
        Injector injector = Guice.createInjector(new AppModule());

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("auth-view.fxml"));
        fxmlLoader.setControllerFactory(injector::getInstance);

        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}