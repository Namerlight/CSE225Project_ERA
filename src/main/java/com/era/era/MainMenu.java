package com.era.era;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainMenu implements Initializable {
    
    @FXML
    private void onUserInfo(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/User.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("User");
        stage.setScene(scene);
        stage.show();
        System.out.println("You clicked me!");       
    }
    
    @FXML
    private void onTopicsList(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TopicsList.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("List of Topics");
        stage.setScene(scene);
        stage.show();
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void onSearch(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Search.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Search");
        stage.setScene(scene);
        stage.show();
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void onLogout(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        System.out.println("You clicked me!");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
