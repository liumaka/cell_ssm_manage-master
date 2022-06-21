package com.qfedu.demo;

import com.qfedu.demo.entity.Building;
import com.qfedu.demo.entity.House;
import com.qfedu.demo.entity.User;
import com.qfedu.demo.mapper.BuildingMapper;
import com.qfedu.demo.mapper.HouseMapper;
import com.qfedu.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestDemo {

    private SqlSession sqlSession;
    private BuildingMapper buildingMapper;
private HouseMapper houseMapper;
    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        buildingMapper = sqlSession.getMapper(BuildingMapper.class);
        houseMapper=sqlSession.getMapper(HouseMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void test03() {
        User admin = userMapper.loadUser("admin");
        User lisi = userMapper.loadUser("lisi");
        System.out.println("lisi = " + lisi);
        System.out.println("admin = " + admin);
    }
    @Test
    public void test01() {
        List<Building> query = buildingMapper.query(null,null,null);
        query.forEach(System.out::println);
    }

    @Test
    public void test02() {
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        List<House> query = houseMapper.query(null,null,null);
        query.forEach(System.out::println);

    }
    @After
    public void after(){
        sqlSession.close();
    }
}
