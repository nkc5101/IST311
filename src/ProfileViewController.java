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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        /*newUsernameField.setText(user.getUsername());
        newPasswordField.setText(user.getPassword());
        nameField.setText(user.getName());
        addressField.setText(user.getAddress());
        phoneField.setText(user.getPhonNumber());
        descriptionField.setText(user.getComments());*/
        
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
    
        @FXML private void handleHomeButtonAction(ActionEvent event) throws IOException{
        System.out.println("It works");
            Parent search_view_parent = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
            Scene search_view_scene = new Scene(search_view_parent, 600, 600);
            Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            login_stage.setScene(search_view_scene);
            login_stage.show();
    }
    
    @FXML private void handleSearchButtonAction(ActionEvent event) throws IOException
    {
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
            Scene search_view_scene = new Scene(search_view_parent, 600, 600);
            Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            login_stage.setScene(search_view_scene);
            login_stage.show();
    }
    
    @FXML private void handleProfileButtonAction(ActionEvent event) throws IOException
    {
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("ProfileView.fxml"));
            Scene search_view_scene = new Scene(search_view_parent, 600, 600);
            Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            login_stage.setScene(search_view_scene);
            login_stage.show();
    }
    
    @FXML private void handleLogOffButtonAction(ActionEvent event) throws IOException
    {
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
            Scene search_view_scene = new Scene(search_view_parent, 600, 600);
            Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            login_stage.setScene(search_view_scene);
            login_stage.show();
    }
    
    @FXML private void handleTestPersonalityButtonAction(ActionEvent event) throws IOException
    {
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("TestPersonalityView.fxml"));
            Scene search_view_scene = new Scene(search_view_parent, 600, 600);
            Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            login_stage.setScene(search_view_scene);
            login_stage.show();
    }
    
}
