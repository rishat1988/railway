package com.dao.daoImpl;

import com.dao.TrainDao;
import com.model.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TrainDaoImpl implements TrainDao {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void add(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(train);
    }
    @Override
    public void delete(Train train) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(train);
    }
    @Override
    public void update(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.update(train);
    }
    @Override
    public Train getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Train.class, id);
    }
    @Override
    public List<Train> allTrains() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Train ").list();

    }
}
