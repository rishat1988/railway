package com.service;

import com.dao.StationDao;
import com.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StationServiceImpl implements  StationService{

    @Autowired
    StationDao stationDao;

@Override
@Transactional (propagation = Propagation.REQUIRES_NEW,
rollbackFor = Exception.class,
timeout = 10)
   public void add(Station station){
       stationDao.add(station);
   }

    @Override
    @Transactional (propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class,
            timeout = 5)
    public void delete(Station station){
       stationDao.delete(station);
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class,
            timeout = 20)
    public  void update(Station station){
       stationDao.update(station);
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class,
            timeout = 60)
    public   Station getById(int id){
      return stationDao.getById(id);
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRES_NEW,
            rollbackFor = Exception.class,
            timeout = 60)
    public  List<Station> allStations()
    {
        return stationDao.allStations();
    }
}
