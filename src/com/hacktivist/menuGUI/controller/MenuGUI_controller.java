package com.hacktivist.menuGUI.controller;

import com.hacktivist.animateFX.*;
import com.hacktivist.encryption.SimpleOperations;
import com.hacktivist.exceptions.InvalidDecryptionInputException;
import com.hacktivist.exceptions.InvalidEncryptionInputException;
import com.hacktivist.main.Main;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
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

    public AnchorPane decryptionPassword_anchorPane;
    public Label decMsgLive_label;
    public ImageView decMsgLive_imageView;
    public Button decrypt_button;
    public PasswordField decryption_passwordField;
    public TextArea decMsgOutput_textArea;
    private int count;
    private int imageCount = 0;
    private boolean msgEncCheckList01;
    private boolean msgEncCheckList02;
    private String passwordFetched;
    @FXML
    private TextArea decMsgInput_textArea;
    @FXML
    private AnchorPane stackpane_msgDec;
    private Tooltip viewPass_tooltip = new Tooltip("");
    @FXML
    private ImageView viewPass_imageView;
    @FXML
    private ToggleButton viewPass_toggleButton;
    @FXML
    private ImageView passwordIMG_imageView;
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
        vewPassword_action(null);
        decryptMsgTextAreaChanged(null);
        Tooltip.install(passCheckList_imageView, new Tooltip("Requirements Don't Meet!"));
        Main.encryptMessage.performAutomatedRequiredEvents();

        try {
            InvalidEncryptionInputException.validate("saim  /hafeez - son--\nwow");
            System.out.println("hellow orld");
        } catch (Exception e) {
            e.getMessage();
        }

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
            passwordIMG_imageView.setVisible(true);
            viewPass_toggleButton.setVisible(true);
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
            passwordIMG_imageView.setVisible(false);
            viewPass_toggleButton.setVisible(false);
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

        if(viewPass_toggleButton.isSelected()){
            viewPass_tooltip.setText(msgEncPass_passwordField.getText());
            vewPassword_action(null);
        }
    }

    public void encryptMessage_action(ActionEvent actionEvent) throws InvalidEncryptionInputException {
        String userMessage = msgEncryption_textArea.getText();

        try{
            InvalidEncryptionInputException.validate(userMessage);
            if(masEncPass_radioButton.isSelected()){
                System.out.println(msgEncPass_passwordField.getText());
                userMessage = userMessage.concat(msgEncPass_passwordField.getText());
            }
            String temp = Main.encryptMessage.getEncryptMsg(userMessage);
            encMessage_textArea.setText(temp);
            System.out.println(temp);
        } catch (InvalidEncryptionInputException e) {
            e.getMessage();
        }

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

    public void navigate_msgDec(ActionEvent actionEvent) {
        SlideOutLeft slideOutLeft = new SlideOutLeft(stackpane_nav);
        slideOutLeft.play();
        slideOutLeft.setOnFinished(actionEvent1 -> {
            stackpane_msgDec.toFront();
            count = 0;
        });
    }

    public void vewPassword_action(ActionEvent actionEvent) {
        File unhideFile = new File("src/com/hacktivist/menuGUI/images/unhide.png");
        File hideFile = new File("src/com/hacktivist/menuGUI/images/hide.png");
        Image unhideImage = new Image(unhideFile.toURI().toString());
        Image hideImage = new Image(hideFile.toURI().toString());

        Point2D p = msgEncPass_passwordField.localToScene(msgEncPass_passwordField.getBoundsInLocal().getMaxX(), msgEncPass_passwordField.getBoundsInLocal().getMaxY());

        if(viewPass_toggleButton.isSelected()){
            viewPass_imageView.setImage(unhideImage);
            viewPass_toggleButton.setText("UnHide");
            viewPass_tooltip.setText(msgEncPass_passwordField.getText());
            if(!msgEncPass_passwordField.getText().equals("")){
                viewPass_tooltip.show(msgEncPass_passwordField,
                        p.getX() + Main.strprimaryStage.getScene().getX() + Main.strprimaryStage.getX(),
                        p.getY() + Main.strprimaryStage.getScene().getY() + Main.strprimaryStage.getY()
                );
            }
            Timeline resetToggleButton = new Timeline(new KeyFrame(Duration.seconds(3)));
            resetToggleButton.play();
            resetToggleButton.setOnFinished(event ->{
                viewPass_tooltip.hide();
                viewPass_toggleButton.setSelected(false);
            });

        }else{
            viewPass_imageView.setImage(hideImage);
            viewPass_toggleButton.setText("Hide");
            viewPass_tooltip.hide();
        }
    }

    public void analyseDecryptionMessage(ActionEvent actionEvent) {
        File loadingStatic = new File("src/com/hacktivist/menuGUI/images/decrypt_loading_static.png");
        File loadingGif = new File("src/com/hacktivist/menuGUI/images/decrypt_loading_nonstatic.gif");
        File loadingCompleted = new File("src/com/hacktivist/menuGUI/images/decrypt_loading_completed.png");

        if(decMsgInput_textArea.getText().length() < 9){
            //popup message here...
        }else{
            passwordFetched = Main.encryptMessage.getDecryptedMessage(decMsgInput_textArea.getText().substring(decMsgInput_textArea.getText().length() - 8));
            System.out.println("password: " + passwordFetched);
            decMsgLive_label.setText("Analysing Data");
            decMsgLive_imageView.setImage(new Image(loadingGif.toURI().toString()));
            Timeline loadingTimeline = new Timeline(new KeyFrame(Duration.seconds(4)));
            loadingTimeline.play();
            if(SimpleOperations.ifPasswordRequired(passwordFetched)){
                loadingTimeline.setOnFinished(event1 -> {
                    if(decryption_passwordField.getText().equals("")){
                        decryptionPassword_anchorPane.setDisable(false);
                        decMsgLive_imageView.setImage(new Image(loadingStatic.toURI().toString()));
                        decMsgLive_label.setText("Password Required to Decrypt");
                        decrypt_button.setDisable(true);
                    }else{
                        String userEnteredPassword = decryption_passwordField.getText();
                        if(passwordFetched.equals(userEnteredPassword)){
                            decMsgLive_label.setText("Ready to Decrypt");
                            decMsgLive_imageView.setImage(new Image(loadingCompleted.toURI().toString()));
                            decrypt_button.setDisable(false);
                        }else{
                            //popup message here...
                            decryptPasswordFieldModifyEvent(null);
                        }
                    }
                });
            }else {
                loadingTimeline.setOnFinished(event1 -> {
                    decMsgLive_imageView.setImage(new Image(loadingCompleted.toURI().toString()));
                    decMsgLive_label.setText("No password Required, Ready to Decrypt");
                    decrypt_button.setDisable(false);
                });
            }
        }
    }

    public void decryptMsgTextAreaChanged(KeyEvent keyEvent) {
        decMsgLive_label.setText("Enter Message and Press Analyse");
        decrypt_button.setDisable(true);
        decryptionPassword_anchorPane.setDisable(true);
        decryption_passwordField.setText("");
        File loadingStatic = new File("src/com/hacktivist/menuGUI/images/decrypt_loading_static.png");
        decMsgLive_imageView.setImage(new Image(loadingStatic.toURI().toString()));
    }

    public void decryptMessage_action(ActionEvent actionEvent) throws InvalidDecryptionInputException{
        try{
            InvalidDecryptionInputException.validate(decMsgInput_textArea.getText());
            String decryptedMessage = Main.encryptMessage.getDecryptedMessage(decMsgInput_textArea.getText()).substring(0, decMsgInput_textArea.getText().length() - 8);
            decMsgOutput_textArea.setText(decryptedMessage);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void decryptPasswordFieldModifyEvent(KeyEvent keyEvent) {
        decrypt_button.setDisable(true);
        File loadingStatic = new File("src/com/hacktivist/menuGUI/images/decrypt_loading_static.png");
        decMsgLive_imageView.setImage(new Image(loadingStatic.toURI().toString()));
        decMsgLive_label.setText("Password Required to Decrypt");
    }

    private void checkForValidInput(String userMsgInput) throws InvalidDecryptionInputException {
        for(int i=0;i<userMsgInput.length(); i++){

        }
    }
}
