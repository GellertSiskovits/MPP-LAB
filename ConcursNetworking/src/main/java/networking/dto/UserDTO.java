package networking.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

    private String username;
    private String password;

    public UserDTO(String id){
        this(id,"");
    }

    public UserDTO(String username, String password){
        this.username=username;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString(){
        return "UserDTO["+username+' '+password+"]";
    }
}
