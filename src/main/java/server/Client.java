package server;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends NetworkConnection{
    public Client(Consumer<Serializable> onRecieveCallBack){
        super(onRecieveCallBack);
    }

    @Override
    protected boolean isServer() {
        return false;
    }

    @Override
    protected String getIP() {
        return null;
    }

    @Override
    protected int getPort() {
        return 0;
    }
}
