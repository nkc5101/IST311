
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {

    public boolean switchPanels = false;
    @FXML
    private Label invalidLabel;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label invalidResponse;
    @FXML
    private TextField newUsernameField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField reEnterPasswordField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField careerChoiceField;
    Stage theStage;
    @FXML
    private RadioButton userCreation;
    @FXML
    private RadioButton employerCreation;
    @FXML
    private Label careerChoiceLabel;
    @FXML
    private Label careerProfileLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField careerProfileTextField;

    public boolean profileType = true;

    @FXML
    public void handleUserProfileCreation(ActionEvent event) throws IOException {
        Parent createProfileParent = FXMLLoader.load(getClass().getResource("CreateProfile.fxml"));
        Scene createProfileScene = new Scene(createProfileParent, 600, 600);
        Stage createProfileStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        createProfileStage.setScene(createProfileScene);
        createProfileStage.show();

        profileType = true;
    }

    @FXML
    public void handleEmployerProfileCreation(ActionEvent event) {
        careerChoiceLabel.setText("Location:");
        nameLabel.setText("Company Name:");
        nameLabel.setLayoutX(105);
        careerChoiceLabel.setLayoutX(155);
        careerProfileLabel.setVisible(false);
        careerProfileTextField.setVisible(false);

        profileType = false;
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws IOException {

        String username = usernameField.getText();
        String password = passwordField.getText();
        theStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (PersistentDataController.getPersistentDataCntl().authenticate(username, password)) {
            theStage.hide();
            NavController.getNavController(theStage);
        } else {
            passwordField.clear();
            invalidResponse.setText("Incorrect Username or Password");
        }

    }

    @FXML
    public void handleCreateProfileButtonAction(ActionEvent event) throws IOException {

        Parent createProfileParent = FXMLLoader.load(getClass().getResource("CreateProfile.fxml"));
        Scene createProfileScene = new Scene(createProfileParent, 600, 600);
        Stage createProfileStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        createProfileStage.setScene(createProfileScene);
        createProfileStage.show();

    }

    @FXML
    public void handleProfileCreation(ActionEvent event) throws IOException {

        if (profileType == true) {
            String newUsername = newUsernameField.getText();
            String newPassword = newPasswordField.getText();
            String reEnteredPassword = reEnterPasswordField.getText();
            String email = emailField.getText();
            String name = nameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String address = addressField.getText();
            String careerChoice = careerChoiceField.getText();
            String personality = null;

            if (newPassword.equals(reEnteredPassword)) {
                UserProfile newUser = new UserProfile(newUsername, newPassword, email, phoneNumber, address, name, careerChoice, personality);
                PersistentDataController.getPersistentDataCntl().addPersistentData(newUser);
                PersistentDataController.getPersistentDataCntl().writeSerializedData();
                returnToLogin(event);
            }
        }
        if (profileType == false) {
            String newUsername = newUsernameField.getText();
            String newPassword = newPasswordField.getText();
            String reEnteredPassword = reEnterPasswordField.getText();
            String email = emailField.getText();
            String name = nameField.getText();
            String phoneNumber = phoneNumberField.getText();
            String address = addressField.getText();
            String location = careerChoiceField.getText();

            if (newPassword.equals(reEnteredPassword)) {
                EmployerProfile newUser = new EmployerProfile(newUsername, newPassword, phoneNumber, address, name, location);
                PersistentDataController.getPersistentDataCntl().addPersistentEmployerData(newUser);
                PersistentDataController.getPersistentDataCntl().writeSerializedData();
                returnToLogin(event);

            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void returnToLogin(ActionEvent event) throws IOException {

        Parent loginParent = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        Scene loginScene = new Scene(loginParent, 600, 600);
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginStage.setScene(loginScene);
        loginStage.show();
    }

}
