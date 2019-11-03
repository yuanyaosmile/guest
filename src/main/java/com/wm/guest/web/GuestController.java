package com.wm.guest.web;

import com.wm.guest.entity.User;
import com.wm.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public ResponseEntity<Void> add(@RequestBody User user){
        int i = guestService.addGuest(user);
        if (i == 1)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.status(500).build();
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(String name){
        return ResponseEntity.ok(guestService.getUsers(name));
    }
}
