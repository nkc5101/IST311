
import javafx.fxml.FXML;
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
 * @author hanson
 */
public class LoginController {
     @FXML Stage stage;
    private static LoginController loginController;
    
    private LoginController(Stage theStage){
        stage = theStage;
        this.setUpLoginControllerScene();
        stage.show();
    }
    
    public static LoginController getLoginController(Stage theStage){
        if(loginController != null){
            return loginController;
        } else{
            loginController = new LoginController(theStage);
        }
        return loginController;
    }

    private void setUpLoginControllerScene() {
       Parent root;
       Scene scene;
       
       try{
           root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
            scene = new Scene(root);
            stage.setTitle("Log in");
            stage.setScene(scene);
            stage.show();
       } catch(Exception e){
           e.printStackTrace();
       }
    }
}
