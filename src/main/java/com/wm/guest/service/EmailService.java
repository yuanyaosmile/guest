package com.wm.guest.service;

import com.wm.guest.entity.User;

public interface EmailService {
    void sendEmail(User user);
}
