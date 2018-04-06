package com.zp.springboot.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.springboot.bean.ConsultConfigArea;
import com.zp.springboot.bean.ConsultContent;
import com.zp.springboot.bean.ConsultContract;
import com.zp.springboot.bean.User;
import com.zp.springboot.dao.CommonMapper;
import com.zp.springboot.dao.IConsultContract;
import com.zp.springboot.dao.UserMapper;
import com.zp.springboot.dynamicDataSource.TargetDataSource;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IConsultContract iConsultContract;
	
	@Autowired
	private CommonMapper mapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<ConsultContent> queryContent(Map map) {
		String sql = "select * from consult_content a where a.state=0 and a.type=1 order by a.itemIndex";
		return jdbcTemplate.query(sql, new RowMapper<ConsultContent>(){
			
			public ConsultContent mapRow(ResultSet rs,int rowNum) throws SQLException{
				ConsultContent cc = new ConsultContent();
				cc.setContent(rs.getString("content"));
				cc.setId(rs.getInt("id"));
				cc.setItemIndex(rs.getInt("itemIndex"));
				cc.setState(rs.getInt("state"));
				cc.setType(rs.getString("type"));
				return cc;
			}
		});
			
	}

	@Override
	public List<ConsultContract> queryConsultContract() {
		return iConsultContract.findAll();
	}

	@Override
	public int updateConsultContract(String psptId, int id) {
		return 0;//iConsultContract.updateConsultContract(psptId, id);
	}

	@Transactional
	@TargetDataSource(name="ds2")
	public int saveArea(ConsultConfigArea area){
		int count = mapper.saveArea(area);
		return count;
	}
	
	@TargetDataSource(name="ds1")
	public List<ConsultConfigArea> qryArea(Map param){
		return mapper.qryArea(param);
	}
	@TargetDataSource(name="ds1")
	public int saveAreaToBase(ConsultConfigArea area){
		return mapper.saveArea(area);
	}
	
	public List<ConsultConfigArea> qryAreaFromBase(Map param){
		return mapper.qryArea(param);
	}
	
	@TargetDataSource(name="ds1")
	public User findUserByName(String username){
		List<User> users = userMapper.findByUserName(username);
		return users.size() > 0 ?users.get(0):null;
	}
}
