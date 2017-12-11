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

    @FXML
    Slider sliderOne;
    @FXML
    Slider sliderTwo;
    @FXML
    Slider sliderThree;
    @FXML
    Slider sliderFour;
    @FXML
    Slider sliderFive;
    @FXML
    Label resultLabel;
    @FXML
    Stage theStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        NavController.getNavController(theStage);
    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        SearchController.getSearchController(theStage);
    }

    @FXML
    private void handleProfileButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        ProfileController.getProfileController(theStage);
    }

    @FXML
    private void handleLogOffButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        LoginController.getLoginController(theStage);

    }

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) throws IOException {
        int c = (int) sliderOne.getValue();
        int m = (int) sliderTwo.getValue();
        int j = (int) sliderThree.getValue();
        int v = (int) sliderFour.getValue();
        int t = (int) sliderFive.getValue();

        String personality = testPersonality(c, m, j, v, t);

        PersistentDataController.getPersistentDataCntl().addPersonality(personality);

        resultLabel.setText("Your result is: " + personality);

    }

    @FXML
    private void handleTestPersonalityButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        TestPersonalityController.getTestPersonalityController(theStage);
    }

    @FXML
    private void handleCareerButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        CareerProfileController.getCareerProfileController(theStage);
    }

    private String testPersonality(int c, int m, int w, int l, int t) {
        String result;
        if (c >= 3 && m >= 4 && w >= 3 && l == 5 && t > 2) {
            result = "Communicator";
            System.out.println(result);
        } else if (c >= 0 && m > 0 && w >= 0 && l >= 3 && t >= 2 && t < 5) {
            result = "Hard Working";
            System.out.println(result);
        } else if (c >= 4 && m > 0 && w == 0 && l >= 4 && t == 5) {
            result = "Team Leader";
            System.out.println(result);
        } else if (c == 5 && m > 3 && w > 3 && l >= 4 && t >= 2) {
            result = "Good Teammates";
            System.out.println(result);
        } else if (c <= 2 && m >= 0 && w > 0 && l <= 3 && t == 0) {
            result = "Invidual Worker";
            System.out.println(result);

        } else {
            result = "Learner";
            System.out.println(c + " " + m + " " + w + " " + l + " " + t);
        }
        return result;
    }
}
