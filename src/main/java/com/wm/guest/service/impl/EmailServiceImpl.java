package com.wm.guest.service.impl;

import com.wm.guest.dao.EmailMapper;
import com.wm.guest.entity.User;
import com.wm.guest.service.EmailService;
import com.wm.guest.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailMapper emailMapper;
    @Autowired
    JavaMailSender javaMailSender;

     public void sendEmail(User user) {
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        String senderEmail = emailMapper.selectByPrimaryKey(1).getEmail();
        String receiverEmail = emailMapper.selectByPrimaryKey(2).getEmail();
        mainMessage.setFrom(senderEmail);
        mainMessage.setTo(receiverEmail);
        mainMessage.setSubject("客户拜访登记");
        String context = "供应商名称： " + user.getCompany() + "\n 姓名：" + user.getGuest() + "\n 车牌：" + user.getCar() +
                "\n 拜访时间： " + DateUtils.customDateFormate(user.getStartTime()) + "  ---- " + DateUtils.customDateFormate(user.getEndTime())
                + "\n 缘由：" + user.getPurpose() + "\n 接待人：" + user.getVisited() + "\n";
        mainMessage.setText(context);
        javaMailSender.send(mainMessage);
    }
}
