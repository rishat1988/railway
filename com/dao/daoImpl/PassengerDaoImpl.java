package com.dao.daoImpl;

import com.dao.PassengerDao;
import com.model.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassengerDaoImpl implements PassengerDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(passenger);

    }
    @Override
    public void delete(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(passenger);
    }
    @Override
    public void update(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.update(passenger);
    }
    @Override
    public Passenger getById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Passenger.class, id);
    }
    @Override
    public List<Passenger> allPassengers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from Passenger ",
                Passenger.class).list(); /////question
    }
}
