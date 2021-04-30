package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClinicianQuestionnareController implements Initializable {
    
    @FXML private Button btnBacktoLogin, btnDisplay, btnAdd, btnDelete, btnSave;
    
    @FXML
    private TextField txtFName;
    @FXML
    private TextField txtQuestID;
    @FXML
    private TextField txtDate;
    @FXML
    private TextField txtDOB;
    @FXML
    private TextField txtPhysicalDate;
    @FXML
    private TextArea txtMedications;
    @FXML
    private TextField txtGPName;
    @FXML
    private TextField txtPhysicalResult;
    @FXML
    private TextArea txtMedicationAllergies;
    @FXML
    private TextField txtLName;

    public void SaveRecord() throws Exception {
        
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
            
        }
    }
    
    public void DisplayRecord() throws Exception {
   String QuestID = txtQuestID.getText();
        System.out.println(QuestID);
        
    final String ULDB_URL = "jdbc:derby://localhost:1527/UserLoginDB";
        //Create new database
    try{
   Connection Conn = DriverManager.getConnection(ULDB_URL, "paddy", "pass");
   System.out.println("Connection to UserLoginDB created.");
        
   Statement stmt = Conn.createStatement();
        String sqlStatement = "SELECT * from questionnaire WHERE questionnaireid =" + QuestID;
       
        
        ResultSet ResSet = stmt.executeQuery(sqlStatement);
        System.out.println("Questionnaire Found");
        
        ResSet.next();
        txtFName.setText(ResSet.getString(2));
        txtLName.setText(ResSet.getString(3));
        txtDOB.setText(ResSet.getString(4));
        txtDate.setText(ResSet.getString(5));
        txtPhysicalDate.setText(ResSet.getString(6));
        txtPhysicalResult.setText(ResSet.getString(7));
        txtGPName.setText(ResSet.getString(8));
        txtMedications.setText(ResSet.getString(9));
        txtMedicationAllergies.setText(ResSet.getString(10));

        Conn.close();
        System.out.println("Connection closed.");
    } catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
    }
   }
    
    public void AddRecord() throws Exception {
        txtFName.setText("");
        txtLName.setText("");
        txtDOB.setText("");
        txtDate.setText("");
        txtPhysicalDate.setText("");
        txtPhysicalResult.setText("");
        txtGPName.setText("");
        txtMedications.setText("");
        txtMedicationAllergies.setText("");
    }
    
    public void DeleteRecord() throws Exception {
        String QuestID = txtQuestID.getText();
        System.out.println(QuestID);
        
         final String ULDB_URL = "jdbc:derby://localhost:1527/UserLoginDB";
        //Create new database
    try{
   Connection Conn = DriverManager.getConnection(ULDB_URL, "paddy", "pass");
   System.out.println("Connection to UserLoginDB created.");
        
   Statement stmt = Conn.createStatement();
        String sqlStatement = "DELETE FROM questionnaire WHERE questionnaireid =" + QuestID;
        
        stmt.executeUpdate(sqlStatement);
        System.out.println("Appointment Deleted");
        
        Conn.close();
        System.out.println("Connection closed.");
    } catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
    }
    }

    @FXML
        public void BackToLogin() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Clinician_Home_Page.fxml"));
        Stage window = (Stage) btnBacktoLogin.getScene().getWindow();
        window.setScene(new Scene(root));
}
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
