package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserViewAppController implements Initializable {
    
    @FXML TextField txtAppID;
    
    @FXML
    private TextField txtClinic;

    @FXML
    private TextField txtLoc;

    @FXML
    private TextField txtStatus;
    
    @FXML private Button btnViewApps;
    public void DisplayApps() throws Exception{
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
        txtClinic.setText(ResSet.getString(5));
        txtLoc.setText(ResSet.getString(6));

        Conn.close();
        System.out.println("Connection closed.");
    } catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
    }
    }
    
    
       
    @FXML private Button btnBookApp;
    public void ToAppPage() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Booking.fxml"));
         Stage window = (Stage) btnBookApp.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    @FXML private Button btnCancelApp;
    public void ToCancelAppPage() throws Exception{
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Cancel.fxml"));
         Stage window = (Stage) btnCancelApp.getScene().getWindow();
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
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/User_Main_Menu.fxml"));
         Stage window = (Stage) btnTimeslots.getScene().getWindow();
         window.setScene(new Scene (root));
    }
    
    
        
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
