package com.zp.springboot.service;

import com.zp.springboot.bean.User;

public interface UserService {

	User findUserByName(String username);
}
