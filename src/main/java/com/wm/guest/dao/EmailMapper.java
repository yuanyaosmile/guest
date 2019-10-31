package com.wm.guest.dao;

import com.wm.guest.entity.Email;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface EmailMapper extends Mapper<Email> {
}
