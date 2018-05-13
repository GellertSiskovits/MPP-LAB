package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="concurent")
public class Concurent {
    @Id
    @Column(name="idconcurent")
    private int idconcurent;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    public Concurent(){

    }

    public  Concurent(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdconcurent() {
        return idconcurent;
    }

    public void setIdconcurent(int idconcurent) {
        this.idconcurent = idconcurent;
    }

    @Override
    public String toString(){
        return null;
    }
}
