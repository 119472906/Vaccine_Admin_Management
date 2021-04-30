package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;

public class RegisterController implements Initializable {
    
    @FXML
    private Button btnBack, btnRegister;
    @FXML
    private TextField txtNewEmail, txtUserID;
    @FXML
    private PasswordField txtNewPassword;
    
    @FXML
    private void Register() throws Exception {
        
        String NewID = txtUserID.getText();
        System.out.println(NewID);
        String username = txtNewEmail.getText();
        System.out.println(username);
        String password = txtNewPassword.getText();
        System.out.println(password);
        
         //ULDB = User login Database
    final String ULDB_URL = "jdbc:derby://localhost:1527/UserLoginDB";
 
    try{
        //Connection for database
        Connection userLoginConn = DriverManager.getConnection(ULDB_URL, "paddy", "pass");
        System.out.println("Connection to UserLoginDB created.");
        
        //Preparing statement
        PreparedStatement myStat = userLoginConn.prepareStatement("insert into paddy.users " + "(userid, username, password)" + "values (?, ?, ?)");

        //Arranging values
        myStat.setString(1, NewID);
        myStat.setString(2, username);
        myStat.setString(3, password);
        
        //Executing statement
        myStat.executeUpdate();
        System.out.println("Data inserted into User table");
        
        //Close connection
        userLoginConn.close();
        System.out.println("Connection Closed");
        
    }catch(Exception ex){
        
            System.out.println("ERROR: " + ex.getMessage());
            
        } finally {
        
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/New_User_Questionnaire.fxml"));
        Stage window = (Stage) btnRegister.getScene().getWindow();
        window.setScene(new Scene(root));
        
        }         
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

