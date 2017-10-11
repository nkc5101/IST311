
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nate Cox
 */
public class LoginView extends JPanel{
    
    JTextField usernameField = new JTextField();
    JTextField passwordField = new JTextField();
    JButton submitButton = new JButton();
    JButton exit = new JButton();
    public LoginView()
    {
        this.passwordField=passwordField;
        this.submitButton=submitButton;
        this.usernameField=usernameField;
        this.exit=exit;
    }
    
    
}
