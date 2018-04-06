package com.zp.springboot.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CredentialsMatcher extends SimpleCredentialsMatcher{

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken utoken = (UsernamePasswordToken)token;
		//获得用户输入的密码
		String inPassword = new String (utoken.getPassword());
		//获得数据库的密码
		String dbPassword = (String)info.getCredentials();
		return this.equals(inPassword,dbPassword);
	}

	
}
