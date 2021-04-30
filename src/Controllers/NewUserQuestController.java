package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

public class NewUserQuestController implements Initializable{
    
    @FXML TextField txtFName, txtLName, txtDate, txtDOB, txtQuestID, txtGPName, txtPhysicalDate, txtPhysicalResult;
    @FXML TextArea txtMedications, txtMedicationAllergies;
    
    @FXML private Button btnBacktoLogin;
    public void BackToLogin() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Sign_Up_Page.fxml"));
        Stage window = (Stage) btnBacktoLogin.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
    @FXML private Button btnSave;
    public void SaveRecord(ActionEvent event) throws Exception {
        
        String QuestID = txtQuestID.getText();
        System.out.println(QuestID);
        
        String FName = txtFName.getText();
        System.out.println(FName);
        
        String LName = txtLName.getText();
        System.out.println(LName);
        
        String DOB = txtDOB.getText();
        System.out.println(DOB);
        
        String Date = txtDate.getText();
        System.out.println(Date);
        
        String PhyDate = txtPhysicalDate.getText();
        System.out.println(PhyDate);
        
        String PhyResult = txtPhysicalResult.getText();
        System.out.println(PhyResult);
        
        String GPName = txtGPName.getText();
        System.out.println(GPName);
        
        String Meds = txtMedications.getText();
        System.out.println(Meds);
        
        String MedAllergies = txtMedicationAllergies.getText();
        System.out.println(MedAllergies);
        
             //ULDB = User login Database
    final String QuestDB_URL = "jdbc:derby://localhost:1527/UserLoginDB";
 
    try{
        //Connection for database
        Connection userQeustConn = DriverManager.getConnection(QuestDB_URL, "paddy", "pass");
        System.out.println("Connection to UserLoginDB created.");
        
        //Preparing statement
        PreparedStatement myStat = userQeustConn.prepareStatement("insert into paddy.questionnaire " + "(questionnaireid, firstname, lastname, DOB, Date, lastphysical, physicalresult, GP, currentmeds, allergies)" + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        //Arranging values
        myStat.setString(1, QuestID);
        myStat.setString(2, FName);
        myStat.setString(3, LName);
        myStat.setString(4, DOB);
        myStat.setString(5, Date);
        myStat.setString(6, PhyDate);
        myStat.setString(7, PhyResult);
        myStat.setString(8, GPName);
        myStat.setString(9, Meds);
        myStat.setString(10, MedAllergies);
        
        //Executing statement
        myStat.executeUpdate();
        System.out.println("Data inserted into Questionnaire table");
        
        //Close connection
        userQeustConn.close();
        System.out.println("Connection Closed");
        
    }catch(Exception ex){
        
            System.out.println("ERROR: " + ex.getMessage());
            
        } finally {
        
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/Views/User_Main_Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();      
        window.setScene(tableViewScene);
        window.show();
        
        }         
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
