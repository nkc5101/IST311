
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
 * @author Nate Cox
 */
public class CareerProfileList implements Serializable{
     private ArrayList<CareerProfile> theListOfCareers = new ArrayList<>();

    public CareerProfileList() {
        ArrayList<String> requiredSkills;
         requiredSkills = new ArrayList<>();
         requiredSkills.add("Wireshark");
        CareerProfile newCareer = new CareerProfile("Info", "Protect Information", requiredSkills);
        theListOfCareers.add(newCareer);
    }

    public ArrayList<CareerProfile> getTheListOfCareers() {
        return theListOfCareers;
    }
          

    public void setTheListOfJob(ArrayList<CareerProfile> theListOfCareers) {
        this.theListOfCareers = theListOfCareers;
    }

    public ObservableList<CareerProfile> getCareerProfileData() {
        ObservableList<CareerProfile> theListOfCareers;
        List<CareerProfile> careerList = (List<CareerProfile>) this.theListOfCareers;
        theListOfCareers = FXCollections.observableList(careerList);
        return theListOfCareers;
    }

    public void addCareer(CareerProfile newCareer) {
        theListOfCareers.add(newCareer);
    }

    

    public ArrayList<CareerProfile> search(String searchTerms) {

        ArrayList<CareerProfile> results = new ArrayList<>();

        for (int i = 0; i < theListOfCareers.size(); i++) {
            if (theListOfCareers.get(i).getName().contains(searchTerms)) {
                results.add(theListOfCareers.get(i));
            }
            if (theListOfCareers.get(i).getDescription().contains(searchTerms)) {
                results.add(theListOfCareers.get(i));
            }
            if (theListOfCareers.get(i).getRequiredSkills().contains(searchTerms)) {
                results.add(theListOfCareers.get(i));
            }

        }
        return results;
    }
}
