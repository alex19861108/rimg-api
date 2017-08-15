package com.rimg.controller;

import com.google.gson.Gson;
import com.rimg.component.Coder;
import com.rimg.entity.mysql.User;
import com.rimg.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 2017/7/12.
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController{
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    private Gson gson = new Gson();
    
    @RequestMapping(value = "/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password) {
        logger.info(userName);
        logger.info(password);
        return gson.toJson(userName);
    }
    
    @RequestMapping(value = "/list_all")
    public String listAll() {
        List<User> users = userService.findAll();
        return gson.toJson(users);
    }
    
    @ResponseBody
    @RequestMapping(value = "/new")
    public String newUser(@RequestBody User user) {
        String encryptPasswd = "";
        try {
            encryptPasswd = Coder.encryptBASE64(user.getPasswd().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            encryptPasswd = user.getPasswd();
        }
        user.setPasswd(encryptPasswd);
        user = userService.save(user);
        return gson.toJson(user);
    }
}
