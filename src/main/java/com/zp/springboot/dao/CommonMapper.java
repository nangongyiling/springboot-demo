package com.zp.springboot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zp.springboot.bean.ConsultConfigArea;
import com.zp.springboot.bean.ConsultContent;
import com.zp.springboot.bean.ConsultContract;
import com.zp.springboot.bean.ConsultIdCardInfo;
import com.zp.springboot.bean.ConsultRecord;
import com.zp.springboot.bean.ConsultRecordCount;

public interface CommonMapper {

	int saveArea(ConsultConfigArea area);
	
	int deleteArea(Map param);
	
	int deleteAll();
	
	int updateArea(ConsultConfigArea area);
	
	List<ConsultConfigArea> queryAreaByAreaCode(Map param);
	
	List<ConsultRecord> queryConsultRecords(Map param);
	
	List<Map> queryUserBuPsptId(Map param);
	
	int saveUser(ConsultIdCardInfo record);
	
	int saveRecord(ConsultRecord record);
	
	int saveRecordCount(ConsultRecordCount recordCount);
	
	List<ConsultRecord> queryRecords(Map param);
	
	List<ConsultRecord> queryRecordshaveH(Map param);
	
	//@Select("select * from consult_content where type=#{type}")
	//@Select({"<script>","select * from consult_content a where a.status=0",
	//		"order by a.itemindex","</script>"})
	List<ConsultContent> queryContent(Map param);
	
	int updateRecords(Map param);
	
	int updateRecordsByPsptId(Map param);
	
	List<ConsultRecordCount> queryRecordCount(Map param);
	
	int updateRecordCount(Map param);
	
	List<ConsultConfigArea> qryArea(Map param);
	
	List<ConsultContract> qryContracts(Map param);
	
	int saveContracts(List<ConsultContract> contracts);
	
	int updateConsultRecord(Map param);
}
