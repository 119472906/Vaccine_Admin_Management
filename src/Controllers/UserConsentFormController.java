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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserConsentFormController implements Initializable {
    
    private Label formLabel;
    private TextField nameTextField;
    private DatePicker dobDatePicker;
    private TextField allergyHistoryTextField;
    private TextField contactNumberTextField;
    private Label consentLabel;
    private Button consentButton;
    
    public void consentButtonPushed()
    {
        String consent = "Consent to Vaccinate Accepted For: ";
        
        consent += nameTextField.getText();
        
        this.consentLabel.setText(consent);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    public void ReturnToMenuButtonPushed(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Views/Admin_Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
}
