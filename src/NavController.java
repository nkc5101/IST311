
import java.awt.Component;
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
    
    
    NavController(NavView navigation){
        this.navigation = navigation;
        this.navigation.setContentPane(login);
        this.navigation.pack();
        this.navigation.setVisible(true);
        
    }
    
    
    
    
    
}
