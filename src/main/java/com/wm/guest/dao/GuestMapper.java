package com.wm.guest.dao;

import com.wm.guest.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
//@org.apache.ibatis.annotations.Mapper
public interface GuestMapper extends Mapper<User> {

}
