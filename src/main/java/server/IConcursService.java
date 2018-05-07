package server;

public interface IConcursService {
    String showContestants();
    String searchFor(String data);

    void addConcurent(String name, int age, String contest);

    boolean validate(String user, String pass);
}
