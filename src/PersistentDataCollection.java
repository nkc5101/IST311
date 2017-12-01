
import java.io.Serializable;

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
    
    private UserList theUserList;
    // All other persistent data will go below here
    
    public PersistentDataCollection(){
        if(theUserList == null){
            theUserList = new UserList();
        }
    }
    
    public UserList getuserList(){
        return theUserList;
    }
    
    public void addUserData(UserProfile user){
        theUserList.addUserData(user);
    }
    
    public boolean authenticate(String username, String password){
         return theUserList.Authenticate(username, password);
    }
    
    public UserProfile getLoginUser(){
        return theUserList.getLoginUser();
    }
    
    public void updateUser(String username, String password, String address, String phoneNumber, String name, String careerProfile, String email){
        theUserList.updateUser(username, password, address, phoneNumber, name, careerProfile, email);
    }
    
    public void addPersonality(String personality){
        theUserList.addPersonality(personality);
    }
    
}
