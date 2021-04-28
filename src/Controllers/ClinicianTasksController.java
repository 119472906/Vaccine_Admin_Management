package Controllers;

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

public class ClinicianTasksController implements Initializable {
    
    @FXML 
    private Button btnBackTasks;
    
    @FXML
    private void backToMain(ActionEvent event) throws Exception {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Views/Clinician_Home_Page.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
     @FXML 
    private Button btnConfirmTasks; 
     
     @FXML 
     private void ConfirmTasks() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage window = (Stage) btnConfirmTasks.getScene().getWindow();
        window.setScene(new Scene(root)); 
     }
    
    /* @FXML
     class CheckboxAction extends AbstractAction {
    public CheckboxAction(String text) {
        super(text);
    }*/
 
    /*public void actionPerformed(ActionEvent e) {
        JCheckBox cbConsentTasks = (JCheckBox) e.getSource();
        if (cbConsentTasks.isSelected()) {
            System.out.println("Confirmed");
        } else {
            System.out.println("Please Confirm");
        }
    }*/
     
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}

     
     
      
    

