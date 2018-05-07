package concurs.model;

public class Concurent {
    private String nume;
    private int varsta;

    public Concurent(){

    }

    public Concurent(String nume,int varsta){
        this.nume=nume;
        this.varsta=varsta;
    }

    public int getVarsta() {
        return varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
