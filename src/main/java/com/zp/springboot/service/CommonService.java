package com.zp.springboot.service;

import java.util.List;
import java.util.Map;

import com.zp.springboot.bean.ConsultConfigArea;
import com.zp.springboot.bean.ConsultContent;
import com.zp.springboot.bean.ConsultContract;
import com.zp.springboot.bean.User;

public interface CommonService {

	List<ConsultContent> queryContent(Map map);
	
	List<ConsultContract> queryConsultContract();
	
	int updateConsultContract(String psptId,int id);
	
	public List<ConsultConfigArea> qryArea(Map param);
	
	int saveArea(ConsultConfigArea area);
	
	int saveAreaToBase(ConsultConfigArea area);
	
	public List<ConsultConfigArea> qryAreaFromBase(Map param);
	
	public User findUserByName(String username);
}
