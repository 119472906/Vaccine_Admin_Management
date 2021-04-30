package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class UserBookingController implements Initializable {
    
    
    @FXML
    private TextField txtAppID;
    @FXML
    private TextField txtFName;
    @FXML
    private TextField txtLName;
    @FXML
    private TextField txtLoc;
    @FXML
    private TextField txtClinic;
    @FXML
    private TextField txtAppDate;
    @FXML
    private TextField txtStatus;
    
    
    
    @FXML Button btnSave;    
    public void SaveData(){
        
        String AppID = txtAppID.getText();
        System.out.println(AppID);
        
        String FName = txtFName.getText();
        System.out.println(FName);
        
        String LName = txtLName.getText();
        System.out.println(LName);
        
        String Loc = txtLoc.getText();
        System.out.println(Loc);
        
        String Clinic = txtClinic.getText();
        System.out.println(Clinic);
        
        //Remove as couldnt get data type Date to work for me
//        String AppDate = txtAppDate.getText();
//        System.out.println(AppDate);
        
        String Status = txtStatus.getText();
        System.out.println(Status);
        
                     //ULDB = User login Database
    final String AppDB_URL = "jdbc:derby://localhost:1527/UserLoginDB";
 
    try{
        //Connection for database
        Connection userAppConn = DriverManager.getConnection(AppDB_URL, "paddy", "pass");
        System.out.println("Connection to UserLoginDB created.");
        
        //Preparing statement
        PreparedStatement myStat = userAppConn.prepareStatement("insert into paddy.appointments" + "(appointmentid, status, firstname, lastname, clinic, location)" + "values (?, ?, ?, ?, ?, ?)");

        //Arranging values
        myStat.setString(1, AppID);
        myStat.setString(2, Status);
        myStat.setString(3, FName);
        myStat.setString(4, LName);
        myStat.setString(5, Clinic);
        myStat.setString(6, Loc);

        
        //Executing statement
        myStat.executeUpdate();
        System.out.println("Data inserted into Appointments table");
        
        //Close connection
        userAppConn.close();
        System.out.println("Connection Closed");
        
    }catch(Exception ex){
        
            System.out.println("ERROR: " + ex.getMessage());
            
        } finally {
        
        JOptionPane.showMessageDialog(null, "Booking Confirmed!!");
        }         
    }
    
    
    
    
    
    
    
   @FXML private Button btnBookApp;
    public void ToAppPage() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Main_Menu.fxml"));
         Stage window = (Stage) btnBookApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }

    @FXML private Button btnBacktoLogin;
    public void backToLogin() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Main_Menu.fxml"));
         Stage window = (Stage) btnBacktoLogin.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnCancelApp;
    public void ToCancelAppPage() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Cancel.fxml"));
         Stage window = (Stage) btnCancelApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnTimeslots;
    public void ToTimeslotsPage() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_View_App.fxml"));
         Stage window = (Stage) btnTimeslots.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
            
    
}
