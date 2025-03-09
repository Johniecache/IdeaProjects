import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;


public class BaseChangeGUI extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/BaseChangeGUI.fxml"));

            Scene scene = new Scene(root);
            stage.setTitle("Hexadecimal converter");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){launch(args);}
}