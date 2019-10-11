package com.wm.guest.entity;

import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
@Data
@Table(name="user")
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String username;
    private String phone;
    private String car;
}
