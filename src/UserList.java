
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
public class UserList {
    
    private ObservableList<UserProfile> listOfUsers;
    private UserProfile loginUser;
    
    
    public UserList(){
        listOfUsers = FXCollections.observableArrayList();
        listOfUsers = getTestUsers();
        UserProfile test = new UserProfile("username", "password", "username@gmail.com", "123-456-7890", "123 Road Way", "Username", "App Developer");
        listOfUsers.add(test);
    }
    
    public ObservableList<UserProfile> getUserData(){
        return listOfUsers;
    }
    
    public ObservableList<UserProfile> getTestUsers(){
        
        return listOfUsers;
    }
    
    public void addUserData(UserProfile user){
        listOfUsers.add(user);
    }
    
    public int size(){
        return listOfUsers.size();
    }
    
    public boolean Authenticate(String username, String password){
        
        boolean authenticated = false;
        
        for(int i = 0; i<this.listOfUsers.size(); i++){
            String testUsername = this.listOfUsers.get(i).getUsername();
            String testPassword = this.listOfUsers.get(i).getPassword();
            System.out.println(testUsername);
            System.out.println(testPassword);
            System.out.println(size());
             if(username.equals(testUsername) && password.equals(testPassword)){
            authenticated = true;
            loginUser = listOfUsers.get(i);
            
            } 
         }
        return authenticated;
    }
    
    public UserProfile getLoginUser(){
        return loginUser;
    }
    
    public void updateUser(String username, String password, String address, String phoneNumber, String name, String careerProfile, String email){
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        loginUser.setAddress(address);
        loginUser.setPhoneNumber(phoneNumber);
        loginUser.setName(name);
        loginUser.setCareerProfile(careerProfile);
        loginUser.setEmail(email);
    }
    
    public void addPersonality(String personality){
        loginUser.setPersonality(personality);
    }
    
}
