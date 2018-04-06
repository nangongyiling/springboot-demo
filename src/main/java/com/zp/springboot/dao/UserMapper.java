package com.zp.springboot.dao;

import java.util.List;

import com.zp.springboot.bean.User;

public interface UserMapper {

	List<User> findByUserName(String username);
}
