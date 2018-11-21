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

public class Register implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField uField;
   
    @FXML
    private PasswordField pField1, pField2;
    
    @FXML
    private Connection c;
    private final String database = "jdbc:sqlite:eradb.db";
    private PreparedStatement pstmt;
    
    private boolean check(String user) throws SQLException {
        pstmt = c.prepareStatement("SELECT * FROM users WHERE username=?");
        pstmt.setString(1, user);
        ResultSet rs = pstmt.executeQuery();
        boolean duplicate = rs.next();  
        return duplicate;
      }
    
    @FXML
    public void onRegistration(ActionEvent event) throws SQLException, IOException {
        
        String username = uField.getText().trim();     
        String password1 = pField1.getText().trim(); 
        String password2 = pField2.getText().trim();
        
        if(password1.equals(password2) && !check(username)) {
            pstmt = c.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            pstmt.setString(1, uField.getText().trim());
            pstmt.setString(2, pField1.getText().trim());
            pstmt.executeUpdate();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        }   else {
                uField.setText("");
                pField1.setText("");
                pField2.setText("");
                label.setText("Passwords don't match or Username already exists.");
            }
        }
    
    @FXML
    public void onBack(ActionEvent event) throws IOException {
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
       try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(database);
            System.out.println("~~~Connection Successful~~~");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
}
