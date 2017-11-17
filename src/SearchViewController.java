/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class SearchViewController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML protected void handleProfileButtonAction(ActionEvent event) throws IOException{
        Parent profileViewParent = FXMLLoader.load(getClass().getResource("ProfileView.fxml"));
        Scene profileViewScene = new Scene(profileViewParent, 600, 600);
        Stage profileStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        profileStage.setScene(profileViewScene);
        profileStage.show();
    } 
    
    @FXML protected void handleTestPersonalityButtonAction(ActionEvent event) throws IOException{
        Parent testPersonalityViewParent = FXMLLoader.load(getClass().getResource("TestPersonalityView.fxml"));
        Scene testPersonalityViewScene = new Scene(testPersonalityViewParent, 600, 600);
        Stage testPersonalityStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        testPersonalityStage.setScene(testPersonalityViewScene);
        testPersonalityStage.show();
    } 
    
}
