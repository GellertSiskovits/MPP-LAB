package concurs.repository;

import concurs.model.Concurs;


public interface IConcursRepo {
    void afiseazaProbaNume();
    Concurs gasesteProba(String nume, String categorie);
}
