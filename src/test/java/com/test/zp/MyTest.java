package com.test.zp;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zp.springboot.bean.ConsultConfigArea;
import com.zp.springboot.SpringBootTest;
import com.zp.springboot.dao.CommonMapper;
import com.zp.springboot.dao.IConsultContract;
import com.zp.springboot.service.CommonService;
import com.zp.springboot.service.RedisService;
import com.zp.springboot.service.UserService;


//SpringJuint支持，由此引入Spring-Test框架支持
@RunWith(SpringJUnit4ClassRunner.class)
//指定我们SpringBoot工程的Application启动类
@SpringApplicationConfiguration(classes = SpringBootTest.class)
//由于是Web项目，JUint需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class MyTest {

	private static final Logger logger = LoggerFactory.getLogger(MyTest.class);
	
	@Autowired
	private CommonMapper mapper;
	
	@Autowired
	private IConsultContract iConsultContract;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private RedisService redisService;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test1(){
		System.out.println(mapper.queryContent(new HashMap()));
	}
	
	@Test
	public void test2(){
		System.out.println(iConsultContract);
		System.out.println(iConsultContract.findAll());
	}
	
	@Test
	public void test3(){
		ConsultConfigArea area = new ConsultConfigArea();
		area.setAreaCode("dsVIP");
		area.setAreaName("dsName");
		area.setState(0);
		System.out.println(commonService.saveArea(area));
	}
	
	@Test
	public void test4(){
		List<ConsultConfigArea> areas =commonService.qryArea(new HashMap());
		for(ConsultConfigArea area:areas){
			logger.info(area.toString());
			System.out.println(area);
		}
	}
	
	@Test
	public void test5(){
		List<ConsultConfigArea> areas= commonService.qryAreaFromBase(new HashMap());
		for(ConsultConfigArea area:areas){
			logger.info(area.toString());
			System.out.println(area);
		}
	}
	
	 @Test
    public void test6() {
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("HHVIP");
        area.setAreaName("basenameVIP");
        area.setState(0);
        //        PageHelper.startPage(1, 1);
        System.out.println(commonService.saveAreaToBase(area));
    }
	 
	@Test
	public void test7(){
		redisService.cacheObject("zp要缓存的数据");
	}
	
	@Test
	public void test8(){
		if(redisService.findByKey("zp")!=null){
			logger.info(redisService.findByKey("zp").toString());
		}
	}
	
	@Test
	public void test9(){
		System.out.println(userService.findUserByName("xxxx"));
	}
}
