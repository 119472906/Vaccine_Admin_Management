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
    private Button btnBackRequests;
    
    @FXML
    private void BackToHomepage() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Clinician_Home_Page.fxml"));
        Stage window = (Stage) btnBackRequests.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
