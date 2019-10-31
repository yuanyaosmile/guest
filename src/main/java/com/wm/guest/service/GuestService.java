package com.wm.guest.service;

import com.wm.guest.entity.User;

import java.util.List;

public interface GuestService {
    User getUser(Long id);

    int addEvent(User user);

    List<User> getUsers(String name);
}
