package concurs.repository;

import model.Concurs;

public interface IConcursRepo {
    void afiseazaProbaNume();
    Concurs gasesteProba(String nume, String categorie);
}
