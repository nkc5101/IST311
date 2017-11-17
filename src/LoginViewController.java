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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class LoginViewController implements Initializable {
    
    public boolean switchPanels = false;
    @FXML private Label invalidLabel;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label invalidResponse;
    @FXML private TextField newUsernameField;
    @FXML private PasswordField newPasswordField;
    @FXML private PasswordField reEnterPasswordField;
    @FXML private TextField emailField;
    @FXML private TextField nameField;
    @FXML private TextField phoneNumberField;
    @FXML private TextField addressField;
    @FXML private TextField careerChoiceField;
    private ObservableList<UserProfile> theListOfUsers;
   
    
    
    
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event)  throws IOException  {
        
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println(theListOfUsers.size());
        if(listOfUsers.Authenticate(username, password, theListOfUsers)){
            Parent search_view_parent = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
            Scene search_view_scene = new Scene(search_view_parent, 600, 600);
            Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            login_stage.setScene(search_view_scene);
            login_stage.show();
        } else{
           passwordField.clear();
           invalidResponse.setText("Incorrect Username or Password");
        }
        
    }
    
    
    
    @FXML public void handleCreateProfileButtonAction(ActionEvent event) throws IOException{
        
        Parent createProfileParent = FXMLLoader.load(getClass().getResource("CreateProfile.fxml"));
        Scene createProfileScene = new Scene(createProfileParent, 600, 600);
        Stage createProfileStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        createProfileStage.setScene(createProfileScene);
        createProfileStage.show();

    }
    
    @FXML public void handleProfileCreation(ActionEvent event) throws IOException{
        
        String newUsername = newUsernameField.getText();
        String newPassword = newPasswordField.getText();
        String reEnteredPassword = reEnterPasswordField.getText();
        String email = emailField.getText();
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String address = addressField.getText();
        String careerChoice = careerChoiceField.getText();
        
        
                
        if(newPassword.equals(reEnteredPassword)){
            UserProfile newUser = new UserProfile(newUsername, newPassword, email, phoneNumber, address, name, careerChoice);
            theListOfUsers.add(newUser);
            System.out.println(listOfUsers.size());
            returnToLogin(event, theListOfUsers);
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
   
    
    private void returnToLogin(ActionEvent event, ObservableList<UserProfile> theListOfUsers) throws IOException{
        this.theListOfUsers = theListOfUsers;
        Parent loginParent = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene loginScene = new Scene(loginParent, 600, 600);
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginStage.setScene(loginScene);
        loginStage.show();
    }

}
