package com.zp.springboot.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class StartUp1 implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(this.getClass().getName() +"启动加载数据"+arg0);
	}

}
