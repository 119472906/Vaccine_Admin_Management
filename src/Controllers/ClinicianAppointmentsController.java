
package Controllers;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClinicianAppointmentsController implements Initializable {
    
    @FXML private Button btnBacktoHome, btnDisplay;
    @FXML private TextField txtFname, txtLname,txtClinic, txtLocation,txtStatus;
    
    File file = new File("");
    

    public void displayData() throws Exception {
        
        ArrayList<String> Fname = new ArrayList<>();
        ArrayList<String> Lname = new ArrayList<>();
        ArrayList<String> Clinic = new ArrayList<>();
        ArrayList<String> Location = new ArrayList<>();
        ArrayList<String> Status= new ArrayList<>();

        Scanner scan = new Scanner(file);
        
        while(scan.hasNext()){
        System.out.println(scan.nextLine());
        String[] data = scan.nextLine().split(",");
        Fname.add(data[0]);
        Lname.add(data[1]);
        Clinic.add(data[2]);
        Location.add(data[3]);
        Status.add(data[4]);
        System.out.println("List of all elements: " + Fname + Lname+ Clinic + Location + Status);
        
        txtFname.setText(data[0]);
        txtLname.setText(data[1]);
        txtClinic.setText(data[2]);
        txtLocation.setText(data[3]);
        txtStatus.setText(data[4]);
        }
   
    }

    @FXML
        public void backtohome() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Clinician_Home_Page.fxml"));
        Stage window = (Stage) btnBacktoHome.getScene().getWindow();
        window.setScene(new Scene(root));


}

@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 






}