package com.sage.exp.expenseaccount.controllers;

import com.sage.exp.expenseaccount.services.AuthService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class AuthController {

    @Autowired
    private  AuthService authService;

    @FXML
    private Button close;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane mainForm;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

//    @Autowired
    public AuthController() {
//        this.authService = authService;
    }

    @FXML
    protected void onLogin() throws IOException {
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            showErrorAlert("Username / password missing");
            return;
        }

        boolean isAuthenticated = authService.authenticate(username.getText(), password.getText());

        if (!isAuthenticated) {
            showErrorAlert("Username / Password incorrect");
            return;
        }

        showInfoAlert("Login Successful!");
        mainForm.getScene().getWindow().hide();
        new NavigationController().switchTo("dashboard.fxml");
    }

    @FXML
    public void close() {
        System.out.println(authService.authenticate("admin", "adminpassword"));
        System.exit(0);
    }

    private void showErrorAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Message");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void showInfoAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public void showLogin(Stage stage, ApplicationContext context) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/sage/exp/expenseaccount/auth-view.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);  // Ensures Spring manages the controller


        Scene scene = new Scene(fxmlLoader.load());

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

    }
}