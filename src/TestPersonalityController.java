
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
 * @author hanson
 */
public class TestPersonalityController {

    @FXML
    private Stage stage;
    private static TestPersonalityController testPersonalityController;

    private TestPersonalityController(Stage theStage) {
        stage = theStage;
        this.setUpPersonalityControllerScene();
        stage.show();
    }

    public static TestPersonalityController getTestPersonalityController(Stage theExistingStage) {
        if (testPersonalityController != null) {
            testPersonalityController.setUpPersonalityControllerScene();
            return testPersonalityController;
        } else {
            testPersonalityController = new TestPersonalityController(theExistingStage);
        }
        return testPersonalityController;
    }

    private void setUpPersonalityControllerScene() {
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("TestPersonalityView.fxml"));
            scene = new Scene(root, 600, 600);
            stage.setTitle("Test Personality");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
