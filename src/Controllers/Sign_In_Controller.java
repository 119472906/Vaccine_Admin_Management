package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Sign_In_Controller implements Initializable {
    
    @FXML
    private Button btnSignIn, btnBack, btnSignUp, btnRegister, btnFUP, btnFAP, btnFCP;
    @FXML
    private Label lblError;
    @FXML
    private Hyperlink hypForgotPass;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private void userLogin() throws Exception {
        if(txtEmail.getText().equals("user") && txtPassword.getText().equals("123")) {
            
            lblError.setText("Success!");
            
            Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Main_Menu.fxml"));
            Stage window = (Stage) btnSignIn.getScene().getWindow();
            window.setScene(new Scene(root));  
        }
        
        else if (txtEmail.getText().equals("admin") && txtPassword.getText().equals("123")) {
         
            lblError.setText("Success!");
            
            Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Admin_Menu.fxml"));
            Stage window = (Stage) btnSignIn.getScene().getWindow();
            window.setScene(new Scene(root));  
        }
        
        else if (txtEmail.getText().equals("clinician") && txtPassword.getText().equals("123")) {
            
            lblError.setText("Success!");
            
            Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Clinician_Home_Page.fxml"));
            Stage window = (Stage) btnSignIn.getScene().getWindow();
            window.setScene(new Scene(root));  
        }

        else if(txtEmail.getText().isEmpty() && txtPassword.getText().isEmpty()) {
            lblError.setText("Please enter your data.");
        }


        else {
            lblError.setText("Wrong username or password!");
        }
    }
    
    public void goBack() throws Exception {
            Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Sign_In_Page.fxml"));
            Stage window = (Stage) btnBack.getScene().getWindow();
            window.setScene(new Scene(root));
    }
    
    @FXML
    public void signup() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Sign_Up_Page.fxml"));
        Stage window = (Stage) btnSignUp.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML
    public void forgotpass() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource(".fxml"));
        Stage window = (Stage) hypForgotPass.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML
    public void backFUP() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Sign_In_Page.fxml"));
        Stage window = (Stage) btnFUP.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML
    public void backFAP() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Sign_In_Page.fxml"));
        Stage window = (Stage) btnFAP.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML
    public void backFCP() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Sign_In_Page.fxml"));
        Stage window = (Stage) btnFCP.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
