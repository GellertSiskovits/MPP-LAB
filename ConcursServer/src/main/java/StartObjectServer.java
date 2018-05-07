import concurs.repository.AngajarRepo;
import concurs.repository.ConcurentRepo;
import concurs.server.ConcursServerImpl;
import concurs.services.IConcursServer;

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

    }
}
