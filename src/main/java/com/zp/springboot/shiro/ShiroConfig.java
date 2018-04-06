package com.zp.springboot.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro配置加载类
 * @author guitai
 *
 */
//@Configuration
public class ShiroConfig {

	private static Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
	
	@Bean
	public ZpShiroRealm getShiroRealm(){
		return new ZpShiroRealm();
	}
	
	@Bean(name="shiroEhcahceManager")
	public EhCacheManager getEhCacheManager(){
		EhCacheManager em  = new EhCacheManager();
		em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return em;
	}
	
	@Bean(name="lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
	}
	
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(){
		DefaultWebSecurityManager dm = new DefaultWebSecurityManager();
		dm.setRealm(getShiroRealm());
		dm.setCacheManager(getEhCacheManager());
		return dm;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(){
		AuthorizationAttributeSourceAdvisor a = new AuthorizationAttributeSourceAdvisor();
		a.setSecurityManager(getDefaultWebSecurityManager());
		return a;
	}
	
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(getDefaultWebSecurityManager());
		bean.setLoginUrl("/login");
		bean.setSuccessUrl("/sa/index");
		filterChainDefinitionMap.put("/sa/**", "authc");
		filterChainDefinitionMap.put("/**", "anon");
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return bean;
	}
}
