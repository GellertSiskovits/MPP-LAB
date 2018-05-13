import concurs.model.Angajat;
import concurs.model.Concurent;
import concurs.repository.DataBaseConnection;
import concurs.server.ConcursService;
import concurs.server.IConcursService;
import concurs.services.ConcursException;
import concurs.services.IConcursObserver;
import concurs.services.IConcursServer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.text.html.ListView;
import javax.xml.crypto.Data;

public class StartObjectClient extends Application implements IConcursObserver {

    private static int defaultChatPort = 55555;
    private static String defaultServer = "localhost";

    private static IConcursService ctrl = new ConcursService();
    private static IConcursServer server;
    private static Angajat angajat;
    private static javafx.scene.control.ListView<String> list = new javafx.scene.control.ListView<>();
    private static ObservableList<String> concurents = FXCollections.observableArrayList();

    public static void setserver(IConcursServer s) {
        server = s;
    }

    @Override
    public void contestantAdded(Concurent concurent) throws ConcursException {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridLogin = new GridPane();
        gridLogin.setPadding(new Insets(10, 10, 10, 10));
        gridLogin.setVgap(5);
        gridLogin.setHgap(5);

        Label lbUser = new Label("User");
        Label lbPwd = new Label("Password");


        TextField txtUser = new TextField();
        txtUser.setPromptText("nume utilizator");
        TextField txtPwd = new TextField();
        txtPwd.setPromptText("parola");

        Button btnLogin = new Button("Login");

        GridPane.setConstraints(lbUser, 0, 1);
        gridLogin.getChildren().add(lbUser);
        GridPane.setConstraints(txtUser, 1, 1);
        gridLogin.getChildren().add(txtUser);
        GridPane.setConstraints(lbPwd, 0, 2);
        gridLogin.getChildren().add(lbPwd);
        GridPane.setConstraints(txtPwd, 1, 2);
        gridLogin.getChildren().add(txtPwd);
        GridPane.setConstraints(btnLogin, 1, 3);
        gridLogin.getChildren().add(btnLogin);


        btnLogin.setOnAction((xx) -> {
            if(txtUser.getText().isEmpty() || txtPwd.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Avertizare!");
                alert.setHeaderText(null);
                alert.setContentText("Lipseste numele utilizatorului sau parola!");
                alert.showAndWait();
            }
            else if(!ctrl.validate(txtUser.getText(), txtPwd.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Eroare!");
                alert.setHeaderText(null);
                alert.setContentText("Utilizatorul sau parola este gresita!");
                alert.showAndWait();
            }
            else{
                Alert alertLogin = new Alert(Alert.AlertType.INFORMATION);
                alertLogin.setTitle("Inregistrare cu succes!");
                alertLogin.setHeaderText(null);
                alertLogin.setContentText("Utilizatorul " + txtUser.getText() + " s-a logat cu succes!");
                alertLogin.showAndWait();
                primaryStage.close();

                angajat=new Angajat(txtUser.getText(), txtPwd.getText());

//                try {
//                    server.login(angajat,this);
//                } catch (ConcursException e) {
//                    e.printStackTrace();
//                }

//                ListView<String> list = new ListView<String>();
                list.setPrefSize(700, 200);
                list.setItems(FXCollections.observableArrayList(ctrl.showContestants()));
                javafx.scene.control.ListView<String> listData = new javafx.scene.control.ListView<>();
                listData.setPrefSize(700, 200);

                Label lbData = new Label("Data: ");
                Label lbSpectacolId = new Label("Spectacol id: ");
                Label lbNumeClient = new Label("Nume client: ");
                Label lbNrLocDorit = new Label("Nr. locuri dorite: ");

                GridPane grid = new GridPane();
                grid.setPadding(new Insets(10, 10, 10, 10));
                grid.setVgap(5);
                grid.setHgap(5);

                GridPane gridInner = new GridPane();
                gridInner.setPadding(new Insets(10, 10, 10, 10));
                gridInner.setVgap(5);
                gridInner.setHgap(5);

                TextField txtData = new TextField();
                txtData.setPromptText("ex. 17.03.2017");
                TextField txtSpectacolId = new TextField();
                txtSpectacolId.setPromptText("ex. s1");
                TextField txtNumeClient = new TextField();
                txtNumeClient.setPromptText("ex. John Dee");
                TextField txtNrLocDorit = new TextField();
                txtNrLocDorit.setPromptText("ex. 5");

                Button btnArtisti = new Button("Afisare artisti");
                Button btnCauta = new Button("Cauta");
                Button btnAdauga = new Button("Adauga");
                Button btnLogout = new Button("Logout");

                GridPane.setConstraints(list, 0, 1);
                grid.getChildren().add(list);
                GridPane.setConstraints(listData, 0, 2);
                grid.getChildren().add(listData);
                GridPane.setConstraints(gridInner, 1, 1);
                grid.getChildren().add(gridInner);
                GridPane.setConstraints(lbData, 1, 1);
                gridInner.getChildren().add(lbData);
                GridPane.setConstraints(txtData, 2, 1);
                gridInner.getChildren().add(txtData);
                GridPane.setConstraints(btnCauta, 2, 2);
                gridInner.getChildren().add(btnCauta);
                GridPane.setConstraints(lbSpectacolId, 1, 4);
                gridInner.getChildren().add(lbSpectacolId);
                GridPane.setConstraints(txtSpectacolId, 2, 4);
                gridInner.getChildren().add(txtSpectacolId);
                GridPane.setConstraints(lbNumeClient, 1, 6);
                gridInner.getChildren().add(lbNumeClient);
                GridPane.setConstraints(txtNumeClient, 2, 6);
                gridInner.getChildren().add(txtNumeClient);
                GridPane.setConstraints(lbNrLocDorit, 1, 8);
                gridInner.getChildren().add(lbNrLocDorit);
                GridPane.setConstraints(txtNrLocDorit, 2, 8);
                gridInner.getChildren().add(txtNrLocDorit);
                GridPane.setConstraints(btnAdauga, 2, 10);
                gridInner.getChildren().add(btnAdauga);

                GridPane.setConstraints(btnArtisti, 0, 3);
                grid.getChildren().add(btnArtisti);
                GridPane.setConstraints(btnLogout, 1, 3);
                grid.getChildren().add(btnLogout);


                btnCauta.setOnAction((x) -> {
                    if (txtData.getText().isEmpty()) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Avertizare!");
                        alert.setHeaderText(null);
                        alert.setContentText("Nu ati introdus nici-o data");
                        alert.showAndWait();
                    }

                    else
                        listData.setItems(FXCollections.observableArrayList(ctrl.searchFor(txtData.getText())));
                });

                btnArtisti.setOnAction((x) -> {
                    list.setItems(FXCollections.observableArrayList(ctrl.showContestants()));
                });

                btnAdauga.setOnAction((x) -> {
                    if (txtSpectacolId.getText().isEmpty() || txtNrLocDorit.getText().isEmpty() || txtNumeClient.getText().isEmpty() ) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Avertizare!");
                        alert.setHeaderText(null);
                        alert.setContentText("Lipseste id-ul spectacolului, numele clientului sau numar de locuri dorite!");
                        alert.showAndWait();
                    } else {
                        try {
                            Concurent concurent = new Concurent("",2);//txtSpectacolId.getText(), txtNumeClient.getText(), Integer.parseInt(txtNrLocDorit.getText()));
//                            this.reservationMade(rezervare);
                            server.create(concurent,"");
                        } catch (ConcursException e) {
                            e.printStackTrace();
                        }
                        concurents = FXCollections.observableArrayList(ctrl.showContestants());
                        list.setItems(concurents);
                    }
                });

                Scene secondScene = new Scene(grid, 1050, 460);

                Stage secondStage = new Stage();
                secondStage.setTitle("Rezervari");
                secondStage.setScene(secondScene);
                secondStage.show();

                btnLogout.setOnAction((x) -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Delogare cu succes!");
                    alert.setHeaderText(null);
                    alert.setContentText("Ati fost delogat cu succes!");
                    alert.showAndWait();
                    DataBaseConnection.closeConnection();

                    try {
                        server.logout(angajat, this);
                    } catch (ConcursException e) {
                        e.printStackTrace();
                    }
                    secondStage.close();
                    primaryStage.show();
                });

            }
        });

        Scene scene = new Scene(gridLogin, 300, 150);
        primaryStage.setTitle("Logare");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    }
