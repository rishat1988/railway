package com.service;

import com.dao.PassengerDao;
import com.model.Passenger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private PassengerDao passengerDao;

    @Override

    public void add(Passenger passenger) {
        passengerDao.add(passenger);


    }

    @Override
    public void delete(Passenger passenger) {
        passengerDao.delete(passenger);
    }

    @Override
    public void update(Passenger passenger) {
        passengerDao.update(passenger);
    }

    @Override
    public Passenger getById(int id) {
        return passengerDao.getById(id);
    }

    @Override
    public List<Passenger> allPassengers() {
        return passengerDao.allPassengers();
    }

}
