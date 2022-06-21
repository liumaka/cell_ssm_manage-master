package com.qfedu.demo.service;

import com.qfedu.demo.entity.Community;
import com.qfedu.demo.mapper.CommunityMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {
    @Autowired
    CommunityMapper communityMapper;

    public Long selectCount() {
        return communityMapper.selectCount();
    }

    public List<Community> queryAllByLimit() {
        return communityMapper.queryAllByLimit();
    }

    public Community queryById(Integer id) {
        return communityMapper.queryById(id);
    }

    public Boolean updateCommunity(Community community) {
        return communityMapper.updateCommunity(community);
    }

    public Boolean deleteById(Integer id) {

        return communityMapper.deleteById(id);
    }

    public List<Community> queryByName(String name, String startTime, String endTime) {
        return communityMapper.queryByName(name, startTime, endTime);
    }

    public Long queryByNameCount(String name, String startTime, String endTime) {
        return communityMapper.queryByNameCount(name, startTime, endTime);
    }

    public Integer insertInfo(Community community) {
        return communityMapper.insert(community);
    }

    public Boolean deleteCommunityByIds(String ids) {
        return communityMapper.deleteCommunityByIds(ids);
    }

}
