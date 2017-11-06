import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    private UserProfile testUser = new UserProfile("username", "password", null, null, null, null, null);
    private ArrayList<UserProfile> testUsers = new ArrayList<UserProfile>();
    private UserProfile test;
    
    
    
    /**
     *
     * @param event
     * @throws java.io.IOException
     */
    @FXML protected void handleSubmitButtonAction(ActionEvent event)  throws IOException  {
    
        switchPanels = true;
        if(authenticated()){
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
        Scene search_view_scene = new Scene(search_view_parent, 600, 600);
        Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login_stage.setScene(search_view_scene);
        login_stage.show();
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
            test = new UserProfile(newUsername, newPassword, email, phoneNumber, address, name, careerChoice);
            testUsers.add(test);
            System.out.println(test.getUsername());
            System.out.println(test.getPassword());
            System.out.println(testUsers.size());
            
            returnToLogin(event);
        }
        
    }
    
    public boolean getSwitchPanels()
    {
        return switchPanels;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    private boolean authenticated(){
        String username = usernameField.getText();
        String password = passwordField.getText();
        testUsers.add(testUser);
        boolean authenticated = false;
        
        
        for(int i=0; i<testUsers.size(); i++){
            String testUsername = testUsers.get(i).getUsername();
            String testPassword = testUsers.get(i).getPassword();
            System.out.println(testUsername);
            System.out.println(testPassword);
            System.out.println(testUsers.size());
            if(testUsername.equals(username) && testPassword.equals(password)){
            authenticated = true;
            
            } 
        }
        if(!authenticated){
            passwordField.clear();
            invalidResponse.setText("Incorrect Username or Password");
        }
        
        return authenticated;
    }
    
    private void returnToLogin(ActionEvent event) throws IOException{
        Parent loginParent = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene loginScene = new Scene(loginParent, 600, 600);
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginStage.setScene(loginScene);
        loginStage.show();
    }

}
