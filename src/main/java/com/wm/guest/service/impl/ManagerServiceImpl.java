package com.wm.guest.service.impl;

import com.wm.guest.dao.EmailMapper;
import com.wm.guest.dao.GuestMapper;
import com.wm.guest.dao.ManagerMapper;
import com.wm.guest.entity.Email;
import com.wm.guest.entity.Manager;
import com.wm.guest.entity.User;
import com.wm.guest.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    GuestMapper guestMapper;

    @Autowired
    EmailMapper emailMapper;

    @Override
    public int updateSenderEmail(String email) {
        Email email1 = new Email();
        email1.setEmail(email);
        email1.setId((new Long(1)));
        email1.setType(1);
        return emailMapper.updateByPrimaryKey(email1);
    }

    @Override
    public int updateReceiverEmail(String email) {
        Email email1 = new Email();
        email1.setEmail(email);
        email1.setId((new Long(2)));
        email1.setType(2);
        return emailMapper.updateByPrimaryKey(email1);
    }

    @Override
    public boolean login(Manager managerLogin) {
        if(managerLogin.getName() == null || managerLogin.getPassword()== null){
            return false;
        }
        Manager manager = new Manager();
        manager.setName(managerLogin.getName());
        List<Manager> dbManagers = managerMapper.select(manager);
        String dbPasswd = dbManagers.get(0).getPassword();

        return managerLogin.getPassword().equals(dbPasswd)? true : false;
    }

    @Override
    public List<User> getAllGuest() {
        return guestMapper.selectAll();
    }

    @Override
    public List<User> selectGuestByName(String name) {
        User user = new User();
        user.setGuest(name);
        return guestMapper.select(user);
    }

    @Override
    public List<Email> getEmails() {
        return emailMapper.selectAll();
    }
}
