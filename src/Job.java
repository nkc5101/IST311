/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hanson
 */
public class Job {

    private String jobTitle = new String();
    private String jobDescription = new String();
    private String company = new String();
    private String datePosted = new String();
    private int salary;
    private String link = new String();

    public Job(String jobTitle,String jobDescription,String company,String datePosted,int salary,String link) {
        this.salary = salary;
        this.company=company;
        this.datePosted=datePosted;
        this.jobDescription=jobDescription;
        this.jobTitle=jobTitle;
        this.link=link;

    }

    
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    
}
