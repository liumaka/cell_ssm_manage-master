package com.qfedu.demo.service;

import com.qfedu.demo.entity.Building;
import com.qfedu.demo.entity.Community;
import com.qfedu.demo.mapper.BuildingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    BuildingMapper buildingMapper;
    public List<Building> query(String buildingName, String startTime, String endTime) {
        return buildingMapper.query(buildingName,startTime,endTime);
    }

    public Long queryCount(String buildingName, String startTime, String endTime) {
        return buildingMapper.queryCount(buildingName,startTime,endTime);
    }

    public List<Community> queryCommunityInfo(Integer cid) {
        return buildingMapper.queryCommunityInfo(cid);
    }

    public Integer insertBuilding(Building building) {
        return buildingMapper.insertBuilding(building);
    }

    public Building queryById(Integer id) {
        return buildingMapper.queryById(id);
    }

    public Boolean updateBuilding(Building building) {
        return buildingMapper.updateBuilding(building);
    }

    public Boolean deleteById(Integer id) {
        return buildingMapper.deleteById(id);
    }

    public Boolean deleteCommunityByIds(String ids) {
        return buildingMapper.deleteCommunityByIds(ids);
    }
}
