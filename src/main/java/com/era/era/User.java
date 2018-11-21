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

public class User implements Initializable {
    
    @FXML
    private Label change;
    
    @FXML
    private TextField currentuser;
    
    @FXML
    private PasswordField currentpass, newpass, confirmpass;
    
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
   
    
    @FXML
    private void onPasswordChange(ActionEvent event) throws SQLException {
        String curu = currentuser.getText().trim();
        String curp = currentpass.getText().trim();
        String newp = newpass.getText().trim();
        String conp = confirmpass.getText().trim();
        
        if (newp.equals(conp) && check(curu, curp) == true) {
            pstmt = c.prepareStatement("UPDATE users SET password=? WHERE username=?");
            pstmt.setString(1, newp);
            pstmt.setString(2, curu);
            pstmt.executeUpdate();
            change.setText("Password Changed Successfully.");
        } else {
            change.setText("Mismatch between new passwords or\nbetween Username and Password.\nPlease try again");
        }
    }
    
    @FXML
    private void onDeleteUser(ActionEvent event) throws SQLException {
        String curu = currentuser.getText().trim();
        String curp = currentpass.getText().trim();
        
        if (check(curu, curp)) {
            pstmt = c.prepareStatement("DELETE FROM users WHERE username=? AND password=?");
            pstmt.setString(1, curu);
            pstmt.setString(2, curp);
            pstmt.executeUpdate();
            System.out.println("User deleted.");
            change.setText("User successfully removed.");
        }
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
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(database);
            System.out.println("~~~Connection Successful~~~");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
}
