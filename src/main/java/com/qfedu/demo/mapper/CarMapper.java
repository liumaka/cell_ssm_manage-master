package com.qfedu.demo.mapper;

import com.qfedu.demo.entity.Car;
import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarMapper {

    List<Car> query(@Param("carNumber") String carNumber, @Param("startTime") String startTime, @Param("endTime") String endTime);
    Long queryCount(@Param("carNumber") String ownerName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Owner> queryOwnerInfo(Integer oid);


    Integer insertCar(Car car);

    Car queryById(Integer id);

    Boolean updateCar(Car car);

    Boolean deleteCarById(Integer id);

    Boolean deleteCarByIds(String ids);
}
