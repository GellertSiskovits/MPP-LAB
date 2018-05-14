package service;

import model.Proba;

import java.util.List;

public interface IProbaService {
    long save(Proba proba);
    Proba get(String probaName);
    List<Proba> list();
    void update(int id, Proba proba);
    void deleter(int id);
}
