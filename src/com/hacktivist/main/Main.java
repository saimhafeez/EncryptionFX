package com.hacktivist.main;

import com.hacktivist.dialogpane.StartupDialog_Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static Stage strprimaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/com/hacktivist/dialogpane/StartupDialog_FXML.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        strprimaryStage = primaryStage;
        primaryStage.show();

        new StartupDialog_Controller().oneTimeRun(); //this sets the scene to main menu after splashScreen is completed

    }

    public static void main(String[] args) {
        launch(args);
    }
}
