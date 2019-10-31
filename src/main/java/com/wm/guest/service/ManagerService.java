package com.wm.guest.service;


import com.wm.guest.entity.Email;
import com.wm.guest.entity.Manager;
import com.wm.guest.entity.User;

import java.util.List;

public interface ManagerService {
    int updateSenderEmail(String email);
    int updateReceiverEmail(String email);
    boolean login(Manager manager);

    List<User> getAllGuest();

    List<User> selectGuestByName(String name);

    List<Email> getEmails();

}
