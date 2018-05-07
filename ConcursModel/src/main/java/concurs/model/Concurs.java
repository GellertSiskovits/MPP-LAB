package concurs.model;

import java.util.List;

public class Concurs {
    private String idConcurs;
    private String nameProba;
    private String categorieVarsta;
    private List<Concurent> concurentList;


    public Concurs(String idConcurs,String nameConcurs,String categorieVarsta){
        this.idConcurs=idConcurs;
        this.nameProba =nameConcurs;
        this.categorieVarsta=categorieVarsta;
    }

    public Concurs(String nameConcurs,String categorieVarsta){
        this.nameProba =nameConcurs;
        this.categorieVarsta=categorieVarsta;
    }

    public Concurs(){

    }

    public String getCategorieVarsta() {
        return categorieVarsta;
    }

    public String getIdConcurs() {
        return idConcurs;
    }

    public String getNameProba() {
        return nameProba;
    }
}
