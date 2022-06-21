package com.qfedu.demo.controller;

import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.RespBean;
import com.qfedu.demo.entity.User;
import com.qfedu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2021-10-20 19:23:38
 */
@Controller
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;
    private String imgString = null;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/one_set")
    public String oneSet(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("loginName");
        User u = userService.queryByLoginName(user.getUsername());
        model.addAttribute("user", u);
        return "one_set";
    }

    @PostMapping("/userUpdate")
    @ResponseBody
    public RespBean update(User user) {
        user.setImg(imgString);
        Boolean result =userService.update(user);
        if (result){
            return  RespBean.ok("更新成功");
        }else {
            return RespBean.error("更新失败");
        }
    }

    @PostMapping("/userInsert")
    public String add(User user, Model model) {
        Integer result = userService.insert(user);
        if (result == -1) {
            model.addAttribute("error", "用户名重复，注册失败");
            model.addAttribute("user", user);
            return "forward:/register";
        } else {
            model.addAttribute("ok", "注册成功，请登录");
            return "forward:/login";
        }
    }

    @PostMapping("/userImgInsert")
    @ResponseBody
    public Map<String, String> fileupload(MultipartFile images, HttpServletRequest req, Model model) {
        Map<String, String> result = new HashMap<>();
        String oldName = images.getOriginalFilename();
        String realPath = req.getServletContext().getRealPath("/images");
        System.out.println("realPath = " + realPath);

        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        try {
            images.transferTo(new File(folder, newName));
            String tomcatUrl = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath() + "/images/" + newName;
            result.put("status", "200");
            result.put("newName", newName);
            result.put("url", tomcatUrl);
            imgString = newName;
            System.out.println("url = " + tomcatUrl);
        } catch (IOException e) {
            result.put("status", "500");
            result.put("msg", e.getMessage());
        }
        return result;
    }

}

