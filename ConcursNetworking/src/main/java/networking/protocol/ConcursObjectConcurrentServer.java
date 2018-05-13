package networking.protocol;

import concurs.services.IConcursServer;
import networking.utils.ConcursClientObjectWorker;

import java.net.Socket;
public class ConcursObjectConcurrentServer extends AbsConcurrentServer{
    private IConcursServer concursServer;

    public ConcursObjectConcurrentServer(int port, IConcursServer concursServer){
        super(port);
        this.concursServer=concursServer;
        System.out.println("Concurs - ConcursObjectConcurrentServer");

    }

    @Override
    protected Thread createWorker(Socket client) {
        ConcursClientObjectWorker worker = new ConcursClientObjectWorker(concursServer,client);
        Thread tw = new Thread(worker);
        return tw;
    }
}
