package com.wm.guest.service.impl;

import com.wm.guest.dao.GuestMapper;
import com.wm.guest.entity.User;
import com.wm.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestMapper guestMapper;

    @Override
    public User getUser(Long id) {
        return guestMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addEvent(User user) {
        return guestMapper.insert(user);
    }
}
