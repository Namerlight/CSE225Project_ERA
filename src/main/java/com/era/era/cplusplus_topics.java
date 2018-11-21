package com.era.era;

import java.io.FileNotFoundException;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


public class cplusplus_topics implements Initializable {
    
     @FXML
    private void onWhatIsCplusplus(ActionEvent event) throws FileNotFoundException {
        Runtime rs = Runtime.getRuntime();
		String file = "topics\\cplus_what-is-cplus";
		 
	    try {
	      rs.exec("notepad "+ file);
	    }
	    catch (IOException e) {
	      System.out.println(e);
	    }   

      
    }
    
      @FXML
    private void onHelloWorld(ActionEvent event) throws FileNotFoundException {
        Runtime rs = Runtime.getRuntime();
		String file = "topics\\cplus_hello-world";
		 
	    try {
	      rs.exec("notepad "+ file);
	    }
	    catch (IOException e) {
	      System.out.println(e);
	    }   

      
    }
   
    @FXML
    private void onDataTypes(ActionEvent event) throws FileNotFoundException {
        Runtime rs = Runtime.getRuntime();
		String file = "topics\\cplus_data-types";
		 
	    try {
	      rs.exec("notepad "+ file);
	    }
	    catch (IOException e) {
	      System.out.println(e);
	    }   

      
    }
     @FXML
    private void onExamples(ActionEvent event) throws FileNotFoundException {
        Runtime rs = Runtime.getRuntime();
		String file = "topics\\cplus_examples";
		 
	    try {
	      rs.exec("notepad "+ file);
	    }
	    catch (IOException e) {
	      System.out.println(e);
	    }   

      
    }
    
    @FXML
    private void onBack(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TopicsList.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Topics List");
        stage.setScene(scene);
        stage.show();
        System.out.println("You clicked me!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
