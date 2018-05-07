package myServer;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame{
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private JTextField userText;
    private JTextArea window;

    private ServerSocket serverSocket;
    private Socket connection;

    public Server(){
        super("App");
        userText = new JTextField();


    }


}
