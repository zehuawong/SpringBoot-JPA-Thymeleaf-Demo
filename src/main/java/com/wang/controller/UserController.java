package com.wang.controller;

import com.wang.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wzh-zhua on 2018/10/1.
 */
@Controller
@RequestMapping("user")
public class UserController {

    //@RequestMapping(value = "/list", method = RequestMethod.GET)或者
    @GetMapping("list")
    public String listUser(Model model, @RequestParam(value = "id",required = false,defaultValue = "0") Integer id) {
        List<User> userList = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("username" + i + i);
            userList.add(user);
        }

        model.addAttribute("users", userList);
        model.addAttribute("id",id);

        return "user/list";
    }

 //    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
//    public String getUserID(@PathVariable("id") Integer id) {
//        return "id"+ id;
//    }


}
