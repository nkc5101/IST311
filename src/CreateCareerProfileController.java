/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class CreateCareerProfileController implements Initializable {
    
    private Stage theStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void handleSearchButtonAction(ActionEvent event) {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SearchController.getSearchController(theStage);
    }

    @FXML
    private void handleProfileButtonAction(ActionEvent event) {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ProfileController.getProfileController(theStage);
    }

    @FXML
    private void handleTestPersonalityButtonAction(ActionEvent event) {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        if (PersistentDataController.getPersistentDataCntl().getIsEmployer()) {
            JobController.getJobController(theStage);
        } else {
            TestPersonalityController.getTestPersonalityController(theStage);
        }
    }

    @FXML
    private void handleLogOffButtonAction(ActionEvent event) {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        LoginController.getLoginController(theStage);
    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        NavController.getNavController(theStage);
    }
    
    @FXML
    private void createCareerButtonAction(){
        
    }
    
}
