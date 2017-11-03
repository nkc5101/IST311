 
import java.awt.Image;
import java.io.File;
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
public class UserProfile extends Profile implements Editable {

    private String name;
    //private String careerChoice;
    private Image profilePicture;
    private ArrayList skills = new ArrayList();
    private String location;
    private ArrayList files = new ArrayList();

    UserProfile(String username, String password, String phoneNumber, String address, String name, String careerChoice) {
        super(username, password, phoneNumber, address);
        this.name = name;
        //this.careerChoice = careerChoice;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getCareerChoice() {
        return careerChoice;
    }

    public void setCareerChoice(String careerChoice) {
        this.careerChoice = careerChoice;
    }*/

    public Image getImage() {
        return profilePicture;
    }

    public void setImage(Image profilePicture) {
        this.profilePicture = profilePicture;
    }

    public ArrayList getSkills() {
        return skills;
    }

    public void setSkills(ArrayList skills) {
        this.skills = skills;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList getFiles() {
        return files;
    }

    public void setFiles(ArrayList files) {
        this.files = files;
    }

    public void addFile(File file) {
        files.add(file);
    }

    @Override
    public void Edit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public File Upload() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
