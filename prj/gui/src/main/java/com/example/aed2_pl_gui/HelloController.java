package com.example.aed2_pl_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private MenuBar menuBar;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}