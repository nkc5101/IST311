import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
 
public class LoginViewController implements Initializable {
    @FXML private Text actiontarget;
    public boolean switchPanels = false;
    
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        //actiontarget.setText("Sign in button pressed");
        
        switchPanels = true;
        System.out.println("boom");
        
    }
    
    @FXML protected void handleCreateProfileButtonAction(ActionEvent event) throws IOException {
        
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
