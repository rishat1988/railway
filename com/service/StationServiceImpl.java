package com.service;

import com.dao.StationDao;
import com.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl {

    @Autowired
    StationDao stationDao;

   public void add(Station station){
       stationDao.add(station);
   }

    public void delete(Station station){
       stationDao.delete(station);
    }

    public  void update(Station station){
       stationDao.update(station);
    }

    public   Station getById(int id){
      return stationDao.getById(id);
    }

    public  List<Station> allStations()
    {
        return stationDao.allStations();
    }
}
