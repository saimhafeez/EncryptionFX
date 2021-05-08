package com.hacktivist.menuGUI.controller;

import com.hacktivist.animateFX.*;
import com.hacktivist.main.Main;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;

public class MenuGUI_controller {

    private int count;
    private int imageCount = 0;
    private boolean msgEncCheckList01;
    private boolean msgEncCheckList02;
    @FXML
    private TextArea msgEncryption_textArea;
    @FXML
    private Button encrypt_button;
    @FXML
    private TextArea encMessage_textArea;
    @FXML
    private ImageView passCheckList_imageView;
    @FXML
    private Label msgEncCheckList_Label01;
    @FXML
    private Label msgEncCheckList_Label02;
    @FXML
    private AnchorPane stackpane_msgEnc;
    @FXML
    private GridPane stackpane_nav;
    @FXML
    private AnchorPane stackpane_home;
    @FXML
    private ImageView slideShow_ImageView;
    @FXML
    private PasswordField msgEncPass_passwordField;
    @FXML
    private RadioButton masEncPass_radioButton;

    public void initialize(){
        stackpane_home.toFront();
        startupSlideShow();
        masEncPass_radioButton.setSelected(true);
        msgEncPassCheck_action(null);
        checkPasswordRecommendation(null);
        Tooltip.install(passCheckList_imageView, new Tooltip("Requirements Don't Meet!"));
        Main.encryptMessage.storeKeys();
    }

    @FXML
    private void menuBtn_Action(ActionEvent actionEvent) {
        if(count == 0){
            new SlideInLeft(stackpane_nav).play();
            stackpane_nav.toFront();
            //slidePane(stackpane_nav, 4, Main.strprimaryStage.getWidth(), 1);
            count = 1;
        }else{
            new SlideOutLeft(stackpane_nav).play();
            new SlideInLeft(stackpane_nav).setOnFinished(event ->{
                stackpane_nav.toBack();
            });
            //fadePane(stackpane_nav,1);
            count = 0;
        }

    }

    private void slidePane(Pane pane, int direction, double initialPoint, int paneLocation){
        KeyValue kv = null;
        if (direction == 1){
            pane.translateYProperty().set(initialPoint); // Upward
            kv = new KeyValue(pane.translateYProperty(), 0, Interpolator.EASE_IN);
        }else if(direction == 2){
            pane.translateYProperty().set(-initialPoint);  // downward
            kv = new KeyValue(pane.translateYProperty(), 0, Interpolator.EASE_IN);
        }else if(direction == 3){
            pane.translateXProperty().set(initialPoint);  //right
            kv = new KeyValue(pane.translateXProperty(), 0, Interpolator.EASE_IN);
        }else if(direction == 4){
            pane.translateXProperty().set(-initialPoint); //left
            kv = new KeyValue(pane.translateXProperty(), 0, Interpolator.EASE_IN);
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

    private void startupSlideShow(){
        File file1 = new File("src/com/hacktivist/menuGUI/images/slide01.jpg");
        Image image1 = new Image(file1.toURI().toString());
        slideShow_ImageView.setImage(image1);
        String[] photos = {"slide01.jpg", "slide02.jpg", "slide03.jpg"};
        Timeline slideshowTimeline = new Timeline(new KeyFrame(Duration.seconds(8), event -> {
            if(imageCount != 3){
                File file = new File("src/com/hacktivist/menuGUI/images/" + photos[imageCount]);
                Image image = new Image(file.toURI().toString());
                slideShow_ImageView.setImage(image);
                imageCount++;
            }else{
                imageCount = 0;
            }
        }));
        slideshowTimeline.setCycleCount(Timeline.INDEFINITE);
        slideshowTimeline.play();
    }

    @FXML
    private void msgEncPassCheck_action(ActionEvent actionEvent) {
        if(masEncPass_radioButton.isSelected()){
            msgEncPass_passwordField.setVisible(true);
            msgEncCheckList_Label01.setVisible(true);
            msgEncCheckList_Label02.setVisible(true);
            // Enable or Disable the Encrypt Button According to Password Check List
            if(msgEncCheckList01 && msgEncCheckList02){
                encrypt_button.setDisable(false);
                passCheckList_imageView.setVisible(false);
            }else {
                encrypt_button.setDisable(true);
                passCheckList_imageView.setVisible(true);
            }

        }else{
            msgEncPass_passwordField.setVisible(false);
            msgEncCheckList_Label01.setVisible(false);
            msgEncCheckList_Label02.setVisible(false);
            encrypt_button.setDisable(false);
            passCheckList_imageView.setVisible(false);
        }
    }

    @FXML
    private void checkPasswordRecommendation(KeyEvent inputMethodEvent) {
        if(msgEncPass_passwordField.getText().length() != 8){
            msgEncCheckList_Label01.setStyle("-fx-text-fill: red");
            msgEncCheckList01 = false;
        }else{
            msgEncCheckList_Label01.setStyle("-fx-text-fill: green");
            msgEncCheckList01 = true;
        }
        String passText = msgEncPass_passwordField.getText();
        boolean state = false;
        for(int i=0; i<passText.length(); i++){
            if(passText.charAt(i) != passText.charAt(0)){
                state = true;
            }else{
                state = false;
            }
        }
        if(state && msgEncPass_passwordField.getText().length() == 8){
            msgEncCheckList_Label02.setStyle("-fx-text-fill: green");
            msgEncCheckList02 = true;
        }else{
            msgEncCheckList_Label02.setStyle("-fx-text-fill: red");
            msgEncCheckList02 = false;
        }
        if(msgEncCheckList01 && msgEncCheckList02){
            encrypt_button.setDisable(false);
            passCheckList_imageView.setVisible(false);
        }else {
            encrypt_button.setDisable(true);
            passCheckList_imageView.setVisible(true);
        }
    }

    public void encryptMessage_action(ActionEvent actionEvent) {
        String userMessage = msgEncryption_textArea.getText();
        if(masEncPass_radioButton.isSelected()){
            System.out.println(msgEncPass_passwordField.getText());
            userMessage = userMessage.concat(msgEncPass_passwordField.getText());
        }
        String temp = Main.encryptMessage.getEncryptMsg(userMessage);
        encMessage_textArea.setText(temp);
        System.out.println(temp);
    }

    public void navigate_home(ActionEvent actionEvent) {
        SlideOutLeft slideOutLeft = new SlideOutLeft(stackpane_nav);
        slideOutLeft.play();
        slideOutLeft.setOnFinished(actionEvent1 -> {
            stackpane_home.toFront();
            count = 0;
        });

    }

    public void navigate_msgEnc(ActionEvent actionEvent) {
        SlideOutLeft slideOutLeft = new SlideOutLeft(stackpane_nav);
        slideOutLeft.play();
        slideOutLeft.setOnFinished(actionEvent1 -> {
            stackpane_msgEnc.toFront();
            count = 0;
        });
    }
}
