package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserCancelController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
            
    public void Savecontents(){  
    }
    
    @FXML private Button btnBookApp;
    public void Movetoappointment() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Booking.fxml"));
         Stage window = (Stage) btnBookApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnBack2;
    public void Movetohome() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Main_Menu.fxml"));
         Stage window = (Stage) btnBack2.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnView;
    public void Movetoview() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_View_App.fxml"));
         Stage window = (Stage) btnView.getScene().getWindow();
         window.setScene(new Scene (root));
    }
}
