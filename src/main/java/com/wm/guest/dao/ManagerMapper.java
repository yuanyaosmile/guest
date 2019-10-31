package com.wm.guest.dao;

import com.wm.guest.entity.Manager;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ManagerMapper extends Mapper<Manager> {
}
