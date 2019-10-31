package com.wm.guest.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "manager")
public class Manager {

    @Id
    private Long id;

    private String name;
    private String password;
}
