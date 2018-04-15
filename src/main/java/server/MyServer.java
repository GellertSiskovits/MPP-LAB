package server;

import Ui.UiController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    private ObjectInputStream input;
    private ObjectOutputStream output;

    private ServerSocket server;
    private Socket connection;

    private  UiController uiController;


    public MyServer(UiController uiController){
        this.uiController=uiController;
    }

    public void startRunning(){
        try{
            server =  new ServerSocket(5555,100);
            while(true){
                try{
                    //connect
                    waitForConnection();
                    setupStreams();
                    whileCommunication();
                }catch (EOFException exp){
                    System.out.print("\n Server endended the connection");
                }finally {
                    closeConnection();
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //wait for connecion -> display information
    private void waitForConnection() throws  IOException{
        System.out.print("\nWaiting for Connection...\n");
        connection=server.accept();
        System.out.print("\nConnected to Server"+connection.getInetAddress().getHostName()+"\n");
    }

    //set-up Streams: send and recieve data
    private void setupStreams() throws IOException{
        //output
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();

        //input
        input = new ObjectInputStream(connection.getInputStream());

        System.out.print("\nStreams are ready...\n");
    }

    //whileConnected - during connection
    private void whileCommunication() throws IOException{
        String message = " You are now Connected!" ;
        System.out.print("\n"+message+"\n");
        do{
            try{
                message = (String) input.readObject();
                System.out.print("\nMessage..."+message+"\n");
            }catch (ClassNotFoundException ex){
                System.out.print("\nInvalid Message...\n");
            }
        }while(!message.equals("CLIENT-END"));
    }

    //close Connection
    public void closeConnection()throws  IOException{
        System.out.print("\nClosing Connection\n");
        try{
            output.close();
            input.close();
            connection.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    //send message

    public void sendMessage(String message){
        try{
            output.writeObject("SERVER - "+message);
            output.flush();
            this.uiController.getUiTextArea().appendText(message);
            showMessage("\nSERVER - " + message);
        }catch (IOException ex){
            ex.printStackTrace();
            this.uiController.getUiTextArea().appendText("ERROR");
        }
    }

    //updates main Window
    public void showMessage(final String text){
        this.uiController.getUiTextArea().appendText(text);
    }
}
