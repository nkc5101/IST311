/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanson
 */
public class PartTimeJob extends Job {
    private String shift;
    private int hours;
    public PartTimeJob(String jobTitle,String jobDescription,String company,String datePosted,int[] salary,String link,String shift,int hours){
        super(jobTitle,jobDescription,company,datePosted,salary,link);
        this.shift=shift;
        this.hours=hours;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
