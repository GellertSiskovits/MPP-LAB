import concurs.repository.AngajarRepo;
import concurs.repository.ConcurentRepo;
import concurs.server.ConcursServerImpl;
import concurs.services.IConcursServer;
import networking.protocol.AbstractServer;
import networking.protocol.ConcursObjectConcurrentServer;
import networking.protocol.ServerException;

import java.io.IOException;
import java.util.Properties;

public class StartObjectServer {
    private  static int defaultPort = 55555;
    public static void main(String[] args){
        Properties serverProps=new Properties();
        try {
            serverProps.load(StartObjectServer.class.getResourceAsStream("/concursserver.properties"));
            System.out.println("Server properties set. ");
            serverProps.list(System.out);
        } catch (IOException e) {
            System.err.println("Cannot find concursserver.properties "+e);
            return;
        }
        AngajarRepo angajarRepo = new AngajarRepo();
        ConcurentRepo concurentRepo = new ConcurentRepo();

        IConcursServer concursServerImpl = new ConcursServerImpl(angajarRepo,concurentRepo);

        int concursServerport = defaultPort;

        try{
            concursServerport = Integer.parseInt(serverProps.getProperty("concurs.server.port"));
        }catch (NumberFormatException nef){
            System.err.println("Wrong  Port Number "+nef.getMessage());
            System.err.println("Using default port "+defaultPort);
        }

        System.out.println("Starting server on port: "+concursServerport);
        AbstractServer server = new ConcursObjectConcurrentServer(concursServerport, concursServerImpl);
        try {
            server.start();
        } catch (ServerException e) {
            System.err.println("Error starting the server" + e.getMessage());
        }

    }
}
