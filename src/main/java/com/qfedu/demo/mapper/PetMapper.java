package com.qfedu.demo.mapper;

import com.qfedu.demo.entity.Owner;
import com.qfedu.demo.entity.Pet;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PetMapper {

    List<Pet> query(@Param("name") String petName, @Param("startTime") String startTime, @Param("endTime") String endTime);
    Long queryCount(@Param("name") String petName, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Owner> queryOwnerInfo(Integer oid);


    Integer insertPet(Pet pet);

    Pet queryById(Integer id);

    Boolean updatePet(Pet pet);

    Boolean deletePetById(Integer id);

    Boolean deletePetByIds(String ids);
}
