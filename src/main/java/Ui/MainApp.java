package Ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{
    Parent root;
    Scene scene;

    public  void start(Stage stage) throws  Exception {
      //  Menu.run();
       try {
           root = FXMLLoader.load(getClass().getResource("/UiFX.fxml"));

           scene = new Scene(root,600,400);
           stage.setScene(scene);
           stage.show();

       }catch (Exception e){
           e.printStackTrace();
       }
    }


    public void changeScene(){

    }

}
