package com.zp.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zp.springboot.bean.Account;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public interface AccountDao  extends JpaRepository<Account,Integer> {
}
