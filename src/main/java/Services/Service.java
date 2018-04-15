package Services;

import model.Concurent;
import repository.ConcurentRepo;
import repository.IConcurentRepo;

public class Service {
    IConcurentRepo concurentRepo;

    public Service(){
        concurentRepo=new ConcurentRepo();
    }

    public String showAllConcurenti(){
        return concurentRepo.showAllCompetitors();
    }

    public void addNewConcurent(String numeCompetitior,String numeProba, int age){



        concurentRepo.addConcurent(numeCompetitior,numeProba,age);

    }

    public String searchByCategory(String category){
        return concurentRepo.searchCompetitorByVarstaCategory(category);
    }

    public String searchByProba(String proba){
        return concurentRepo.searchCompetitorByConcurs(proba);
    }

    public String showAllContesantNames(){return concurentRepo.showAllConcurentNames();}
}
