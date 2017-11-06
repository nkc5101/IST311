import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
 
public class LoginViewController implements Initializable {
    
    public boolean switchPanels = false;
    
    
    /**
     *
     * @param event
     */
    @FXML protected void handleSubmitButtonAction(ActionEvent event){
      
        switchPanels = true;
        System.out.println("Boom");
    }
    
    
    
    @FXML public void handleCreateProfileButtonAction(ActionEvent event) {
        
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

}
