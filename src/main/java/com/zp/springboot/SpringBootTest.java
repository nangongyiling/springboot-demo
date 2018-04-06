package com.zp.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zp.springboot.dynamicDataSource.DynamicDataSourceRegister;
import com.zp.springboot.servlet.ZpServlet;

/**
 * springboot启动器
 * @author guitai
 *
 */
/*
 * @SpringBootApplication 相当于@Configuration,@EnableAutoConfiguration,@ComponentSacn
 */
@SpringBootApplication(scanBasePackages={"com.zp.springboot"},exclude={})
//扫描工程中的Servlet，Filter，Listener
@ServletComponentScan(basePackages={"com.zp.springboot"})
//mybatis框架中的dao扫描
@MapperScan("com.zp.springboot.dao")
//注册动态多数据源
@Import({DynamicDataSourceRegister.class})
//启动注解事物管理，等同于xml配置方式的<tx:annotation-driven />
@EnableTransactionManagement

/**
 * SpringBootServletInitializer 继承它的目的是为了打war
 * @author guitai
 *
 */
public class SpringBootTest extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest.class, args);
	}
	
	/**
	 * 这里是通过代码的形式注册一个Servlet，这种形式不需要@ServletComponentscan注解
	 */
	
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new ZpServlet(),"/zp/*");
	}
	
	
}
