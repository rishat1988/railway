package com.dao.daoImpl;

import com.dao.StationDao;
import com.model.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;

@Repository
public class StationDaoImpl implements StationDao {

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void add(Station station){
        Session session = sessionFactory.getCurrentSession();
        session.persist(station);

    }
    @Override
    public void delete(Station station){
        Session session = sessionFactory.getCurrentSession();
        session.delete(station);
    }
    @Override
    public  void update(Station station){
        Session session = sessionFactory.getCurrentSession();
        session.update(station);
    }
    @Override
    public  Station getById(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Station.class, id);
    }
    @Override
    public   List<Station> allStations(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Station").list();
    }
}
