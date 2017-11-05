
import java.awt.Component;
import javafx.event.ActionEvent;
import java.io.IOException;
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
     Stage stage;
    
    

    @Override
    public void start(Stage stage) throws Exception {
       this.stage = stage;
       root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
       scene = new Scene(root, 600, 600);
       this.stage.setTitle("Job Search");
       this.stage.setScene(scene);
       this.stage.show();
       //switchToSearch();
        
    }
      
    public void switchToSearch() throws IOException
    {
        if(login.getSwitchPanels())
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NavView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            System.out.println("Here we are");
            scene = new Scene(root, 600, 600);
            stage.setScene(scene);
            stage.show();
        }
    }
  
}
