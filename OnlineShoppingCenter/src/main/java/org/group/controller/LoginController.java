package org.group.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.group.dao.UserDaoImpl;
import org.group.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @Autowired
    private UserDaoImpl userService;
    private User user;


    @RequestMapping(value = {"/login","/login.html"}, method = RequestMethod.GET)
    protected String Glogin() {
        return "login";
    }

    @RequestMapping(value = {"/login","/login.html"}, method = RequestMethod.POST)
    protected String Plogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model)  {
        System.out.println("username"+ username);
        System.out.println("password"+password);
        userService.createTable();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String msg = "";

        if (userService.findByName("wujiayu") == null) {
            user  = new User("wujiayu","123456",1,"vip");
            userService.createUser(user);
       }

       System.out.println("msg1: "+ msg);

        try{
            subject.login(token);
        } catch (UnknownAccountException e) {
            msg = "wrong username";
            System.out.println("msg2: "+ msg);
            return "login";
        } catch (IncorrectCredentialsException e) {
            msg = "wrong password";
            System.out.println("msg3: "+ msg);
            return "login";
        } catch (AuthenticationException e) {
            msg = "other problems" + e.getMessage();
            System.out.println("msg4: "+ msg);
            return "index";
        }

        System.out.println("msg5: "+ msg);
        if (msg.equals("") != true) {
            model.addAttribute("msg", msg);
            return "login";
        } else {
            model.addAttribute("name", username);
            model.addAttribute("subject", subject);
            return "index";
        }
    }
}
