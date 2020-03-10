package com.dao;

import com.model.*;

import java.util.List;

public interface ScheduleDao {

    void add(Schedule schedule);

    void delete(Schedule schedule);

    void update(Schedule schedule);

    Schedule getById(int id);

    List<Schedule> allSchedules();
}
