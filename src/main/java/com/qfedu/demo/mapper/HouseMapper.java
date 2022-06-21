package com.qfedu.demo.mapper;

import com.qfedu.demo.entity.Building;
import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {
    List<House> query(@Param("name") String houseName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Long queryCount(@Param("name") String houseName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Integer insertHouse(House house);

    List<Community> queryCommunityInfo(Integer cid);

    List<Building> queryBuildingInfo(Integer bid);

    Boolean deleteHouseById(Integer id);

    Boolean deleteHouseByIds(String ids);

    House queryById(Integer id);

    Boolean updateHouse(House house);
}
