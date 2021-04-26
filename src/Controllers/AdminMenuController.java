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
import javafx.stage.Stage;

public class AdminMenuController implements Initializable {

    @FXML
    private Button btnBack, btnAddFea;
    
    @FXML
    public void VacInfo(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Views/Vaccine_Info.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);       
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    public void BackToLogin() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Sign_In_Page.fxml"));
        Stage window = (Stage) btnBack.getScene().getWindow();
        window.setScene(new Scene(root)); 
    }

    @FXML
    public void VacCentres(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Views/Vaccination_Centres.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    public void RequestVac(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Views/Request_Vaccine.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    public void AddFeat(ActionEvent event) throws IOException{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Additional_Features.fxml"));
        Stage window = (Stage) btnAddFea.getScene().getWindow();
        window.setScene(new Scene(root)); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
}
