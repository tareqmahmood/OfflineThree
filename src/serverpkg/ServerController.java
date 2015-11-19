package serverpkg;

/**
 * Created by tareq on 11/18/2015.
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

public class ServerController implements Initializable {

    @FXML public TableView <Client> clientTable;

    @FXML public TableColumn <Client, String> clientName;

    @FXML public TableColumn <Client, String> clientAction;

    @FXML public TextArea msgBox;

    @FXML
    private void addClient()
    {
        main.clientList.add(new Client("Tareq"));
        clientTable.scrollTo(clientTable.getItems().size());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WriteThreadServer.setController(this);
        clientName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        clientAction.setCellValueFactory(new PropertyValueFactory<Client, String>("action"));
        clientName.setStyle("-fx-alignment: CENTER;");
        clientAction.setStyle("-fx-alignment: CENTER;");
        clientTable.setItems(main.clientList);
        //msgBox.setText("hi");
    }

    public static MainServer main;

    public static void setMain(MainServer m)
    {
        main = m;
    }
}
