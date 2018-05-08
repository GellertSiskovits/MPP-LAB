package networking.protocol;

import concurs.services.IConcursServer;

import java.net.Socket;
public class ConcursObjectConcurrentServer extends AbsConcurrentServer{
    private IConcursServer concursServer;

    public ConcursObjectConcurrentServer(int port, IConcursServer concursServer){
        super(port);
        this.concursServer=concursServer;

    }

    @Override
    protected Thread createWorker(Socket client) {
        
        return null;
    }
}
