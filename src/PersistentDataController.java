
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    private final String savedDataPath = "";
    private final String fileName = "jobData.ser";

    private PersistentDataController() {
        readSerializedData();
        if (thePersistentDataCollection == null) {
            thePersistentDataCollection = new PersistentDataCollection();
        }
        writeSerializedData();
        readSerializedData();

    }

    public void readSerializedData() {
        FileInputStream fis = null;
        ObjectInputStream ins = null;
        String file = savedDataPath + fileName;
        try {
            fis = new FileInputStream(file);
            ins = new ObjectInputStream(fis);
            thePersistentDataCollection = (PersistentDataCollection) ins.readObject();
            ins.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void writeSerializedData() {
        FileOutputStream fos = null;
        ObjectOutputStream outs = null;
        String file = savedDataPath + fileName;
        try {
            fos = new FileOutputStream(file);
            outs = new ObjectOutputStream(fos);
            outs.writeObject(thePersistentDataCollection);
            outs.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    

    public static PersistentDataController getPersistentDataCntl() {
        if (thePersistentDataCntl == null) {
            thePersistentDataCntl = new PersistentDataController();
        }
        return thePersistentDataCntl;
    }

    public PersistentDataCollection getPeristentDataCollection() {
        return thePersistentDataCollection;
    }

    public void addPersistentData(UserProfile user) {
        thePersistentDataCollection.addUserList(user);
    }

    public boolean authenticate(String username, String password) {
        return thePersistentDataCollection.authenticate(username, password);
    }

    public UserProfile getUser() {
        return thePersistentDataCollection.getLoginUser();
    }

    public void updateUser(String username, String password, String address, String phoneNumber, String name, String careerProfile, String email) {
        thePersistentDataCollection.updateUser(username, password, address, phoneNumber, name, careerProfile, email);
    }

    public void addPersonality(String personality) {
        thePersistentDataCollection.addPersonality(personality);
    }

}
