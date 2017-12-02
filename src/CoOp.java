/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanson
 */
public class CoOp extends Job{
       private String semester;
    private String desiredGPA;
    private String desiredExperience;
    public CoOp(String jobTitle,String jobDescription,String company,String datePosted,int salary,String link,String semester,String desiredGPA,String desiredExperience){
        super(jobTitle,jobDescription,company,datePosted,salary,link);
        this.semester=semester;
        this.desiredGPA=desiredGPA;
        this.desiredExperience=desiredExperience;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDesiredGPA() {
        return desiredGPA;
    }

    public void setDesiredGPA(String desiredGPA) {
        this.desiredGPA = desiredGPA;
    }

    public String getDesiredExperience() {
        return desiredExperience;
    }

    public void setDesiredExperience(String desiredExperience) {
        this.desiredExperience = desiredExperience;
    }
}

