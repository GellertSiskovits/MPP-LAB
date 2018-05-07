package concurs.model;

public class Angajat {
    private String aId;
    private String name;
    private String password;

    public Angajat(){

    }

    public Angajat(String aId, String name, String password){
        this.aId=aId;
        this.name=name;
        this.password=password;
    };

    public Angajat( String name, String password){

        this.name=name;
        this.password=password;
    };

    public String getaId() {
        return aId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


