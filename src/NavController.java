
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nate Cox
 */
public class NavController {
    SearchView search = new SearchView();
    LoginView login = new LoginView();
    NavView navigation;
    UserProfile testUser = new UserProfile("username", "password", null, null, null, null);
    
    
    NavController(NavView navigation){
        this.navigation = navigation;
        //this.navigation.setContentPane(login);
        this.navigation.addLoginButtonListener(new LoginButtonListener());
        this.navigation.pack();
        this.navigation.setVisible(true);
        
    }
    
    
    public class LoginButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           if(navigation.getUsername().equals(testUser.getUsername())){
               if(navigation.getPassword().equals(testUser.getPassword())){
                  navigation.setHomePage();
               }
           }
        }
        
    }
    
    
}
