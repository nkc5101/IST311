/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class TestPersonalityViewController implements Initializable {

    @FXML Slider sliderOne;
    @FXML Slider sliderTwo;
    @FXML Slider sliderThree;
    @FXML Slider sliderFour;
    @FXML Label resultLabel;
    @FXML Stage theStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) throws IOException {
         theStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
                
        NavController.getNavController(theStage);
    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) throws IOException {
       theStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
                
        SearchController.getSearchController(theStage);
    }

    @FXML
    private void handleProfileButtonAction(ActionEvent event) throws IOException {
       theStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
                
        ProfileController.getProfileController(theStage);
    }

    @FXML
    private void handleLogOffButtonAction(ActionEvent event) throws IOException {
       theStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
                
                LoginController.getLoginController(theStage);

    }

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) throws IOException {
        int c = (int) sliderOne.getValue();
        int m = (int) sliderTwo.getValue();
        int w = (int) sliderThree.getValue();
        int l = (int) sliderFour.getValue();

        String personality = testPersonality(c, m, w, l);
        
        PersistentDataController.getPersistentDataCntl().addPersonality(personality);
        
        resultLabel.setText("Your result is: " + personality);

    }

    @FXML
    private void handleTestPersonalityButtonAction(ActionEvent event) throws IOException {
theStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();
                
        TestPersonalityController.getTestPersonalityController(theStage);
    }

    private String testPersonality(int c, int m, int w, int l) {
        String result = null;
        if (c == 5 && m == 4 && w == 4 && l == 5) {
            result = "coummicator";
            System.out.println(result);
        } else if (c == 4 && m == 3 && w == 4 && l == 3) {
            result = "hard working";
            System.out.println(result);
        } else if (c == 4 && m == 5 && w == 2 && l == 1) {
            result = "team leader";
            System.out.println(result);
        } else if (c == 2 && m == 3 && w == 2 && l == 5) {
            result = "good teammates";
            System.out.println(result);

        }else
        {
            result = "not available";
            System.out.println(c + " " + m + " " + w + " " + l);
        }
        return result;
    }
}
