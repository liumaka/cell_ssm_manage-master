package com.qfedu.demo.service;

import com.qfedu.demo.entity.Building;
import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.House;
import com.qfedu.demo.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    HouseMapper houseMapper;

    public List<House> query(String houseName, String startTime, String endTime) {
        return houseMapper.query(houseName,startTime,endTime);
    }

    public Long queryCount(String houseName, String startTime, String endTime) {
        return houseMapper.queryCount(houseName,startTime,endTime);
    }

    public Integer insertHouse(House house) {
        return houseMapper.insertHouse(house);
    }

    public List<Community> queryCommunityInfo(Integer id) {
        return houseMapper.queryCommunityInfo(id);
    }

    public List<Building> queryBuildingInfo(Integer id) {
        return houseMapper.queryBuildingInfo(id);
    }

    public Boolean deleteHouseById(Integer id) {
        return houseMapper.deleteHouseById(id);
    }

    public Boolean deleteHouseByIds(String ids) {
        return houseMapper.deleteHouseByIds(ids);
    }

    public House queryById(Integer id) {
        return houseMapper.queryById(id);
    }

    public Boolean updateHouse(House house) {
        return houseMapper.updateHouse(house);
    }
}
