package com.zp.springboot.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.github.pagehelper.PageHelper;
import com.zp.springboot.interceptor.DjInterceptor;
import com.zp.springboot.interceptor.ZpInterceptor;

@Configuration
public class SpringInterceptorRegister extends WebMvcConfigurerAdapter{

	private static final Logger logger = LoggerFactory.getLogger(SpringInterceptorRegister.class);
	/*
	 * 添加spring中的拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ZpInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new DjInterceptor())
                .addPathPatterns("/freemarker/**");
        super.addInterceptors(registry);
	}

	/**
	 * 注册静态文件的自定义映射路径
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 、image/**  这个是url请求路径
		// classpath:/image 去这个路径下寻找静态文件
		registry.addResourceHandler("/image/**")
        .addResourceLocations("classpath:/image/");
		registry.addResourceHandler("/picture/**")
        .addResourceLocations("file:D:/picture/");
		super.addResourceHandlers(registry);
	}
	
	/**
	 * 注册分页插件
	 * @return
	 */
//	@Bean
//	public PageHelper pageHelper(){
//		logger.info("注册Mybatis分页插件PageHelper");
//		PageHelper pageHelper = new PageHelper();
//		Properties p = new Properties();
//		p.setProperty("offsetAsPageNum", "true");
//		p.setProperty("rowBoundsWithCount", "true");
//		p.setProperty("reasonable", "true");
//		pageHelper.setProperties(p);
//		return pageHelper;
//	}
	

}
