package clientpkg;/**
 * Created by tareq on 11/19/2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import serverpkg.ServerController;

import java.io.IOException;

public class MainClient extends Application {

    public String clientName;
    public Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ClientView.fxml"));
        ClientController.setMain(this);
        primaryStage.setTitle("Client");
        primaryStage.setScene(new Scene(root, 498, 305));
        primaryStage.show();
        stage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
