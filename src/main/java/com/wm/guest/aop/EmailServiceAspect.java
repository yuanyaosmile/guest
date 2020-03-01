package com.wm.guest.aop;

import com.wm.guest.dao.EmailMapper;
import com.wm.guest.entity.User;
import com.wm.guest.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class EmailServiceAspect {

    @Autowired
    EmailMapper emailMapper;



    @Pointcut("execution(public * com.wm.guest.web.GuestController.add(..))")
    public void sendEmail() {

    }

    @After("sendEmail()")
    public void after(JoinPoint joinPoint) {
       //Object[] args = joinPoint.getArgs();
        //User user = (User) args[0];
        //sendEmail(user);
    }


}
