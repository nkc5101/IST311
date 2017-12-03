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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class ProfileViewController implements Initializable {
    
    @FXML
    Button testPersonalityButton;
    @FXML
    Label careerProfileLabel;
    @FXML
    Label careerChoiceLabel;
    @FXML
    TextField newUsernameField;
    @FXML
    TextField newPasswordField;
    @FXML
    TextField nameField;
    @FXML
    TextField addressField;
    @FXML
    TextField phoneField;
    @FXML
    TextField careerProfileField;
    @FXML
    TextField emailField;
    @FXML
    TextField careerChoiceField;
    @FXML
    Stage theStage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         if(PersistentDataController.getPersistentDataCntl().getIsEmployer()){
            testPersonalityButton.setText("Job");
        }

        if (PersistentDataController.getPersistentDataCntl().getIsEmployer()) {
            EmployerProfile user = PersistentDataController.getPersistentDataCntl().getEmployer();
            careerProfileLabel.setText("Location");
            newUsernameField.setText(user.getUsername());
            newPasswordField.setText(user.getPassword());
            nameField.setText(user.getCompanyName());
            addressField.setText(user.getAddress());
            phoneField.setText(user.getPhonNumber());
            careerProfileField.setText(user.getLocation());

        } else {
            UserProfile user = PersistentDataController.getPersistentDataCntl().getUser();
            newUsernameField.setText(user.getUsername());
            newPasswordField.setText(user.getPassword());
            nameField.setText(user.getName());
            addressField.setText(user.getAddress());
            phoneField.setText(user.getPhonNumber());
            careerProfileField.setText(user.getCareerProfile());
            emailField.setText(user.getEmail());
        }

    }

    @FXML
    private void handleUpdateProfileButtonAction(ActionEvent event) {

        if (!(PersistentDataController.getPersistentDataCntl().getIsEmployer())) {

            String username = newUsernameField.getText();
            String password = newPasswordField.getText();
            String name = nameField.getText();
            String address = addressField.getText();
            String phoneNumber = phoneField.getText();
            String careerProfile = careerProfileField.getText();
            String email = emailField.getText();

            PersistentDataController.getPersistentDataCntl().updateUser(username, password, address, phoneNumber, name, careerProfile, email);
        } else {
            String username = newUsernameField.getText();
            String password = newPasswordField.getText();
            String name = nameField.getText();
            String address = addressField.getText();
            String phoneNumber = phoneField.getText();
            String location = careerProfileField.getText();

            PersistentDataController.getPersistentDataCntl().updateEmployer(username, password, phoneNumber, address, name, location);
        }

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

}
