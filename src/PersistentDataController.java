/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nate Cox
 */
public class PersistentDataController {
    
    private static PersistentDataController thePersistentDataCntl;
    private PersistentDataCollection thePersistentDataCollection;
    
    private PersistentDataController(){
        if(thePersistentDataCollection == null){
            thePersistentDataCollection = new PersistentDataCollection();
        }
    }
    
    public static PersistentDataController getPersistentDataCntl(){
        if(thePersistentDataCntl == null){
            thePersistentDataCntl = new PersistentDataController();
        }
        return thePersistentDataCntl;
    }
    
    public PersistentDataCollection getPeristentDataCollection(){
        return thePersistentDataCollection;
    }
    
    public void addPersistentData(UserProfile user){
        thePersistentDataCollection.addUserList(user);
    }
    
    
}
