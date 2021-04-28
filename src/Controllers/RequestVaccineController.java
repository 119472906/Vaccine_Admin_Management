package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RequestVaccineController implements Initializable{
    
    @FXML private Label individualOrderLabel, massOrderLabel;
    @FXML private TextField fullNameTextField, AddressTextField,CountyTextField;
    @FXML private ChoiceBox massOrderChoiceBox;
    @FXML private Button btnBack;
    
    public void sendRequestButtonPushed() throws Exception{
        String request = "Vaccine Ordered For: ";
        
        request += fullNameTextField.getText() + "," + " ";
        request += AddressTextField.getText() + "," + " ";
        request += CountyTextField.getText() + " ";
        
        this.individualOrderLabel.setText(request);
    }
    
    public void BackToMenu() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Admin_Menu.fxml"));
        Stage window = (Stage) btnBack.getScene().getWindow();
        window.setScene(new Scene(root)); 
    }
    
    public void massRequestButtonPushed() throws Exception{
        String order = "Vaccines Ordered To: ";
        
        order += massOrderChoiceBox.getValue().toString();
                
        massOrderLabel.setText(order);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     individualOrderLabel.setText("");
       
        massOrderChoiceBox.getItems().add("Cork, City Hall, Cork City Hall, Anglesea St. Centre, Cork City");
        massOrderChoiceBox.getItems().add("Cork, Páirc Uí Chaoimh, The Marina, Cork City");
        massOrderChoiceBox.getItems().add("Dublin, Aviva Stadium, Lansdowne Road, Ballsbridge, Dublin");
        massOrderChoiceBox.getItems().add("Dublin, Helix Theatre DCU, DCU Santry");
        massOrderChoiceBox.getItems().add("Galway, Galway Racecourse, Galway Racecourse, Ballybrit, Galway");
        massOrderChoiceBox.getItems().add("Kildare, Punchestown Racecourse, Punchestown, Naas, Co Kildare");
        massOrderChoiceBox.getItems().add("Limerick, Radisson Hotel, Ennis Road, Limerick");
        massOrderChoiceBox.getItems().add("Sligo, Sligo IT Sports Arena, Sligo IT, Ash Ln, Bellanode, Co Sligo");
        massOrderChoiceBox.getItems().add("Wexford, Riverside Hotel Enniscorthy, The Promenade, Enniscorthy, Co Wexford");
    } 
}
