package com.wm.guest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name="user")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String guest;
    private String visited;
    private String phone;
    private String company;
    private String car;
    private String purpose;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
}
