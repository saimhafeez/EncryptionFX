package com.hacktivist.menuGUI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
            stackpane_nav.toFront();
            count++;
        }else{
            stackpane_nav.toBack();
            count++;
        }

    }
}
