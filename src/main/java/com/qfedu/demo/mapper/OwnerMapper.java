package com.qfedu.demo.mapper;

import com.qfedu.demo.entity.Building;
import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.House;
import com.qfedu.demo.entity.Owner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OwnerMapper {
    List<Owner> query(@Param("name") String ownerName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Long queryCount(@Param("name") String ownerName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Integer insertOwner(Owner owner);

    List<Community> queryCommunityInfo(Integer cid);

    List<House> queryHouseInfo(Integer hid);

    Boolean deleteOwnerById(Integer id);

    Boolean deleteOwnerByIds(String ids);

    Owner queryById(Integer id);

    Boolean updateOwner(Owner owner);
}
