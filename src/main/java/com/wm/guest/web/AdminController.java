package com.wm.guest.web;

import com.wm.guest.entity.Email;
import com.wm.guest.entity.Manager;
import com.wm.guest.entity.User;
import com.wm.guest.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    ManagerService managerService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> auth(@RequestBody Manager manager){
        boolean login = managerService.login(manager);
        if (login)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.status(401).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllGuest(){
        return ResponseEntity.ok(managerService.getAllGuest());
    }

    @GetMapping("/name")
    public ResponseEntity<List<User>> selectGuestByName(@RequestParam String name){
        System.out.println("---test--name----" + name);
        return ResponseEntity.ok(managerService.selectGuestByName(name));
    }

    @GetMapping("/getEmails")
    public ResponseEntity<List<Email>> getSetting(){
        return ResponseEntity.ok(managerService.getEmails());
    }

    @PostMapping("/updateSender")
    public ResponseEntity<Void> updateSender(@RequestParam String name){
        int i = managerService.updateSenderEmail(name);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateReceiver")
    public ResponseEntity<Void> updateReceiver(@RequestParam String name){
        int i = managerService.updateReceiverEmail(name);
        return ResponseEntity.ok().build();
    }
}
