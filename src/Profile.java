
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
public abstract class Profile implements Editable, Serializable {
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private String comments;
    
    Profile(String username, String password, String phoneNumber, String address){
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
       
        
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
   public void setPassword(String password){
       this.password = password;
   }
   
   public String getPhonNumber(){
       return phoneNumber;
   }
   
   public void setPhoneNumber(String phoneNumber){
       this.phoneNumber = phoneNumber;
   }
   
   public String getAddress(){
       return address;
   }
   
   public void setAddress(String address){
       this.address = address;
   }
   
   public String getComments(){
       return comments;
   }
   
   public void setComments(String comments){
       this.comments = comments;
   }
}
   
