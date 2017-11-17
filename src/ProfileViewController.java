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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class ProfileViewController implements Initializable {

    @FXML TextField newUsernameField;
    @FXML TextField newPasswordField;
    @FXML TextField nameField;
    @FXML TextField addressField;
    @FXML TextField phoneField;
    @FXML TextField descriptionField;
    UserProfile user = PersistentDataController.getPersistentDataCntl().getUser();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newUsernameField.setText(user.getUsername());
        newPasswordField.setText(user.getPassword());
        nameField.setText(user.getName());
        addressField.setText(user.getAddress());
        phoneField.setText(user.getPhonNumber());
        descriptionField.setText(user.getComments());
        
    }  
    
    @FXML private void handleUpdateProfileButtonAction(ActionEvent event){
        String username = newUsernameField.getText();
        String password = newPasswordField.getText();
        String name = nameField.getText();
        String address = addressField.getText();
        String phoneNumber = phoneField.getText();
        String description = descriptionField.getText();
        
        PersistentDataController.getPersistentDataCntl().updateUser(username, password, address, phoneNumber, name, description);
    }
    
}
