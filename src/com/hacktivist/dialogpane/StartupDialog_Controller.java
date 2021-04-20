package com.hacktivist.dialogpane;

import com.hacktivist.main.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.beans.EventHandler;
import java.io.IOException;

public final class StartupDialog_Controller {
    @FXML
    private AnchorPane startup_parentAnchorPane;
    @FXML
    private ProgressBar startupProgressbar;
    private static ProgressBar strProgressbar;
    public void initialize(){
        strProgressbar = startupProgressbar;
    }

    private static Timeline progressbarTimeLine(){
        Timeline timeline = new Timeline(
        new KeyFrame(Duration.ZERO, new KeyValue(strProgressbar.progressProperty(), 0)),
        new KeyFrame(Duration.seconds(4), new KeyValue(strProgressbar.progressProperty(), 1))
        );
        return timeline;
    }

    public void oneTimeRun() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/hacktivist/menuGUI/MenuGUI_FXML.fxml"));
        Timeline timeline = progressbarTimeLine();
        timeline.playFromStart();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        timeline.setOnFinished(actionEvent -> {
            Main.strprimaryStage.setScene(scene);
        });
    }
}
