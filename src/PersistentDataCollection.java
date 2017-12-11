
import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nate Cox
 */
public class PersistentDataCollection implements Serializable {

    private static final long serialVersionUID = 652968509;

    private UserList theUserList;
    private JobList theJobList;
    private EmployerList theEmployerList;
    private UserProfile loginUser;
    private EmployerProfile loginEmployer;
    private boolean employerLogin = false;
    private boolean hasResults = false;
    private CareerProfileList theCareerList;
    private boolean hasCareerResults = false;
    // All other persistent data will go below here

    public PersistentDataCollection() {
        if (theUserList == null) {
            theUserList = new UserList();
        }
        if (theJobList == null) {
            theJobList = new JobList();
        }

        if (theEmployerList == null) {
            theEmployerList = new EmployerList();
        }

        if (theCareerList == null) {
            theCareerList = new CareerProfileList();
        }
    }

    public UserList getuserList() {
        return theUserList;
    }

    public void addUserData(UserProfile user) {
        theUserList.addUserData(user);
    }

    public boolean authenticate(String username, String password) {
        boolean authenticate = false;
        if (theUserList.Authenticate(username, password)) {
            authenticate = true;
            employerLogin = false;
            loginUser = theUserList.getLoginUser();
        }
        if (theEmployerList.Authenticate(username, password)) {
            authenticate = true;
            employerLogin = true;
            loginEmployer = theEmployerList.getLoginEmployer();
        }

        return authenticate;
    }

    public UserProfile getLoginUser() {
        return loginUser;
    }

    public EmployerProfile getLoginEmployer() {
        return loginEmployer;
    }

    public boolean getIsEmployer() {
        return employerLogin;
    }

    public void updateUser(String username, String password, String address, String phoneNumber, String name, String careerProfile, String email) {
        theUserList.updateUser(username, password, address, phoneNumber, name, careerProfile, email);
    }

    public void addPersonality(String personality) {
        theUserList.addPersonality(personality);
    }

    public JobList getJobList() {
        return theJobList;
    }

    public void addJob(Job newJob) {
        theJobList.addJob(newJob);
    }

    public void updateJob(String jobTitle, String jobDescription, String company, String datePosted, int salary, String link, String jobPersonality) {
        theJobList.updateJob(jobTitle, jobDescription, company, datePosted, salary, link, jobPersonality);
    }

    public void addEmployer(EmployerProfile newEmployer) {
        theEmployerList.addEmployer(newEmployer);

    }

    public void updateEmployer(String username, String password, String phoneNumber, String address, String companyName, String location) {
        theEmployerList.updateEmployer(username, password, phoneNumber, address, companyName, location);
    }

    public boolean hasResults() {

        return hasResults;
    }

    public ArrayList<Job> searchJobs(String searchTerms) {
        hasResults = false;
        ArrayList<Job> results = new ArrayList<>();
        results = theJobList.search(searchTerms);
        hasResults = results.isEmpty();
        return results;
    }

    public CareerProfileList getCareerList() {
        return theCareerList;
    }

    public void addCareer(CareerProfile newCareer) {
        theCareerList.addCareer(newCareer);
    }

    public ArrayList<CareerProfile> searchCareers(String searchTerms) {
        hasCareerResults = false;
        ArrayList<CareerProfile> results = new ArrayList<>();
        results = theCareerList.search(searchTerms);
        hasCareerResults = results.isEmpty();
        return results;
    }

    public boolean hasCareerResults() {
        return hasCareerResults;
    }
}
