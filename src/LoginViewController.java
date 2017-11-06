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
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class LoginViewController implements Initializable {
    
    public boolean switchPanels = false;
    
    
    /**
     *
     * @param event
     */
    @FXML protected void handleSubmitButtonAction(ActionEvent event)  throws IOException  {
      
        switchPanels = true;
        System.out.println("Boom");
                        System.out.println("You clicked me!");
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
        Scene search_view_scene = new Scene(search_view_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(search_view_scene);
        app_stage.show();
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

}
