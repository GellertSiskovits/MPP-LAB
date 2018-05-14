package service;

import dao.IProbaDao;
import model.Proba;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.query.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProbaService implements IProbaDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Proba proba) {
        sessionFactory.getCurrentSession().save(proba);
        return proba.getId();
    }

    @Override
    public Proba get(String probaName) {
        return sessionFactory.getCurrentSession().get(Proba.class, probaName);
    }

    @Override
    public List<Proba> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Proba> criteriaQuery = criteriaBuilder.createQuery(Proba.class);
        Root<Proba> root = criteriaQuery.from(Proba.class);
        criteriaQuery.select(root);
        Query<Proba> query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void update(int id, Proba proba) {
        Session session = sessionFactory.getCurrentSession();
        Proba proba1 = session.byId(Proba.class).load(id);
        proba1.setConcurentName(proba.getConcurentName());
        proba1.setProbaName(proba.getProbaName());
        proba1.setAgeCategory(proba.getAgeCategory());
        session.flush();
    }

    @Override
    public void deleter(int id) {
        Session session = sessionFactory.getCurrentSession();
        Proba proba = session.byId(Proba.class).load(id);
        session.delete(proba);
    }
}
