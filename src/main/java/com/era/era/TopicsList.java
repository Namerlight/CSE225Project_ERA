package com.era.era;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class TopicsList implements Initializable {
    
    @FXML
    private Label listoftopics;
    
    @FXML
    private TextArea topicsoutput;
    
    private File f1 = new File("c.txt");
    private File f2 = new File("c++.txt");
    private File f3 = new File("java.txt");
    
    @FXML
    private void onC(ActionEvent event) throws FileNotFoundException, IOException {
      
       ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/c_topics.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("c_topics");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void onCplusplus(ActionEvent event) throws FileNotFoundException, IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/cplusplus_topics.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("cplusplus_topics");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void onJava(ActionEvent event) throws FileNotFoundException, IOException {
        
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/java_topics.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Java_topics");
        stage.setScene(scene);
        stage.show();
          }
    
    @FXML
    private void onBack(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}    

