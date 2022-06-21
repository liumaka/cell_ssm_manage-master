package com.qfedu.demo.mapper;

import com.qfedu.demo.entity.Building;
import com.qfedu.demo.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingMapper {
    List<Building> query(@Param("name") String name, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Long queryCount(@Param("name") String name, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Community> queryCommunityInfo(Integer cid);
    Integer insertBuilding(Building building);

    Building queryById(Integer id);

    Boolean updateBuilding(Building building);

    Boolean deleteById(Integer id);

    Boolean deleteCommunityByIds(String ids);
}
