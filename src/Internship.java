/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanson
 */
public class Internship extends Job{

    private int length;
    private double desiredGPA;
    public Internship(String jobTitle,String jobDescription,String company,String datePosted,int salary,String link,int length,double desiredGPA){
        super(jobTitle,jobDescription,company,datePosted,salary,link);
        this.desiredGPA=desiredGPA;
        this.length=length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getDesiredGPA() {
        return desiredGPA;
    }

    public void setDesiredGPA(double desiredGPA) {
        this.desiredGPA = desiredGPA;
    }

}
