package Controllers;

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
import javafx.stage.Stage;

public class AdditionalFeaturesController implements Initializable {
    
    @FXML private Label featureslabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    public void UserConsentFormButtonPushed(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Views/User_Consent_Form.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void VaccineProgressButtonPushed(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Views/Vaccine_Groups.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
