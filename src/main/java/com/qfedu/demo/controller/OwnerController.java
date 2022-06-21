package com.qfedu.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.demo.entity.*;
import com.qfedu.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Controller
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    private String imgString = null;
    private String imgUrl = null;

    @GetMapping("/personnel_list")
    public String buildinglist(String ownerName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Owner> owner = ownerService.query(ownerName, startTime, endTime);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("ownerName",ownerName);
        PageInfo<Owner> pageInfo = new PageInfo<>(owner);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = ownerService.queryCount(ownerName, startTime, endTime);
        model.addAttribute("ownerList", owner);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "personnel_list";
    }

    @GetMapping("/personnel_add")
    public String personnel_add(Model model) {
        List<Community> communityInfo = ownerService.queryCommunityInfo(null);
        List<House> houseInfo = ownerService.queryHouseInfo(null);
        model.addAttribute("communityInfo", communityInfo);
        model.addAttribute("houseInfo", houseInfo);
        return "personnel_add";
    }

    @PostMapping("/personnelInsert")
    @ResponseBody
    public RespBean insertBuilding(Owner owner) {
        owner.setCreateTime(new Date());
        owner.setPicture(imgString);
        Integer result = ownerService.insertHouse(owner);
        System.out.println("owner = " + owner);
        RespBean respBean = null;
        if (result == 1) {
            respBean = RespBean.ok("添加成功");
        } else {
            respBean = RespBean.error("添加失败");
        }
        return respBean;
    }

    @GetMapping("/personnel_edit")
    public String personnel_edit(Model model, Integer id) {
        Owner ownerInfo = ownerService.queryById(id);
        List<Community> CommunityInfo = ownerService.queryCommunityInfo(null);
        List<House> houseInfo = ownerService.queryHouseInfo(null);
        model.addAttribute("communityInfo", CommunityInfo);
        model.addAttribute("houseInfo", houseInfo);
        model.addAttribute("ownerInfo", ownerInfo);
        return "personnel_edit";
    }

    @PostMapping("/personnelUpdate")
    @ResponseBody
    public RespBean houseUpdate(Owner owner) {
        RespBean respBean = null;
        owner.setPicture(imgString);
        Boolean result = ownerService.updateOwner(owner);
        if (result) {
            respBean = RespBean.ok("更新成功");
        } else {
            respBean = RespBean.error("更新失败");
        }
        return respBean;
    }

    @DeleteMapping("/deletePersonnelById/{id}")
    @ResponseBody
    public RespBean deleteOwnerById(@PathVariable("id") Integer id) {
        Boolean result = ownerService.deleteOwnerById(id);
        RespBean respBean = null;
        if (result) {
            respBean = RespBean.ok("删除成功");
        } else {
            respBean = RespBean.error("删除失败");
        }
        return respBean;
    }

    @DeleteMapping("/deletePersonnelByIds/{ids}")
    @ResponseBody
    //PathVariable路径参数
    public RespBean deletePersonnelByIds(@PathVariable("ids") String ids) {
        Boolean result = ownerService.deleteOwnerByIds(ids);
        RespBean respBean = null;
        if (result) {
            respBean = RespBean.ok("删除成功");
        } else {
            respBean = RespBean.error("删除失败");
        }
        return respBean;
    }

    @PostMapping("/ownerImgInsert")
    @ResponseBody
    public Map<String, String> fileupload(MultipartFile img, HttpServletRequest req) {
        Map<String, String> result = new HashMap<>();
        String oldName = img.getOriginalFilename();
        String realPath = req.getServletContext().getRealPath("/images");
        System.out.println("realPath = " + realPath);
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            img.transferTo(new File(folder, newName));
            String tomcatUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/images/" + newName;
            System.out.println("url = " + tomcatUrl);
            result.put("status", "200");
            result.put("newName", newName);
            imgString = newName;
            result.put("url", tomcatUrl);
            imgUrl = tomcatUrl;
            System.out.println("url = " + tomcatUrl);
        } catch (IOException e) {
            result.put("status", "500");
            result.put("msg", e.getMessage());
        }
        return result;
    }
//    @RequestMapping("/testImgUrl1")
//    public void testImgUrl(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        //FileInputStream fis = null;
//        InputStream fis = null;
//        OutputStream os = null;
//        URL url = null;
//        HttpURLConnection httpUrl = null;
//        try {
//            url = new URL(imgUrl);//远程图片地址
//            System.out.println("url = " + url);
//            httpUrl = (HttpURLConnection) url.openConnection();
//            System.out.println("httpUrl = " + httpUrl);
//            httpUrl.connect();
//            System.out.println("httpUrl = " + httpUrl);
//            //fis = new FileInputStream("d:/img/test.jpg");//本地图片地址
//            fis = httpUrl.getInputStream();
//            os = response.getOutputStream();
//            int count = 0;
//            byte[] buffer = new byte[1024 * 8];
//            while ((count = fis.read(buffer)) != -1) {
//                os.write(buffer, 0, count);
//                os.flush();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fis.close();
//                os.close();
//                httpUrl.disconnect();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
