package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public abstract class NetworkConnection {

    private ConnectionThread connectionThread = new ConnectionThread();
    private Consumer<Serializable> onRecieveCallBack;

    public NetworkConnection(Consumer<Serializable> onRecieveCallBack){
        this.onRecieveCallBack = onRecieveCallBack;
        connectionThread.setDaemon(true);
    }

    public void startConnection() throws Exception{
        connectionThread.start();
    }

    public void send(Serializable data ) throws Exception{

        System.out.print(data.toString());
        Thread.sleep(10);
        connectionThread.out.writeObject(data.toString());

    }

    public void closeConnection() throws Exception{
        connectionThread.socket.close();
    }

    protected abstract boolean isServer();
    protected abstract String getIP();
    protected  abstract  int getPort();

    private class ConnectionThread extends Thread{

        private  Socket socket;
        private  ObjectOutputStream out;

        @Override
        public void run(){
            try(
                ServerSocket serverSocket = isServer() ? new ServerSocket(getPort()) : null;
                Socket socket = isServer() ? serverSocket.accept() : new Socket(getIP(),getPort());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                    this.socket = socket;
                    this.out = out;
                    socket.setTcpNoDelay(true);

                    while (true){
                        Serializable data = (Serializable) in.readObject();
                        onRecieveCallBack.accept(data);
                    }

                }
                catch(Exception e){
                    onRecieveCallBack.accept("Connection Closed");
            }

        }
    }
}
