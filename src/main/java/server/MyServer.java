package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MyServer {

    private ObjectInputStream input;
    private ObjectOutputStream output;

    private MyServer server;
    private Socket connection;

    public MyServer(){

    }
}
