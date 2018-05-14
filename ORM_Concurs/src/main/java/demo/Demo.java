package demo;

import model.Concurent;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;


public class Demo {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        Concurent concurent = new Concurent();
        concurent.setName("Bob");
        concurent.setAge(12);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(concurent);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
