package service;


import dao.IProbaDao;
import model.Proba;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class ProbaServiceImpl implements IProbaService{
    @Autowired
    private IProbaDao probaDao;

    @Transactional
    @Override
    public long save(Proba proba) {
        return probaDao.save(proba);
    }

    @Override
    public Proba get(String probaName) {
        return probaDao.get(probaName);
    }

    @Override
    public List<Proba> list() {
        return probaDao.list();
    }

    @Override
    public void update(int id, Proba proba) {
        probaDao.update(id,proba);
    }

    @Override
    public void deleter(int id) {
        probaDao.deleter(id);
    }
}
