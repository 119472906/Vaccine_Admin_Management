package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class VaccinationCentresController implements Initializable{
    
    @FXML private TableView<VacCentres> tableView;
    @FXML private TableColumn<VacCentres, String> CountyColumn;
    @FXML private TableColumn<VacCentres, String> siteNameColumn;
    @FXML private TableColumn<VacCentres, String> siteAddressColumn;
    
    @FXML private TextField CountyTextField;
    @FXML private TextField siteNameTextField;
    @FXML private TextField siteAddressTextField;
    @FXML
    private Button AddNewCentre, btnBack;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CountyColumn.setCellValueFactory(new PropertyValueFactory<VacCentres, String>("County"));
        siteNameColumn.setCellValueFactory(new PropertyValueFactory<VacCentres, String>("siteName"));
        siteAddressColumn.setCellValueFactory(new PropertyValueFactory<VacCentres, String>("siteAddress"));
        
        tableView.setItems(getCentre());
    }
    
    
   
    
      @FXML
    public void AddNewCentre() throws Exception {
        VacCentres newVacCentres = new VacCentres(CountyTextField.getText(),
                                      siteNameTextField.getText(),
                                      siteAddressTextField.getText()); 
        
        tableView.getItems().add(newVacCentres);

}
    
    
    
    public ObservableList<VacCentres> getCentre()
    {
    
        ObservableList<VacCentres> centres = FXCollections.observableArrayList();
        centres.add(new VacCentres("Cork", "City Hall", "Cork City Hall, Anglesea St. Centre, Cork City"));
        centres.add(new VacCentres("Cork", "Páirc Uí Chaoimh", "The Marina, Cork City"));
        centres.add(new VacCentres("Dublin", "Aviva Stadium", "Lansdowne Road, Ballsbridge, Dublin 4"));
        centres.add(new VacCentres("Dublin", "Helix Theatre DCU", "DCU Santry"));
        centres.add(new VacCentres("Galway", "Galway Racecourse", "Galway Racecourse, Ballybrit, Galway"));
        centres.add(new VacCentres("Kildare", "Punchestown Racecourse", "Punchestown, Naas, Co Kildare"));
        centres.add(new VacCentres("Limerick", "Radisson Hotel", "Ennis Road, Limerick"));
        centres.add(new VacCentres("Sligo", "Sligo IT Sports Arena", "Sligo IT, Ash Ln, Bellanode, Co Sligo"));
        centres.add(new VacCentres("Wexford", "Riverside Hotel Enniscorthy", "The Promenade, Enniscorthy, Co Wexford"));
        
        return centres;
    }
    
     @FXML
    public void BackToMenu() throws Exception {
        Parent root = javafx.fxml.FXMLLoader.load(getClass().getResource("/Views/Admin_Menu.fxml"));
        Stage window = (Stage) btnBack.getScene().getWindow();
        window.setScene(new Scene(root)); 

}
    
}
