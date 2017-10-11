
import javax.swing.JPanel;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nate Cox
 */
public class NavView extends JPanel{
    
    JButton homeButton = new JButton();
    JButton profileButton = new JButton();
    JButton searchButton = new JButton();
    JButton logoutButton = new JButton();
    
    NavView(){
        this.homeButton=homeButton;
        this.logoutButton=logoutButton;
        this.profileButton=profileButton;
        this.searchButton=searchButton;
    }
    
}
