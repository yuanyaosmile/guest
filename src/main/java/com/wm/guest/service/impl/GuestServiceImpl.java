package com.wm.guest.service.impl;

import com.wm.guest.dao.EmailMapper;
import com.wm.guest.dao.GuestMapper;
import com.wm.guest.entity.User;
import com.wm.guest.service.EmailService;
import com.wm.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestMapper guestMapper;


    @Autowired
    EmailMapper emailMapper;

    @Autowired
    EmailService emailService;

    @Override
    public User getUser(Long id) {
        return guestMapper.selectByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int addGuest(User user) {
        List<User> users = guestMapper.select(user);
        if (users.size() > 0){
            return -1;
        }
        int insertResult = guestMapper.insert(user);
        emailService.sendEmail(user);
        if (insertResult != 1) {
            return 0;
        }
        return 1;
    }


    @Override
    public List<User> getUsers(String name) {
        User user = new User();
        user.setGuest(name);
        List<User> users = guestMapper.select(user);
        users.forEach(user1 -> System.out.println(user1.toString()));
        return null;
    }
}
