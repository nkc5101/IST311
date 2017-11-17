/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nate Cox
 */
public class PersistentDataCollection {
    
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
    
    public void addUserList(UserProfile user){
        theUserList.addUserData(user);
    }
    
    public boolean authenticate(String username, String password){
         return theUserList.Authenticate(username, password);
    }
    
}
