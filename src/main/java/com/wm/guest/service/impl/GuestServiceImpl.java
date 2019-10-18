package com.wm.guest.service.impl;

import com.wm.guest.dao.GuestMapper;
import com.wm.guest.entity.User;
import com.wm.guest.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestMapper guestMapper;

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public User getUser(Long id) {
        return guestMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addEvent(User user) {
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        mainMessage.setFrom("15261852099@163.com");
        //mainMessage.setTo("kingming0526@hotmail.com");
        mainMessage.setTo("15261852099@163.com");
        mainMessage.setSubject("客户拜访登记");
        String context = "供应商名称： "+user.getCompany() + "\n 姓名：" + user.getGuest() + "\n 车牌：" + user.getCar() +
                "\n 拜访时间： " +user.getStartTime() + "\n 缘由："+ user.getPurpose()+ "\n 接待人："+user.getVisited()+ "\n" ;
        mainMessage.setText(context);
        javaMailSender.send(mainMessage);
        return guestMapper.insert(user);
    }
}
