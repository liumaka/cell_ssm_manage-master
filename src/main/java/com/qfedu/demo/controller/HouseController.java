package com.qfedu.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.demo.entity.Building;
import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.House;
import com.qfedu.demo.entity.RespBean;
import com.qfedu.demo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class HouseController {
    @Autowired
    HouseService houseService;

    @GetMapping("/homeadd")
    public String buildingadd(Model model) {
        List<Community> CommunityInfo = houseService.queryCommunityInfo(null);
        List<Building> buildingInfo = houseService.queryBuildingInfo(null);
        model.addAttribute("communityInfo", CommunityInfo);
        model.addAttribute("buildingInfo", buildingInfo);
        return "homeadd";
    }
    @GetMapping("/homeedit")
    public String buildingedit(Model model, Integer id) {
        House houseInfo = houseService.queryById(id);
        List<Community> CommunityInfo = houseService.queryCommunityInfo(null);
        List<Building> buildingInfo = houseService.queryBuildingInfo(null);
        model.addAttribute("communityInfo", CommunityInfo);
        model.addAttribute("buildingInfo", buildingInfo);
        model.addAttribute("houseInfo", houseInfo);
        return "homeedit";
    }
    @PostMapping("/houseUpdate")
    @ResponseBody
    public RespBean houseUpdate(House house) {
        RespBean respBean = null;
        Boolean result = houseService.updateHouse(house);
        if (result) {
            respBean = RespBean.ok("更新成功");
        } else {
            respBean = RespBean.error("更新失败");
        }
        return respBean;
    }

    @PostMapping("/houseInsert")
    @ResponseBody
    public RespBean insertBuilding(House house) {
//        house.setLiveTime(new Date());
//        house.setLiveTime();
        Integer result = houseService.insertHouse(house);
        System.out.println("house = " + house);
        RespBean respBean = null;
        if (result == 1) {
            respBean = RespBean.ok("添加成功");
        } else {
            respBean = RespBean.error("添加失败");
        }
        return respBean;
    }

    @RequestMapping("/homelist")
    public String buildinglist(String houseName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<House> house = houseService.query(houseName, startTime, endTime);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("houseName",houseName);
        PageInfo<House> pageInfo = new PageInfo<>(house);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = houseService.queryCount(houseName, startTime, endTime);
        model.addAttribute("houseList", house);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "homelist";
    }
    @DeleteMapping("/deleteHouseByIds/{ids}")
    @ResponseBody
    //PathVariable路径参数
    public RespBean deleteHouseByIds(@PathVariable("ids") String ids) {
        Boolean result = houseService.deleteHouseByIds(ids);
        RespBean respBean = null;
        if (result) {
            respBean = RespBean.ok("删除成功");
        } else {
            respBean = RespBean.error("删除失败");
        }
        return respBean;
    }
    @DeleteMapping("/deleteHouseById/{id}")
    @ResponseBody
    public RespBean deleteHouseById(@PathVariable("id") Integer id) {
        Boolean result = houseService.deleteHouseById(id);
        RespBean respBean = null;
        if (result) {
            respBean = RespBean.ok("删除成功");
        } else {
            respBean = RespBean.error("删除失败");
        }
        return respBean;
    }
}
