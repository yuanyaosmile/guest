package com.wm.guest.service;

import com.wm.guest.entity.User;

public interface GuestService {
    User getUser(Long id);

    int addEvent(User user);
}
