package com.qfedu.demo.service;

import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.House;
import com.qfedu.demo.entity.Owner;
import com.qfedu.demo.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    OwnerMapper ownerMapper;

    public List<Owner> query(String ownerName, String startTime, String endTime) {
        return ownerMapper.query(ownerName,startTime,endTime);
    }

    public Long queryCount(String ownerName, String startTime, String endTime) {
        return ownerMapper.queryCount(ownerName,startTime,endTime);
    }

    public List<Community> queryCommunityInfo(Integer id) {
        return ownerMapper.queryCommunityInfo(id);
    }

    public List<House> queryHouseInfo(Integer id) {
        return ownerMapper.queryHouseInfo(id);
    }

    public Integer insertHouse(Owner owner) {
        return ownerMapper.insertOwner(owner);
    }

    public Owner queryById(Integer id) {
        return ownerMapper.queryById(id);
    }

    public Boolean updateOwner(Owner owner) {
        return ownerMapper.updateOwner(owner);
    }

    public Boolean deleteOwnerById(Integer id) {
        return ownerMapper.deleteOwnerById(id);
    }

    public Boolean deleteOwnerByIds(String ids) {
        return ownerMapper.deleteOwnerByIds(ids);
    }
}
