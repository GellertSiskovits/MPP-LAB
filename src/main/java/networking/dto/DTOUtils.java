package networking.dto;

import model.Angajat;

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

}
