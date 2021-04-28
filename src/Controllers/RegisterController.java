package Controllers;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController implements Initializable {
    
    @FXML
    private Button btnBack, btnRegister;
    @FXML
    private TextField txtNewEmail;
    @FXML
    private PasswordField txtNewPassword;
    
   // int NewUserCounter = 1;
    
    
    @FXML
    private void Register() throws Exception {
        //NewUserCounter++;
        String email = txtNewEmail.getText();
        String password = txtNewPassword.getText();
        //Add incrementing number 
        String outputToNewUsers = email + ", " + password;
        System.out.println(outputToNewUsers);
        
        try{
            //new 10/04/2021
            Files.write(Paths.get("/Text_Files/NewUsers.txt"), 
                    (outputToNewUsers + System.lineSeparator()).getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException ex){
            ex.printStackTrace();
            System.out.println("Error writing to file " + ex.toString());
        }
        
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/New_User_Questionnaire.fxml"));
        Stage window = (Stage) btnRegister.getScene().getWindow();
        window.setScene(new Scene(root));
        
    }

    //Back button from register page to login page
    @FXML
    public void backTsignin() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Sign_In_Page.fxml"));
        Stage window = (Stage) btnBack.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

//"C:\\Users\\pmcca\\Desktop\\Year 2\\Semester 2\\IS2209 - Object Oriented Application Design and Development\\Code\\Login_Page_2\\src\\Text_Files\\NewUsers.txt"


  