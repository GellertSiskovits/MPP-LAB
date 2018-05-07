package server;

import repository.*;

public class ConcursService implements IConcursService{
    private IAngajatRepo angajatRepo = new AngajarRepo();
    private IConcurentRepo concurentRepo = new ConcurentRepo();
    private IConcursRepo concursRepo = new ConcursRepo();

    @Override
    public String showContestants() {

        return concurentRepo.showAllConcurentNames();

    }

    @Override
    public String searchFor(String data) {
        return concurentRepo.searchCompetitorByConcurs(data);
    }

    @Override
    public void addConcurent(String name, int age, String contest)
    {
        concurentRepo.addConcurent(name,contest,age);
    }

    @Override
    public boolean validate(String user, String pass) {
        return angajatRepo.check(user,pass);
    }

}
