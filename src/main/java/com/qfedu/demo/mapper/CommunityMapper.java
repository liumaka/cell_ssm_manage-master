package com.qfedu.demo.mapper;

import com.qfedu.demo.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommunityMapper {
    Integer insert(Community community);

    List<Community> queryAllByLimit();

    Long selectCount();

    Community queryById(Integer id);

    List<Community> queryByName(@Param("name") String name, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Boolean updateCommunity(Community community);

    Long queryByNameCount(@Param("name") String name, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Boolean deleteCommunityByIds(String ids);

    Boolean deleteById(Integer id);
}
