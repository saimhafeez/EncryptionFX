package com.hacktivist.menuGUI.controller;

import com.hacktivist.main.Main;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class MenuGUI_controller {
    private int count = 1;
    @FXML
    private GridPane stackpane_nav;
    @FXML
    private AnchorPane stackpane_home;

    public void initialize(){
        stackpane_home.toFront();
    }

    @FXML
    private void menuBtn_Action(ActionEvent actionEvent) {
        if(count%2 != 0){
            //stackpane_nav.translateXProperty().set(-Main.strprimaryStage.getWidth());
            //stackpane_nav.toFront();
            //Timeline timeline = new Timeline();
            //KeyValue kv = new KeyValue(stackpane_nav.translateXProperty(), 0, Interpolator.EASE_BOTH);
            //KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            //timeline.getKeyFrames().add(kf);
            //timeline.play();
            //fadePane(stackpane_nav, 0);
            slidePane(stackpane_nav, 4, Main.strprimaryStage.getWidth(), 1);
            count++;
        }else{
            fadePane(stackpane_nav,1);
            count++;
        }

    }

    private void slidePane(Pane pane, int direction, double initialPoint, int paneLocation){
        KeyValue kv = null;
        if (direction == 1){
            pane.translateYProperty().set(initialPoint); // Upward
            kv = new KeyValue(pane.translateYProperty(), 0, Interpolator.EASE_BOTH);
        }else if(direction == 2){
            pane.translateYProperty().set(-initialPoint);  // downward
            kv = new KeyValue(pane.translateYProperty(), 0, Interpolator.EASE_BOTH);
        }else if(direction == 3){
            pane.translateXProperty().set(initialPoint);  //right
            kv = new KeyValue(pane.translateXProperty(), 0, Interpolator.EASE_BOTH);
        }else if(direction == 4){
            pane.translateXProperty().set(-initialPoint); //left
            kv = new KeyValue(pane.translateXProperty(), 0, Interpolator.EASE_BOTH);
        }else {
            System.out.println("invalid argument");
        }
        Timeline timeline = new Timeline();
        if(paneLocation == 1){
            pane.toFront();
        }
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();
        timeline.setOnFinished(t -> {
            if(paneLocation == 0){
                pane.toBack();
            }
        });
    }

    private void fadePane(Pane pane, int fadeOption){
        // 0 for fadeIn -- 1 for fadeOut
        var fadeOutTransition = new FadeTransition(Duration.millis(600));
        if(fadeOption == 0){
            pane.setOpacity(0);
            pane.toFront();
        }
        fadeOutTransition.setOnFinished(evt -> {

            if(fadeOption == 1){
                pane.toBack();
                pane.setOpacity(1);
            }
        });

        fadeOutTransition.setNode(pane);
        if(fadeOption == 1){
            fadeOutTransition.setFromValue(1);
            fadeOutTransition.setToValue(0);
        }else if (fadeOption == 0){
            fadeOutTransition.setFromValue(0);
            fadeOutTransition.setToValue(1);
        }
        fadeOutTransition.play();
    }
}
