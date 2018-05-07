package Ui;

import Services.Service;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import repository.AngajarRepo;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import repository.ConcurentRepo;
import server.Client;
import server.NetworkConnection;
import server.Server;

import java.util.ResourceBundle;

public class UiController implements Initializable{

    private boolean isServer= false;
    private NetworkConnection connection = isServer ? createServer() : createClient();

    public Server createServer(){
        return  new Server(5555,data->{
            Platform.runLater(()->{
                uiTextArea.appendText(data.toString()+"\n");
            });
        });
    }

    public Client createClient(){
        return  new Client("127.0.0.1",5555,data->{
            Platform.runLater(()->{
                uiTextArea.appendText(data.toString()+"\n");
            });
        });
    }

    public void sendMessage(ActionEvent event){
        String message = isServer ? "Server-> "  : "Client-> ";
        message+=userName_Tfield.getText();
        userName_Tfield.clear();
        System.out.print("YOOOOOOOY:"+ message)
;        uiTextArea.appendText(message);

        try {
            connection.send("baaa");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void init() throws Exception {

        System.out.print("CONNCECTION PART");
        connection.startConnection();



    }

    @FXML private AnchorPane root;
    @FXML private TextField textField_uName;
    @FXML private TextField textField_uPass;
    @FXML private javafx.scene.control.Button loginButton;
    @FXML private TextArea uiTextArea = new TextArea();
    @FXML private TextField userName_Tfield=new TextField();
    @FXML private TextField userAge_Tfield;
    @FXML private TextField userProba_Tfield;
    @FXML private Label desen;
    @FXML private Label poezie;
    @FXML private Label comori;
    @FXML private TextField category_Tfield;
    @FXML private TextField proba_Tfield;


    AngajarRepo aRepo = new AngajarRepo();
    ConcurentRepo concurentRepo = new ConcurentRepo();
    Service service = new Service();

    @FXML
    public void showNames(ActionEvent event){
        this.uiTextArea.setText(service.showAllContesantNames());
    }

    public void setLabels(){

        String desenT="Nr. de concurenti la desen "+concurentRepo.countDesen().toString();
        String poezieT="Nr. de concurenti la poezie "+concurentRepo.countPoezie();
        String comoriT="Nr. de concurenti la comori "+concurentRepo.countComori();
        this.desen.setText(desenT);
        this.poezie.setText(poezieT);
        this.comori.setText(comoriT);
    }

    @FXML
    public void addContestant(ActionEvent event){
        service.addNewConcurent(this.userName_Tfield.getText(),this.userProba_Tfield.getText(),Integer.parseInt(this.userAge_Tfield.getText()));
        this.userName_Tfield.setPromptText("Nume");
        this.userAge_Tfield.setPromptText("Varsta");

        this.uiTextArea.setText(service.searchByProba(this.userProba_Tfield.getText()));
        this.userProba_Tfield.setPromptText("Proba");

        this.setLabels();
    }

    @FXML
    public void searchByCategory(ActionEvent event){
        this.uiTextArea.setText(service.searchByCategory(this.category_Tfield.getText()));
    }

    @FXML
    public void searchByProba(ActionEvent event){
        this.uiTextArea.setText(service.searchByProba(this.proba_Tfield.getText()));
    }

    @FXML
    public void login(ActionEvent event) throws IOException {

        if(aRepo.check(this.textField_uPass.getText(),this.textField_uName.getText())){
            Parent root = FXMLLoader.load(getClass().getResource("/MainView.fxml"));

            Scene secondScene = new Scene(root,600,400);
            Stage primaryStage = (Stage)this.textField_uName.getScene().getWindow();
        primaryStage.setScene(secondScene);
        }
        else
            System.out.print("Fail");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void showAllConcurenti(ActionEvent event){
        this.uiTextArea.setText("");
        this.uiTextArea.setText(service.showAllConcurenti());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    public TextField getCategory_Tfield() {
        return category_Tfield;
    }

    public TextArea getUiTextArea() {
        return uiTextArea;
    }


}
