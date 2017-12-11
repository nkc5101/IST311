/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class CreateCareerProfileController implements Initializable {

    private Stage theStage;
    @FXML
    private TextField nameField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField requiredSkillsField;

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
    private void handleJobButtonAction(ActionEvent event) {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        JobController.getJobController(theStage);
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
    private void createCareerButtonAction() {
        String name = nameField.getText();
        String description = descriptionField.getText();
        String contents = requiredSkillsField.getText();
        String[] items = contents.split(",");
        ArrayList<String> requiredSkills = new ArrayList<String>(Arrays.asList(items));

        PersistentDataController.getPersistentDataCntl().addCareerProfile(name, description, requiredSkills);

    }

}
