
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
class JobController {
     @FXML private Stage stage;
    private static JobController jobController;
    
    
    private JobController(Stage theStage){
        stage = theStage;
        this.setUpJobScene();
        stage.show();
    }

    public static JobController getJobController(Stage theExistingStage) {
         if(jobController != null){
            
            jobController.setUpJobScene(); 
            return jobController;
        } else{
            jobController = new JobController(theExistingStage);
        }
        return jobController;
    }
    
    private void setUpJobScene(){
       Parent root;
       Scene scene;
       
       try{
           root = FXMLLoader.load(getClass().getResource("JobView.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Profile");
            stage.setScene(scene);
            stage.show();
       } catch(Exception e){
           e.printStackTrace();
       }
    }
    
}
