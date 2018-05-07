package concurs.services;

import concurs.model.Angajat;
import concurs.model.Inscris;

public interface IConcursServer {
    void login(Angajat angajat, IConcursObserver client) throws ConcursException;
    void create(Inscris inscris) throws ConcursException;
    void logout(Angajat angajat, IConcursObserver client) throws ConcursException;
}
