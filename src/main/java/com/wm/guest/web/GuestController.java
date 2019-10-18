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
        return user.getGuest();
    }

    @PostMapping("/add")
    public String insert(@RequestBody User user){
        int i = guestService.addEvent(user);
        return "welcome";
    }
}
