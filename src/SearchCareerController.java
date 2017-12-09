/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class SearchCareerController implements Initializable {

    @FXML
    Stage theStage;
    @FXML
    TextField searchField;
    

    @FXML
    private TableView<CareerProfile> careerTable = new TableView<CareerProfile>();

    @FXML
    private TableColumn<CareerProfile, String> careerName = new TableColumn("Career");
    @FXML
    private TableColumn<CareerProfile, String> careerDescription = new TableColumn("Description");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        careerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        careerDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        careerTable.setItems(PersistentDataController.getPersistentDataCntl().getPeristentDataCollection().getCareerList().getCareerProfileData());
        
    } 
    
     @FXML
    private void handleSearchFunctionAction() throws IOException {
       
        String searchTerms = searchField.getText();
        ArrayList<CareerProfile> results = PersistentDataController.getPersistentDataCntl().searchCareers(searchTerms);

        if (!PersistentDataController.getPersistentDataCntl().hasCareerResults()) {
            for (int i = 0; i <=PersistentDataController.getPersistentDataCntl().searchJobs(searchTerms).size(); i++) {

                ObservableList<CareerProfile> theResults = FXCollections.observableList(results);;
                careerName.setCellValueFactory(new PropertyValueFactory<>("name"));
                careerDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
                careerTable.setItems(theResults);
            }
        }
        if (PersistentDataController.getPersistentDataCntl().hasCareerResults()) {
            careerTable.setItems(null);
            careerTable.setPlaceholder(new Label("No Results Found"));

        }

    }

    @FXML
    public CareerProfile getSelectedRow() {
        CareerProfile career = careerTable.getSelectionModel().getSelectedItem();
        System.out.println(career.getName());

        //PersistentDataController.getPersistentDataCntl().setSelectedJob(tempJob);
        return career;
    }

    @FXML
    public void handleJobSelection(ActionEvent event) {
       CareerProfile career = careerTable.getSelectionModel().getSelectedItem();
        System.out.println(career.getName());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Career Info");
        alert.setHeaderText(career.getName());
        alert.setContentText("Description: " + career.getDescription() + "\n Required Skill: " + career.getRequiredSkills());
        alert.showAndWait();
    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        NavController.getNavController(theStage);
    }

    @FXML
    protected void handleProfileButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        ProfileController.getProfileController(theStage);
    }

    @FXML
    protected void handleTestPersonalityButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (PersistentDataController.getPersistentDataCntl().getIsEmployer()) {
            JobController.getJobController(theStage);
        } else {
            TestPersonalityController.getTestPersonalityController(theStage);
        }
    }
    
     @FXML
    private void handleSearchButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        SearchController.getSearchController(theStage);
    }

    @FXML
    private void handleLogOffButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        LoginController.getLoginController(theStage);

    }
    
}
