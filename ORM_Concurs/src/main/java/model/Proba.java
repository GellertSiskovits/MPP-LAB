package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="concurs")
public class Proba {
    @Id
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementor", strategy = "increment")
    @Column(name="ID")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="NumeConcurent")
    private String concurentName;

    public String getConcurentName() {
        return concurentName;
    }

    public void setConcurentName(String concurentName) {
        this.concurentName = concurentName;
    }

    @Column(name="CategorieVarsta")
    private String ageCategory;

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    @Column(name="NumeProba")
    private String probaName;

    public String getProbaName() {
        return probaName;
    }

    public void setProbaName(String probaName) {
        this.probaName = probaName;
    }

    public Proba(){

    }


    public  Proba(String concurentName, String ageCategory, String probaName){
        this.concurentName = concurentName;
        this.ageCategory = ageCategory;
        this.probaName = probaName;
    }


    @Override
    public String toString(){
        return null;
    }
}
