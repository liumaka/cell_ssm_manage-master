package com.qfedu.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.demo.entity.Building;
import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.RespBean;
import com.qfedu.demo.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class BuildingController {
    @Autowired
    BuildingService buildingService;

    @GetMapping("/buildingadd")
    public String buildingadd(Model model) {
        List<Community> CommunityInfo = buildingService.queryCommunityInfo(null);
        model.addAttribute("communityInfo", CommunityInfo);
        return "buildingadd";
    }

    @GetMapping("/buildingedit")
    public String buildingedit(Model model, Integer id) {
        Building building = buildingService.queryById(id);

        List<Community> CommunityInfo = buildingService.queryCommunityInfo(null);
        model.addAttribute("communityInfo", CommunityInfo);
        model.addAttribute("buildingInfo", building);
        return "buildingedit";
    }

    @PostMapping("/buildingUpdate")
    @ResponseBody
    public RespBean buildingedit(Building building) {
        RespBean respBean = null;
        Boolean result = buildingService.updateBuilding(building);
        if (result) {
            respBean = RespBean.ok("更新成功");
        } else {
            respBean = RespBean.error("更新失败");
        }
        return respBean;
    }

    @PostMapping("/buildingInsert")
    @ResponseBody
    public RespBean insertBuilding(Building building) {
        building.setBuildHiredate(new Date());
        Integer result = buildingService.insertBuilding(building);
        RespBean respBean = null;
        if (result == 1) {
            respBean = RespBean.ok("添加成功");
        } else {
            respBean = RespBean.error("添加失败");
        }
        return respBean;

    }

    @RequestMapping("/buildinglst")
    public String buildinglist(String buildingName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Building> building = buildingService.query(buildingName, startTime, endTime);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("buildingName",buildingName);
        PageInfo<Building> pageInfo = new PageInfo<>(building);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = buildingService.queryCount(buildingName, startTime, endTime);
        model.addAttribute("buildinglist", building);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "buildinglst";
    }
    @DeleteMapping("/deleteBuildingById/{id}")
    @ResponseBody
    public RespBean deleteCommunityById(@PathVariable("id") Integer id) {
        Boolean result = buildingService.deleteById(id);
        RespBean respBean = null;
        if (result) {
            respBean = RespBean.ok("删除成功");
        } else {
            respBean = RespBean.error("删除失败");
        }
        return respBean;
    }
    @DeleteMapping("/deleteBuildingByIds/{ids}")
    @ResponseBody
    //PathVariable路径参数
    public RespBean deleteCommunityByIds(@PathVariable("ids") String ids) {
        Boolean result = buildingService.deleteCommunityByIds(ids);
        RespBean respBean = null;
        if (result) {
            respBean = RespBean.ok("删除成功");
        } else {
            respBean = RespBean.error("删除失败");
        }
        return respBean;
    }
}
