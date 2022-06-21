package com.qfedu.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.RespBean;
import com.qfedu.demo.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * (DbCommunity)表控制层
 *
 * @author makejava
 * @since 2021-10-20 20:38:50
 */
@Controller
@MultipartConfig
public class CommunityController {

    @Autowired
    private CommunityService communityService;
    private String imgString = null;
    private String imgUrl = null;

    @GetMapping("/communityadd")
    public String communityadd() {
        return "communityadd";
    }

    @RequestMapping("/communityupdate")
    public String communityupdate(Integer id, Model model) {
        Community community = communityService.queryById(id);
        model.addAttribute("comm", community);
        return "communityupdate";
    }

//    @RequestMapping("/communitylist")
//    public String queryAllByLimit(Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
//        //查询all
//        System.out.println("pageNum----" + pageNum);
//        PageHelper.startPage(pageNum, 7);//curr:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
//        List<Community> communities = communityService.queryAllByLimit();//list:页面要展示的数据的集合
//        PageInfo<Community> pageInfo = new PageInfo<>(communities);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
//        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
//        model.addAttribute("commList", communities);
//        Long count = communityService.selectCount();
//        model.addAttribute("count", count);
//        return "communitylist";
//    }

    @RequestMapping("/communitylist")
    public String queryByName(String communityName, String startTime, String endTime, Model model, @RequestParam(defaultValue = "1") Integer pageNum) {
        //查询单个或多个
        PageHelper.startPage(pageNum, 6);//pageNum:当前页码数，第一次进来时默认为1（首页）每页显示pagesize条
        List<Community> community = communityService.queryByName(communityName, startTime, endTime);
        model.addAttribute("startTime",startTime);
        model.addAttribute("endTime",endTime);
        model.addAttribute("communityName",communityName);
        PageInfo<Community> pageInfo = new PageInfo<>(community);//pageInfo:将分页数据和显示的数据封装到PageInfo当中
        Long count = communityService.queryByNameCount(communityName, startTime, endTime);
        System.out.println("list = " + community);
        model.addAttribute("commList", community);
        model.addAttribute("count", count);
        model.addAttribute("pageInfo", pageInfo);//将封装好的数据返回到前台页面
        return "communitylist";
    }



    @RequestMapping("/communityInsert")
    @ResponseBody
    public RespBean add(Community community) {
        Date date = new Date();
        community.setHiredate(date);
        System.out.println("imgString = " + imgString);
        community.setImg(imgString);
        Integer result = communityService.insertInfo(community);
        RespBean respBean = null;
        if (result == 1) {
            respBean = RespBean.ok("添加成功");
        } else {
            respBean = RespBean.error("添加失败");
        }
        return respBean;
    }


    @PostMapping("/updateCommunity")
    @ResponseBody
    public RespBean updateCommunity(Community community) {
        community.setImg(imgString);
        System.out.println("community.toString() = " + community.toString());
        Boolean result = communityService.updateCommunity(community);
        RespBean respBean = null;
        if (result) {
            respBean = RespBean.ok("修改成功");
        } else {
            respBean = RespBean.error("修改失败");
        }
        return respBean;
    }

    @DeleteMapping("/deleteCommunityByIds/{ids}")
    @ResponseBody
    //PathVariable路径参数
    public RespBean deleteCommunityByIds(@PathVariable("ids") String ids) {
        Boolean result = communityService.deleteCommunityByIds(ids);
        RespBean respBean = null;
        if (result) {
            respBean = RespBean.ok("删除成功");
        } else {
            respBean = RespBean.error("删除失败");
        }
        return respBean;
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseBody
    public RespBean deleteCommunityById(@PathVariable("id") Integer id) {
        Boolean result = communityService.deleteById(id);
        RespBean respBean = null;
        if (result) {
            respBean = RespBean.ok("删除成功");
        } else {
            respBean = RespBean.error("删除失败");
        }
        return respBean;
    }

    @PostMapping("/communityImgInsert")
    @ResponseBody
    public Map<String, String> fileupload(MultipartFile img, HttpServletRequest req, Model model) {
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

//    @RequestMapping("/testImgUrl")
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

