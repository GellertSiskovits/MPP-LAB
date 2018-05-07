package concurs.server;

public interface IConcursService {
    String showContestants();
    String searchFor(String data);

    String addConcurent(String name, int age, String contest);

    boolean validate(String user,String pass);
}
