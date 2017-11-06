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
    
    
    /**
     *
     * @param event
     * @throws java.io.IOException
     */
    @FXML protected void handleSubmitButtonAction(ActionEvent event)  throws IOException  {
    
        switchPanels = true;
        if(authenticated()){
            System.out.println("Boom");
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
        Scene search_view_scene = new Scene(search_view_parent);
        Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login_stage.setScene(search_view_scene);
        login_stage.show();
        }
        
    }
    
    
    
    @FXML public void handleCreateProfileButtonAction(ActionEvent event){
        
        switchPanels = true;
        System.out.println("bang");

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
        UserProfile testUser = new UserProfile("username", "password", null, null, null, null);
        String testUsername = testUser.getUsername();
        String testPassword = testUser.getPassword();
        boolean authenticated = false;
        
        System.out.println(username);
        System.out.println(password);
        
        if(testUsername.equals(username)){
            if(testPassword.equals(password)){
                authenticated = true;
            }
            
        } else{
            authenticated = false;
            invalidResponse.setText("Incorrect Username or Password");
        }
        return authenticated;
    }

}
