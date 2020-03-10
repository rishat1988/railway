package com.dao;

import com.model.Passenger;

import java.util.List;

public interface PassengerDao {

    void add(Passenger passenger);

    void delete(Passenger passenger);

    void update(Passenger passenger);

    Passenger getById(int id);

    List<Passenger> allPassengers();


}
