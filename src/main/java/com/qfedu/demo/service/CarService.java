package com.qfedu.demo.service;

import com.qfedu.demo.entity.Car;
import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.Owner;
import com.qfedu.demo.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarMapper carMapper;

    public List<Car> query(String carNumber, String startTime, String endTime) {
        return carMapper.query(carNumber,startTime,endTime);
    }

    public Long queryCount(String carNumber, String startTime, String endTime) {
        return carMapper.queryCount(carNumber,startTime,endTime);
    }

    public List<Owner> queryOwnerInfo(Integer id) {
        return carMapper.queryOwnerInfo(id);
    }


    public Integer insertcar(Car car) {
        return carMapper.insertCar(car);
    }

    public Car queryById(Integer id) {
        return carMapper.queryById(id);
    }

    public Boolean updateCar(Car car) {
        return carMapper.updateCar(car);
    }

    public Boolean deleteCarById(Integer id) {
        return carMapper.deleteCarById(id);
    }

    public Boolean deleteCarByIds(String ids) {
        return carMapper.deleteCarByIds(ids);
    }
}
