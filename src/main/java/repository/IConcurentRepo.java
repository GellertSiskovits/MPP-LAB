package repository;

import model.Concurent;
import model.Concurs;

public interface IConcurentRepo {
    String showAllCompetitors();
    String searchCompetitorByConcurs(String numeConcurs);
    String searchCompetitorByVarstaCategory(String varstaCategory);
    String searchCompetitorByName(String nume);
    void addConcurent(String numeConcurent, String  nameProba,int age);
    String showAllConcurentNames();
}
