package com.qfedu.demo.controller;


import com.qfedu.demo.entity.RespBean;
import com.qfedu.demo.entity.User;
import com.qfedu.demo.service.UserService;
import com.qfedu.demo.tools.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    UserService userService;


    @RequestMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("loginName");
        User u = userService.queryByLoginName(user.getUsername());
        model.addAttribute("user", u);
        return "index";
    }


    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


    @PostMapping("/dologin")
    public String dologin(String username, String password, Model model, HttpSession httpSession, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = userService.loadUser(username, password);
        if (!checkVcode(req)) {
            //验证码校验没有通过
            model.addAttribute("errorCode", "验证码输入错误！");
            return "forward:/";
        }
        if (user == null) {
            model.addAttribute("error", "用户名或密码输入错误，登录失败");
            return "forward:/";
        } else if (!user.getAvailable()) {
            model.addAttribute("error", "该账户不可用，请联系管理员");
            return "forward:/";
        } else {
            httpSession.setAttribute("loginName", user);
            return "redirect:/index";
        }
    }

    @GetMapping("/vcode")
    public void vcode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //这个请求是来获取验证码的
        VerificationCode verificationCode = new VerificationCode();
        //获取图片对象
        BufferedImage image = verificationCode.getImage();
        //获取验证码的文本
        String text = verificationCode.getText();
        req.getSession().setAttribute("vcode", text);
        System.out.println("后端发送的验证码 = " + text);
        //将图片写出到前端
        VerificationCode.output(image, resp.getOutputStream());
    }

    private boolean checkVcode(HttpServletRequest req) {
        //获取用户输入的验证码
        String vcode = req.getParameter("vcode");
        System.out.println("用户输入的验证码 = " + vcode);
        //获取服务端保存的验证码
        String session_code = (String) req.getSession().getAttribute("vcode");
        System.out.println("服务端保存的验证码 = " + session_code);
        if (vcode != null && session_code != null && vcode.equalsIgnoreCase(session_code)) {
            //验证码没问题
            return true;
        }
        return false;
    }


    @GetMapping("/logout")
    public String logout(HttpSession HttpSession) {
        HttpSession.removeAttribute("loginName");
        return "redirect:/";
    }

}
