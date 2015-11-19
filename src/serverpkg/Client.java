package serverpkg;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.EventHandler;
import util.NetworkUtil;

/**
 * Created by tareq on 11/18/2015.
 */
public class Client {
    private StringProperty name;
    private Button action;
    private Client my;
    Client(String name)
    {
        this.name = new SimpleStringProperty(name);
        action = new Button("send");
        my = this;
        action.setOnAction(new EventHandler <ActionEvent> () {
            @Override
            public void handle(ActionEvent event)
            {
                String cName = MainServer.clientActionMap.get(event.getSource());
                System.out.println("pressed " + cName);
                MainServer.query.put(cName, my);
            }
        });
    }

    public String getName()
    {
        return name.get();
    }

    public Button getAction()
    {
        return action;
    }
    public void setName(String fName)
    {
        name.set(fName);
    }
    public void setAction(String fAction)
    {
        action.setText(fAction);
    }

}
