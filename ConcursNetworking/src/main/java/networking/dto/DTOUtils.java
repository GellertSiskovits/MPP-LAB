package networking.dto;


import concurs.model.Angajat;
import concurs.model.Concurent;
import concurs.model.Concurs;

public class DTOUtils {
    public static Angajat getFromDTO(UserDTO userDTO){
        String user = userDTO.getUsername();
        String pass = userDTO.getPassword();
        return new Angajat(user,pass);
    }

    public static UserDTO getDTO(Angajat angajat){
        String username = angajat.getName();
        String password = angajat.getPassword();
        return new UserDTO(username,password);
    }

    public static Concurent getFromDTO(ConcurentDTO concurent){
        String nuumeConcurent = concurent.getNameConcurent();
        int ageConcurent = concurent.getAgeConcurent();
        return new Concurent(nuumeConcurent,ageConcurent);
    }

    public static ConcurentDTO getDTO(Concurent concurent){
        String nume = concurent.getNume();
        int age = concurent.getVarsta();
        return  new ConcurentDTO(nume,age);
    }

}
