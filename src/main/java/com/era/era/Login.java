package com.era.era;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login implements Initializable {
    
    
    @FXML
    private Label label;
    
    @FXML
    private TextField uField;
   
    @FXML
    private PasswordField pField;
    
    private Connection c;
    private PreparedStatement pstmt;
    private final String database = "jdbc:sqlite:eradb.db";
    
    private boolean check(String user, String pass) throws SQLException {
        pstmt = c.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
        pstmt.setString(1, user);
        pstmt.setString(2, pass);
        ResultSet rs = pstmt.executeQuery();
        boolean login = rs.next();  
        return login;
    }
    
    public final String userid() {
        String userid = uField.getText().trim();
        return userid;
    }
    
    @FXML
    public void onLogin(ActionEvent event) throws SQLException, IOException {
        String username = uField.getText().trim();     
        String password = pField.getText().trim(); 
         
        if (check(username, password)) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            scene.getStylesheets().add("/styles/Styles.css");

            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
            c.close();
            
        }   else{
                uField.setText("");
                pField.setText("");
                label.setText("Username doesnt exist\nor Password Mismatch");
            }
        }
    
    @FXML
    public void onCancel(ActionEvent event) {
        uField.setText("");
        pField.setText("");
        label.setText("Cleared");
    }
    
    @FXML
    public void onRegister (ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Register.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Register");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void onQuit(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(database);
            System.out.println("~~~Connection Successful~~~");
        } catch (Exception e) {
            System.out.println("Not connecting");
        }
        
    }    
}
