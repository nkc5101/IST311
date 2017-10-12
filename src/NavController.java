
import javax.swing.JFrame;

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
        navigation.getContentPane().add(login);
        navigation.pack();
        navigation.setVisible(true);
        
    }
    
    
}
