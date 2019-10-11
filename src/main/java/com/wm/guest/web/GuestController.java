package com.wm.guest.web;

import com.wm.guest.entity.User;
import com.wm.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuestController {

    @Autowired
    GuestService guestService;

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable("id")long id){
        System.out.println(id);
        User user = guestService.getUser(id);
        return user.getUsername();
    }

    @PostMapping("/event/add")
    public String insert(@RequestBody User user){
        System.out.println(user.getUsername());
        user.setUsername("laowang");
        user.setCar("12345");
        user.setPhone("12345678901");
        int i = guestService.addEvent(user);
        return "welocme";
    }
}
