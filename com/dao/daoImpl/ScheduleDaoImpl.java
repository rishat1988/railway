package com.dao.daoImpl;

import com.dao.ScheduleDao;
import com.model.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
  public   void add(Schedule schedule){
      Session session = sessionFactory.getCurrentSession();
      session.persist(schedule);

  }
    @Override
    public void delete(Schedule schedule){
        Session session = sessionFactory.getCurrentSession();
        session.delete(schedule);
    }
    @Override
    public  void update(Schedule schedule){
    Session session = sessionFactory.getCurrentSession();
    session.update(schedule);}

    @Override
    public  Schedule getById(int id){
    Session session = sessionFactory.getCurrentSession();
    return session.get(Schedule.class , id);}
    @Override
    public List<Schedule> allSchedules() {
        Session session = sessionFactory.getCurrentSession();
return session.createQuery("from Schedule ").list();
    }
}
