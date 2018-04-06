package com.zp.springboot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=2)
public class StartUp2 implements CommandLineRunner{

	public void run(String...args){
		System.out.println(this.getClass().getName() +"启动加载数据"+args);
	}
}
