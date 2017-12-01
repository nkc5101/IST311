
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nate Cox
 */
class ProfileController {
    
    @FXML private Stage stage;
    private static ProfileController profileController;
    
    
    private ProfileController(Stage theStage){
        stage = theStage;
        this.setUpProfileScene();
        stage.show();
    }

    public static ProfileController getProfileController(Stage theExistingStage) {
         if(profileController != null){
            return profileController;
        } else{
            profileController = new ProfileController(theExistingStage);
        }
        return profileController;
    }
    
    private void setUpProfileScene(){
       Parent root;
       Scene scene;
       
       try{
           root = FXMLLoader.load(getClass().getResource("ProfileView.fxml"));
            scene = new Scene(root);
            stage.setTitle("Profile");
            stage.setScene(scene);
            stage.show();
       } catch(Exception e){
           e.printStackTrace();
       }
    }
    
}
