package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserMainMenuController implements Initializable {
    
      
    @FXML private Button btnBookApp;
    public void MoveToAppointment() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Booking.fxml"));
         Stage window = (Stage) btnBookApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnCancelApp; 
    public void MoveToCancellation() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Cancel.fxml"));
         Stage window = (Stage) btnCancelApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnTimeslots;    
    public void ToTimeslotsPage() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_View_App.fxml"));
         Stage window = (Stage) btnTimeslots.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnBacktoLogin;    
    public void backToLogin() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Sign_In_Page.fxml"));
         Stage window = (Stage) btnBacktoLogin.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     
    } 
    
}
