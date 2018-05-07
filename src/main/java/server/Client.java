package server;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends NetworkConnection{
    private String ipAdress;
    private  int port;
    public Client(String ipAdress, int port,Consumer<Serializable> onRecieveCallBack){
        super(onRecieveCallBack);
        this.ipAdress = ipAdress;
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return false;
    }

    @Override
    protected String getIP() {
        return ipAdress;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
