package com.wm.guest.entity;

import org.junit.Test;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EntityTest {
    @Test
    public void test(){
        Date date = new Date();
        Instant instant = date.toInstant();

    }

    @Test
    public void testTime(){
        Date date =new Date();
        System.out.println(date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant instant = date.toInstant();
        ZoneId zoneId1 = ZoneId.systemDefault();
        LocalDateTime ldt = instant.atZone(zoneId1).toLocalDateTime();
        String format = dtf.format(ldt);
        System.out.println(dtf.format(ldt));

    }
}
