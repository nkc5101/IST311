
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
public class CareerProfileController {
   @FXML
    private Stage stage;
    private static CareerProfileController careerProfileController;

    private CareerProfileController(Stage theStage) {
        stage = theStage;
        if(PersistentDataController.getPersistentDataCntl().getIsEmployer()){
            this.setUpCreateCareerProfileScene();
        } else{
            this.setUpCareerProfileScene();
        }
        stage.show();
    }

    public static CareerProfileController getCareerProfileController(Stage theExistingStage) {
        if (careerProfileController != null && PersistentDataController.getPersistentDataCntl().getIsEmployer()) {

            careerProfileController.setUpCreateCareerProfileScene();
            return careerProfileController;
        } else  if (careerProfileController != null && !PersistentDataController.getPersistentDataCntl().getIsEmployer()){
            careerProfileController.setUpCareerProfileScene();
            return careerProfileController;
        } else{
            careerProfileController = new CareerProfileController(theExistingStage);
        }
        return careerProfileController;
    }

    private void setUpCareerProfileScene() {
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("SearchCareer.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Career Profile");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void setUpCreateCareerProfileScene(){
        Parent root;
        Scene scene;
        
        try{
            root = FXMLLoader.load(getClass().getResource("CreateCareerProfile.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Career Profile");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
