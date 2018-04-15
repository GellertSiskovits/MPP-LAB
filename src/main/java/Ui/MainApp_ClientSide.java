package Ui;

import com.sun.corba.se.spi.activation.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.MyServer;

public class MainApp_ClientSide extends Application {
    Parent root;
    Scene scene;
    UiController uiController = new UiController();
    public  void start(Stage stage) throws  Exception {
        //  Menu.run();
        try {
            root = FXMLLoader.load(getClass().getResource("/UiFX.fxml"));

            scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
            MyServer myServer = new MyServer(uiController);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
