/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class SearchViewController implements Initializable {
    
    private ArrayList<Job> jobList;
    @FXML private TableView searchTable;
    @FXML Stage theStage;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        searchTable.setItems((ObservableList) jobList);
    }    
    
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML protected void handleProfileButtonAction(ActionEvent event) throws IOException{
        theStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
                
        ProfileController.getProfileController(theStage);
    } 
    
    @FXML protected void handleTestPersonalityButtonAction(ActionEvent event) throws IOException{
        theStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
                
        TestPersonalityController.getTestPersonalityController(theStage);
    } 
    
}
