
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
class EmployerList implements Serializable{
    private ArrayList<EmployerProfile> theEmployerList = new ArrayList<>();
    private EmployerProfile loginEmployer;

    EmployerList() {
       theEmployerList = getTestEmployers();
    }
    
    public ArrayList<EmployerProfile> getTestEmployers(){
        EmployerProfile test = new EmployerProfile("PSU", "password", "123-456-7890", "University Park", "Penn State", "PA");
        theEmployerList.add(test);
        
        return theEmployerList;
    }
    
    public void addEmployer(EmployerProfile newEmployer){
        theEmployerList.add(newEmployer);
    }
    
    public boolean Authenticate(String username, String password){
        boolean authenticated = false;
        
        for(int i = 0; i<this.theEmployerList.size(); i++){
            String testUsername = this.theEmployerList.get(i).getUsername();
            String testPassword = this.theEmployerList.get(i).getPassword();

             if(username.equals(testUsername) && password.equals(testPassword)){
            authenticated = true;
            loginEmployer = theEmployerList.get(i);
            
            } 
         }
        return authenticated;
    }
    
    public EmployerProfile getLoginEmployer(){
        return loginEmployer;
    }
    
    public void updateEmployer(String username, String password, String phoneNumber, String address, String companyName, String location){
        loginEmployer.setUsername(username);
        loginEmployer.setPassword(password);
        loginEmployer.setPhoneNumber(phoneNumber);
        loginEmployer.setAddress(address);
        loginEmployer.setCompanyName(companyName);
        loginEmployer.setLocation(location);
    }
}
