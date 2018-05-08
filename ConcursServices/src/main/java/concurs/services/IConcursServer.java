package concurs.services;

import concurs.model.Angajat;
import concurs.model.Concurent;
import concurs.model.Inscris;

public interface IConcursServer {
    void login(Angajat angajat, IConcursObserver client) throws ConcursException;
    void create(Concurent concurent,String proba) throws ConcursException;
    void logout(Angajat angajat, IConcursObserver client) throws ConcursException;
}
