package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserViewAppController implements Initializable {

       
    @FXML private Button btnBookApp;
    public void Movetoappointment () throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Booking.fxml"));
         Stage window = (Stage) btnBookApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnCancelApp;
    public void Movetocancellation () throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Cancel.fxml"));
         Stage window = (Stage) btnCancelApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnBack;
    public void Movetohome () throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Main_Menu.fxml"));
         Stage window = (Stage) btnBack.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
      public void Savecontents(){
        
    }
        
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
