package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.apache.commons.lang.StringUtils;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

import static org.thymeleaf.util.StringUtils.isEmpty;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        // 去到登录页
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

 // && "123456".equals(user.getPassword())
        if (! StringUtils.isEmpty(user.getUserName())) {
            session.setAttribute("loginUser", user);
            return "redirect:/index.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }


//        return "index";
    }

    @GetMapping("/index.html")
    public String mainPage(HttpSession session, Model model) {

        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "index";
        } else {
            model.addAttribute("msg", "请重新登陆");
            return "login";
        }

//        return "login";
    }
}
