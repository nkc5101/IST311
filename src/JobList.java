
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hanson
 */
public class JobList implements Serializable {

    private ArrayList<Job> theListOfJob;

    public JobList() {
        this.theListOfJob = theListOfJob;
    }

    public ArrayList<Job> getTheListOfJob() {
        return theListOfJob;
    }

    public void setTheListOfJob(ArrayList<Job> theListOfJob) {
        this.theListOfJob = theListOfJob;
    }
    
    public ObservableList<Job> getUserData() {
        ObservableList<Job> theListOfUsers;
        List<Job> userList = (List<Job>) theListOfJob;
        theListOfUsers = FXCollections.observableList(userList);
        return theListOfUsers;
    }
    
    public void addJob(Job newJob){
        theListOfJob.add(newJob);
    }
    
    
    
    public void updateJob(String jobTitle,String jobDescription,String company,String datePosted,int salary,String link){
        Job test = new Job(jobTitle, jobDescription, company, datePosted, salary, link);
        int i= 0;
        theListOfJob.set(i,test);
    }
}
