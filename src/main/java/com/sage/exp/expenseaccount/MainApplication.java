package com.sage.exp.expenseaccount;

import com.sage.exp.expenseaccount.controllers.AuthController;
import com.sage.exp.expenseaccount.managers.DatabaseManager;
import com.sage.exp.expenseaccount.config.ApplicationConfig;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainApplication extends Application {

    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage stage) throws IOException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DatabaseManager.class, ApplicationConfig.class);
        AuthController authController = applicationContext.getBean(AuthController.class);
        authController.showLogin(stage, applicationContext);
    }



    public static void main(String[] args) {
        launch();
    }
}