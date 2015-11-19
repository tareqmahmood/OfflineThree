package serverpkg;/**
 * Created by tareq on 11/18/2015.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class MainServer extends Application {

    public static ObservableList<Client> clientList = FXCollections.observableArrayList();
    public static HashMap<Button, String> clientActionMap = new HashMap<>();
    public static String clientToSend;
    public static Server server;
    public static Query query;
    @Override
    public void init()
    {
        server = new Server();
        query = new Query();
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {

        Parent root = FXMLLoader.load(getClass().getResource("ServerView.fxml"));
        ServerController.setMain(this);
        primaryStage.setTitle("Server");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Override
    public void stop()
    {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
