package networking.dto;

import java.io.Serializable;

public class ConcurentDTO implements Serializable{

    private String nameConcurent;
    private int idConcurent;
    private int ageConcurent;
    private String numeConcurs;

    public ConcurentDTO(String nameConcurent,int ageConcurent){
        this.ageConcurent=ageConcurent;
        this.nameConcurent=nameConcurent;

    }

    public int getAgeConcurent() {
        return ageConcurent;
    }

    public int getIdConcurent() {
        return idConcurent;
    }

    public String getNameConcurent() {
        return nameConcurent;
    }

    public String getNumeConcurs() {
        return numeConcurs;
    }

    public void setAgeConcurent(int ageConcurent) {
        this.ageConcurent = ageConcurent;
    }

    public void setNameConcurent(String nameConcurent) {
        this.nameConcurent = nameConcurent;
    }
}
