import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
 
public class LoginViewController {
    @FXML private Text actiontarget;
    public boolean switchPanels = false;
    
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        //actiontarget.setText("Sign in button pressed");
        
        switchPanels = true;
        System.out.println("boom");
        
    }
    
    public boolean getSwitchPanels()
    {
        return switchPanels;
    }

}
