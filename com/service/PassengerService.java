package com.service;

import com.model.Passenger;

import java.util.List;

public interface PassengerService {

    void add(Passenger passenger);

    void delete(Passenger passenger);

    void update(Passenger passenger);

    Passenger getById(int id);

    List<Passenger> allPassengers();
}
