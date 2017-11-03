
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.Arrays;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nate Cox
 */
public class NavController extends Application {
    SearchViewController search = new SearchViewController();
    LoginViewController login = new LoginViewController();
    NavViewController navigation;
    
    UserProfile testUser = new UserProfile("username", "password", null, null, null, null);
     Parent root;
     Scene scene;
    
    
    

    @Override
    public void start(Stage stage) throws Exception {
       root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
       scene = new Scene(root, 600, 600);
       stage.setTitle("Job search");
       stage.setScene(scene);
       stage.show();
       
        
    }
      
  
}
