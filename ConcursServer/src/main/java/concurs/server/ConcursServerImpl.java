package concurs.server;

import concurs.model.Angajat;
import concurs.model.Concurent;
import concurs.repository.AngajarRepo;
import concurs.repository.ConcurentRepo;
import concurs.services.ConcursException;
import concurs.services.IConcursObserver;
import concurs.services.IConcursServer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcursServerImpl implements IConcursServer{
    private AngajarRepo angajarRepo;
    private ConcurentRepo concurentRepo;
    private Map<String,IConcursObserver> loggedClients;

    public ConcursServerImpl(AngajarRepo angajarRepo, ConcurentRepo concurentRepo){
        angajarRepo=angajarRepo;
        concurentRepo=concurentRepo;
        loggedClients = new ConcurrentHashMap<>();
    }

    @Override
    public synchronized void login(Angajat angajat, IConcursObserver client) throws ConcursException {
        boolean loggedIn = angajarRepo.check(angajat.getName(),angajat.getPassword());
        if(loggedIn){
            if(loggedClients.get(angajat.getName())!=null)
                throw new ConcursException("User Alredy Logged In");
            loggedClients.put(angajat.getName(),client);
        }else
            throw new ConcursException("Authentification Failed");
    }


    public synchronized void create(Concurent concurent,String proba) throws ConcursException {
        concurentRepo.addConcurent(concurent.getNume(),proba,concurent.getVarsta());
        System.out.print("SUCCESULLY ADDED");

    }

    @Override
    public void logout(Angajat angajat, IConcursObserver client) throws ConcursException {

    }
}
