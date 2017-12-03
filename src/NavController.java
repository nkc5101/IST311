
import java.awt.Component;
import javafx.event.ActionEvent;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.Arrays;
import javafx.application.Application;
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
 * @author Nate Cox
 */
public class NavController{
    
    @FXML private Stage theStage;
    private static NavController theNavController;
    
    private NavController(Stage theExistingStage){
        theStage = theExistingStage;
        this.setUpNavScene();
        theStage.show();
    }
    
    /**
     *
     * @param stage
     */
    public static NavController getNavController(Stage stage){
        if(theNavController != null){
            theNavController.setUpNavScene();
            return theNavController;
        } else{
            theNavController = new NavController(stage);
        }
        return theNavController;
    }

    private void setUpNavScene() {
       Parent root;
       Scene scene;
       
       try{
           root = FXMLLoader.load(getClass().getResource("NavView.fxml"));
            scene = new Scene(root, 600, 600);
            theStage.setTitle("Navigation");
            theStage.setScene(scene);
            theStage.show();
       } catch(Exception e){
           e.printStackTrace();
       }
    }
    
       

          
}
