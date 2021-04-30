
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

public class ClinicianAppointmentsController implements Initializable {
    
    @FXML Button btnBack;
    @FXML private TextField txtAppID, txtStatus, txtFname, txtLname, txtClinic, txtLocation;
    
    
    

    public void displayAppData() throws Exception {     
        String AppID = txtAppID.getText();
        System.out.println(AppID);
        
    final String ULDB_URL = "jdbc:derby://localhost:1527/UserLoginDB";
        //Create new database
    try{
   Connection Conn = DriverManager.getConnection(ULDB_URL, "paddy", "pass");
   System.out.println("Connection to UserLoginDB created.");
        
   Statement stmt = Conn.createStatement();
        String sqlStatement = "SELECT * from appointments WHERE appointmentid =" + AppID;
       
        
        ResultSet ResSet = stmt.executeQuery(sqlStatement);
        System.out.println("Appointment Found");
        
        ResSet.next();
        txtStatus.setText(ResSet.getString(2));
        txtFname.setText(ResSet.getString(3));
        txtLname.setText(ResSet.getString(4));
        txtClinic.setText(ResSet.getString(5));
        txtLocation.setText(ResSet.getString(6));

        Conn.close();
        System.out.println("Connection closed.");
    } catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
    }}

    public void editAppData() throws Exception {   
        //Coulcn't figure out what code was needed 
    }
    
    public void saveAppData() throws Exception {  
        String AppID = txtAppID.getText();
        System.out.println(AppID);
        
        String Status = txtStatus.getText();
        System.out.println(Status);
        
        String FName = txtFname.getText();
        System.out.println(FName);
        
        String LName = txtLname.getText();
        System.out.println(LName);        
        
        String Clinic = txtClinic.getText();
        System.out.println(Clinic);
        
        String Loc = txtLocation.getText();
        System.out.println(Loc);

                     //ULDB = User login Database
    final String AppDB_URL = "jdbc:derby://localhost:1527/UserLoginDB";
 
    try{
        //Connection for database
        Connection Conn = DriverManager.getConnection(AppDB_URL, "paddy", "pass");
        System.out.println("Connection to UserLoginDB created.");
        
        //Preparing statement
        PreparedStatement myStat = Conn.prepareStatement("insert into paddy.appointments" + "(appointmentid, status, firstname, lastname, clinic, location)" + "values (?, ?, ?, ?, ?, ?)");

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
        Conn.close();
        System.out.println("Connection Closed");
        
    }catch(Exception ex){
        
            System.out.println("ERROR: " + ex.getMessage());
            
        } finally {
        
        JOptionPane.showMessageDialog(null, "Booking Confirmed!!");
        }
    }
    
    public void addAppData() throws Exception { 
        
        txtAppID.setText("");
        txtStatus.setText("");
        txtFname.setText("");
        txtLname.setText("");
        txtClinic.setText(""); 
        txtLocation.setText("");
    }
    
    public void DeleteAppData() throws Exception {     
            
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
    }
    }
        
   
    

    @FXML
        public void backToCLinMenu() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Clinician_Home_Page.fxml"));
        Stage window = (Stage) btnBack.getScene().getWindow();
        window.setScene(new Scene(root));
        }

@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 






}