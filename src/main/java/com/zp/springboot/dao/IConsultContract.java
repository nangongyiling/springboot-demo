package com.zp.springboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zp.springboot.bean.ConsultContract;

public interface IConsultContract extends JpaRepository<ConsultContract, Integer>{

//	@Transactional
//	@Modifying
//	@Query(value="update ConsultContract a set a.psptId =:psptId where a.contractId=:id")
//	int updateConsultContract(@Param("psptId") String psptId,@Param("id") int id);
//	
//	
//	@Query("from ConsultContract")
//	List<ConsultContract> queryConsultContract();
}
