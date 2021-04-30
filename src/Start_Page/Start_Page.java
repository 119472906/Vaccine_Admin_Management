package Start_Page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start_Page extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
       
        Parent root = FXMLLoader.load(getClass().getResource("/Views/Sign_In_Page.fxml"));    
        Scene scene = new Scene(root);      
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        
        launch(args);
    }
    
}
