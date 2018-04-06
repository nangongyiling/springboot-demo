package com.zp.springboot.service;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.zp.springboot.bean.ConsultConfigArea;
import com.zp.springboot.bean.ConsultContent;
import com.zp.springboot.bean.ConsultContract;
import com.zp.springboot.bean.User;

@Service
@Profile("dev")
public class CommonServiceImplDev implements CommonService{

	@Override
	public List<ConsultContent> queryContent(Map map) {
		System.out.println("我是dev环境！");
		return null;
	}

	@Override
	public List<ConsultContract> queryConsultContract() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateConsultContract(String psptId, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ConsultConfigArea> qryArea(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveArea(ConsultConfigArea area) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveAreaToBase(ConsultConfigArea area) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ConsultConfigArea> qryAreaFromBase(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
