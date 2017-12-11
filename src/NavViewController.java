/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class NavViewController implements Initializable {

    @FXML
    Button actionTarget;
    @FXML
    Button testPersonalityButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (PersistentDataController.getPersistentDataCntl().getIsEmployer()) {
            testPersonalityButton.setText("Job");
            testPersonalityButton.setLayoutX(308);
        }
    }

    @FXML
    private void handleSearchButtonAction() {
        Stage theStage = (Stage) actionTarget.getScene().getWindow();
        SearchController.getSearchController(theStage);
    }

    @FXML
    private void handleProfileButtonAction() {
        Stage theStage = (Stage) actionTarget.getScene().getWindow();
        ProfileController.getProfileController(theStage);
    }

    @FXML
    private void handleTestPersonalityButtonAction() {
        Stage theStage = (Stage) actionTarget.getScene().getWindow();
        if (PersistentDataController.getPersistentDataCntl().getIsEmployer()) {
            JobController.getJobController(theStage);
        } else {
            TestPersonalityController.getTestPersonalityController(theStage);
        }
    }

    @FXML
    private void handleCareerProfileButtonAction() {
        Stage theStage = (Stage) actionTarget.getScene().getWindow();
        CareerProfileController.getCareerProfileController(theStage);
    }

    @FXML
    private void handleLogOffButtonAction() {
        Stage theStage = (Stage) actionTarget.getScene().getWindow();
        LoginController.getLoginController(theStage);
    }

    @FXML
    private void handleHomeButtonAction() {
        Stage theStage = (Stage) actionTarget.getScene().getWindow();
        NavController.getNavController(theStage);
    }

}
