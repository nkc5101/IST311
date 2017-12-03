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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (PersistentDataController.getPersistentDataCntl().getIsEmployer()) {
            testPersonalityButton.setText("Job");
        }
        // TODO
        jobList.add(new Job("k", "k", "l", "k", 1, "k"));
        //jobTable.setItems((ObservableList) jobList);

        jobName.setCellValueFactory(new PropertyValueFactory<Job, String>("jobTitle"));
        jobLink.setCellValueFactory(new PropertyValueFactory<Job, String>("link"));

        //jobTable.setItems(getJobList());
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void handleSearchFunctionAction() throws IOException {
        // TODO add your handling code here:
        System.out.println("work");

        String name = searchField.getText();
        boolean flag = false;
        for (int i = 0; i < jobList.size(); i++) {

            if (name.equals(jobList.get(i).getJobTitle())) {
                flag = true;
                jobName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJobTitle()));
                jobLink.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLink()));

            }

        }
        if (!flag) {

            jobLink.setCellValueFactory(cellData -> new SimpleStringProperty("Not found"));
            jobName.setCellValueFactory(cellData -> new SimpleStringProperty("Not found"));

        }
    }

    @FXML
    public void getSelectedRow() {
        Job tempJob = jobTable.getSelectionModel().getSelectedItem();
        System.out.println(tempJob.getJobTitle());

        PersistentDataController.getPersistentDataCntl().setSelectedJob(tempJob);
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
    private void handleLogOffButtonAction(ActionEvent event) throws IOException {
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        LoginController.getLoginController(theStage);

    }

}
