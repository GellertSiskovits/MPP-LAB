package concurs.services;

import concurs.model.Concurent;
import concurs.model.Inscris;

public interface IConcursObserver {
    void contestantAdded(Concurent concurent) throws  ConcursException;
}
