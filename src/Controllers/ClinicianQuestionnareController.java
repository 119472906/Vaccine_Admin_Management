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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ClinicianQuestionnareController implements Initializable {
    
    @FXML private Button btnSave, btnBacktoHome;
    @FXML private TextField txtName, txtDate, txtDOB, txtGH, txtPE, txtResult, txtPhy ; 
    @FXML private TextArea txtMedications,txtAllergies;
    
    File file = new File("");
    

    public void displayData() throws Exception {
        
        ArrayList<String> Pname = new ArrayList<>();
        ArrayList<String> Date = new ArrayList<>();
        ArrayList<String> Result = new ArrayList<>();
        ArrayList<String> Medication = new ArrayList<>();
        ArrayList<String> Allergies= new ArrayList<>();

        Scanner scan = new Scanner(file);
        
        while(scan.hasNext()){
        System.out.println(scan.nextLine());
        String[] data = scan.nextLine().split(",");
        Pname.add(data[0]);
        Date.add(data[1]);
        Result.add(data[2]);
        Medication.add(data[3]);
        Allergies.add(data[4]);
        System.out.println("List of all elements: " + Pname + Date+ Result + Medication + Allergies);
        
        txtName.setText(data[0]);
        txtDate.setText(data[1]);
        txtResult.setText(data[2]);
        txtMedications.setText(data[3]);
        txtAllergies.setText(data[4]);
      
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
