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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class JobViewController implements Initializable {

    private Stage theStage;
    @FXML
    private TextField jobTitleField;
    @FXML
    private TextField jobDescriptionField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField linkField;
    @FXML
    private ComboBox personalityDrop;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        personalityDrop.getItems().removeAll(personalityDrop.getItems());
        personalityDrop.getItems().addAll("communicator", "hard working", "team leader","good teammates","Invidual worker", "Learner");
    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        NavController.getNavController(theStage);
    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        SearchController.getSearchController(theStage);
    }

    @FXML
    private void handleProfileButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        ProfileController.getProfileController(theStage);
    }

    @FXML
    private void handleLogOffButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        LoginController.getLoginController(theStage);
    }

    @FXML
    private void handleTestPersonalityButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (PersistentDataController.getPersistentDataCntl().getIsEmployer()) {
            JobController.getJobController(theStage);
        } else {
            TestPersonalityController.getTestPersonalityController(theStage);
        }
    }

    @FXML
    private void handleCreateJobButtonAction() {
        String title = jobTitleField.getText();
        String description = jobDescriptionField.getText();
        int salary = Integer.parseInt(salaryField.getText());
        String link = linkField.getText();
        String jobPersonality = personalityDrop.getSelectionModel().getSelectedItem().toString();

        PersistentDataController.getPersistentDataCntl().addJob(title, description, salary, link, jobPersonality);
        PersistentDataController.getPersistentDataCntl().writeSerializedData();
    }
}
