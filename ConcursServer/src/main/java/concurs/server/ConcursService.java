package concurs.server;

import concurs.repository.AngajarRepo;
import concurs.repository.ConcurentRepo;
import concurs.repository.IAngajatRepo;
import concurs.repository.IConcurentRepo;

public class ConcursService implements IConcursService{
    private  IAngajatRepo angajatRepo = new AngajarRepo();
    private IConcurentRepo concurentRepo = new ConcurentRepo();



    @Override
    public String showContestants() {
        return concurentRepo.showAllConcurentNames();
    }

    @Override
    public String searchFor(String data) {
        return null;
    }

    @Override
    public String addConcurent(String name, int age, String contest) {
        return null;
    }

    public boolean validate(String user, String pass) {
        return angajatRepo.check(user,pass);
    }
}
