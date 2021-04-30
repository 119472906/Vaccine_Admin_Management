package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ClinicianVacRequestsController implements Initializable {
    
  @FXML 
    private Button btnBack;
    
    @FXML
    private void BackToCLinMenu() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Clinician_Home_Page.fxml"));
        Stage window = (Stage) btnBack.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    public void displayAppData() throws Exception {       
    }
    
    public void backToCLinMenu() throws Exception {       
    }
    
    public void editAppData() throws Exception {      
    }
    
    public void saveAppData() throws Exception {       
    }
    
    public void addAppData() throws Exception {       
    }
    
    public void DeleteAppData() throws Exception {     
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
