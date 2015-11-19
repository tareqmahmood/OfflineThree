package clientpkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import serverpkg.MainServer;
import tcpdiff.ReadThread;

public class ClientController {

    @FXML
    private Label lblName;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnConnect;

    @FXML
    private Label lblMsgServer;

    @FXML
    public TextArea msgBox;

    @FXML
    void connectServer(ActionEvent event) {
        main.clientName = txtName.getText();
        txtName.clear();
        txtName.setVisible(false);
        lblName.setVisible(false);
        btnConnect.setVisible(false);
        lblMsgServer.setVisible(true);
        msgBox.setVisible(true);

        new Client(main.clientName);
        ReadThreadClient.getController(this);
        main.stage.setTitle(main.clientName);
    }

    public static MainClient main;
    public static void setMain(MainClient m) {main = m;}

}

