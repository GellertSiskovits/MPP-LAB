package server;

import Ui.UiController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyServerTest extends Application{
    Parent root;
    Scene scene;
    UiController uiController = new UiController();

    public  void start(Stage stage){

        //  Menu.run();
        try {
            root = FXMLLoader.load(getClass().getResource("/UiFX.fxml"));

            scene = new Scene(root,600,400);
            stage.setScene(scene);
            MyServer myServer = new MyServer(this.uiController);
            myServer.startRunning();
            stage.show();


        }catch (Exception e){
            e.printStackTrace();
        }
       // MyServer myServer = new MyServer(this.uiController);

    }
}
