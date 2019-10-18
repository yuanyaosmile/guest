package com.wm.guest.entity;

import org.junit.Test;

import java.time.Instant;
import java.util.Date;

public class EntityTest {
    @Test
    public void test(){
        Date date = new Date();
        Instant instant = date.toInstant();

    }
}
