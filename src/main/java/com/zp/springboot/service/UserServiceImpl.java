package com.zp.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.springboot.bean.User;
import com.zp.springboot.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserByName(String username) {
		List<User> users = userMapper.findByUserName(username);
		return users.size()>0?users.get(0):null;
	}
}
