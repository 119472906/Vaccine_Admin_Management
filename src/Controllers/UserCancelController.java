package Controllers;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class UserCancelController implements Initializable {

    @FXML
    private TextField txtAppID;

    
    @FXML private Button btnFindApp;
    public void FindApp(){
            //ULDB = User login Database
    final String ULDB_URL = "jdbc:derby://localhost:1527/UserLoginDB";
        //Create new database
    try{
   Connection Conn = DriverManager.getConnection(ULDB_URL, "paddy", "pass");
   System.out.println("Connection to UserLoginDB created.");
        Statement stmt = Conn.createStatement();
        String sqlStatement = "SELECT appointmentid FROM appointments";
        ResultSet result = stmt.executeQuery(sqlStatement);
        
        while (result.next()) {
      
            if (txtAppID.getText().toLowerCase().equals(result.getString(1))) {
                    JOptionPane.showMessageDialog(null, "Appointment Found, Click cancel button to cancel appointment");
                
                
            }else if(txtAppID.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter you Appointment ID");
            }
        }        
            Conn.close();
            System.out.println("Connection closed.");
        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
    
    
    @FXML private Button btnCancelCurrentApp;
    public void CancelApp(){
        
        String AppID = txtAppID.getText();
        System.out.println(AppID);
        
         final String ULDB_URL = "jdbc:derby://localhost:1527/UserLoginDB";
        //Create new database
    try{
   Connection Conn = DriverManager.getConnection(ULDB_URL, "paddy", "pass");
   System.out.println("Connection to UserLoginDB created.");
        
   Statement stmt = Conn.createStatement();
        String sqlStatement = "DELETE FROM appointments WHERE appointmentid =" + AppID;
        
        stmt.executeUpdate(sqlStatement);
        System.out.println("Appointment Deleted");
        
        Conn.close();
        System.out.println("Connection closed.");
    } catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
    }}

    @FXML private Button btnBookApp;
    public void ToAppPage() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Booking.fxml"));
         Stage window = (Stage) btnBookApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnBacktoLogin;
    public void backToLogin() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Main_Menu.fxml"));
         Stage window = (Stage) btnBacktoLogin.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnTimeslots;
    public void ToTimeslotsPage() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_View_App.fxml"));
         Stage window = (Stage) btnTimeslots.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnCancelApp;
    public void ToCancelAppPage() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_View_App.fxml"));
         Stage window = (Stage) btnCancelApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
}
