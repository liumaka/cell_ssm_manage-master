package com.qfedu.demo.service;

import com.qfedu.demo.entity.Owner;
import com.qfedu.demo.entity.Pet;
import com.qfedu.demo.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    PetMapper petMapper;
    public List<Pet> query(String petName, String startTime, String endTime) {
        return petMapper.query(petName,startTime,endTime);
    }

    public Long queryCount(String petName, String startTime, String endTime) {
        return petMapper.queryCount(petName,startTime,endTime);
    }

    public List<Owner> queryOwnerInfo(Integer id) {
        return petMapper.queryOwnerInfo(id);
    }

    public Integer insertPet(Pet pet) {
        return petMapper.insertPet(pet);
    }

    public Pet queryById(Integer id) {
        return petMapper.queryById(id);
    }

    public Boolean updatePet(Pet pet) {
        return petMapper.updatePet(pet);
    }

    public Boolean deletePetById(Integer id) {
        return petMapper.deletePetById(id);
    }

    public Boolean deletePetByIds(String ids) {
        return petMapper.deletePetByIds(ids);
    }
}
