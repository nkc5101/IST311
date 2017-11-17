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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JSlider;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class TestPersonalityViewController implements Initializable {

    @FXML
    JSlider charge;
    @FXML
    JSlider makeFriends;
    @FXML
    JSlider workHard;
    @FXML
    JSlider loveAction;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) throws IOException {
        System.out.println("It works");
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
        Scene search_view_scene = new Scene(search_view_parent, 600, 600);
        Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login_stage.setScene(search_view_scene);
        login_stage.show();
    }

    @FXML
    private void handleSearchButtonAction(ActionEvent event) throws IOException {
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("SearchView.fxml"));
        Scene search_view_scene = new Scene(search_view_parent, 600, 600);
        Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login_stage.setScene(search_view_scene);
        login_stage.show();
    }

    @FXML
    private void handleProfileButtonAction(ActionEvent event) throws IOException {
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("ProfileView.fxml"));
        Scene search_view_scene = new Scene(search_view_parent, 600, 600);
        Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login_stage.setScene(search_view_scene);
        login_stage.show();
    }

    @FXML
    private void handleLogOffButtonAction(ActionEvent event) throws IOException {
        Parent search_view_parent = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene search_view_scene = new Scene(search_view_parent, 600, 600);
        Stage login_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        login_stage.setScene(search_view_scene);
        login_stage.show();
    }

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) throws IOException {
        int c = charge.getValue();
        int m = makeFriends.getValue();
        int w = workHard.getValue();
        int l = loveAction.getValue();

        testPersonality(c, m, w, l);

    }

    @FXML
    private void handleTestPersonalityButtonAction(ActionEvent event) throws IOException {

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

        }
        return result;
    }
}
