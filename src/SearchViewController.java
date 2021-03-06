/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nate Cox
 */
public class SearchViewController implements Initializable {

    private ArrayList<Job> jobList = new ArrayList<>();

    @FXML
    Button testPersonalityButton;
    @FXML
    Stage theStage;
    @FXML
    TextField searchField;
    

    @FXML
    private TableView<Job> jobTable = new TableView<Job>();

    @FXML
    private TableColumn<Job, String> jobName = new TableColumn("Job Name");
    @FXML
    private TableColumn<Job, String> jobLink = new TableColumn("Link");
    @FXML
    private TableColumn<Job, String> jobSuit = new TableColumn("jobSuit");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setJobSuit();

        if (PersistentDataController.getPersistentDataCntl().getIsEmployer()) {
            testPersonalityButton.setText("Job");
        }

        jobName.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        jobLink.setCellValueFactory(new PropertyValueFactory<>("link"));
        jobSuit.setCellValueFactory(new PropertyValueFactory<>("jobSuit"));
        jobTable.setItems(PersistentDataController.getPersistentDataCntl().getPeristentDataCollection().getJobList().getJobData());

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleSearchFunctionAction() throws IOException {
        // TODO add your handling code here:
        
        String searchTerms = searchField.getText();
        ArrayList<Job> results = PersistentDataController.getPersistentDataCntl().searchJobs(searchTerms);

        if (!PersistentDataController.getPersistentDataCntl().hasResults()) {
            for (int i = 0; i < PersistentDataController.getPersistentDataCntl().searchJobs(searchTerms).size(); i++) {

                ObservableList<Job> theResults = FXCollections.observableList(results);;
                jobName.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
                jobLink.setCellValueFactory(new PropertyValueFactory<>("link"));
                jobSuit.setCellValueFactory(new PropertyValueFactory<>("jobSuit"));
                jobTable.setItems(theResults);
            }
        }
        if (PersistentDataController.getPersistentDataCntl().hasResults()) {
            jobTable.setItems(null);
            jobTable.setPlaceholder(new Label("No Results Found"));

        }

    }

    @FXML
    public Job getSelectedRow() {
        Job tempJob = jobTable.getSelectionModel().getSelectedItem();
        System.out.println(tempJob.getJobTitle());

        //PersistentDataController.getPersistentDataCntl().setSelectedJob(tempJob);
        return tempJob;
    }
    
    public void setJobSuit() {
        
        String someJobPersonality = null;
        String someUserPersonality = null;
        ArrayList<String> jobPer = new ArrayList<>();
       
        for(int i = 0; i<PersistentDataController.getPersistentDataCntl().getPeristentDataCollection().getJobList().getJobData().size(); i++)
        {
            someJobPersonality = PersistentDataController.getPersistentDataCntl().getPeristentDataCollection().getJobList().getJobData().get(i).getJobPersonality();
            someUserPersonality = PersistentDataController.getPersistentDataCntl().getPeristentDataCollection().getLoginUser().getPersonality();
           
            jobPer.add(someJobPersonality);
            
            if(someJobPersonality.equalsIgnoreCase(someUserPersonality))
            {
                PersistentDataController.getPersistentDataCntl().getPeristentDataCollection().getJobList().getJobData().get(i).setJobSuit("Suited");
            }
            else
            {
                PersistentDataController.getPersistentDataCntl().getPeristentDataCollection().getJobList().getJobData().get(i).setJobSuit("Not Suited");
            }
            
            
        }
        
    }
    
    @FXML
    public void handleJobSelection(ActionEvent event) {
        Job someJob = getSelectedRow();
        System.out.println(someJob.getJobTitle());
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Job Info");
        alert.setHeaderText(someJob.getJobTitle());
        alert.setContentText("Description: " + someJob.getJobDescription() + "\nCompany: " + someJob.getCompany()
                + "\nDate Posted: " + someJob.getDatePosted() + "\nPersonality: "  + someJob.getJobPersonality());
        alert.showAndWait();
    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        NavController.getNavController(theStage);
    }
    
    @FXML
    private void handleCareerButtonAction(ActionEvent event)
    {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        CareerProfileController.getCareerProfileController(theStage);
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
    private void handleLogOffButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        LoginController.getLoginController(theStage);

    }

}
