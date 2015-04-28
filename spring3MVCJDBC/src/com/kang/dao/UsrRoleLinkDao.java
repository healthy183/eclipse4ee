package com.kang.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kang.model.UsrRoleLink;


@Scope("prototype")
@Repository("usrRoleLinkDao")
public class UsrRoleLinkDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveAll(final List<UsrRoleLink> linkList) {
		
		String sql = "insert into usr_role_link(usrid,roleid) values(?,?)";
		
		jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter(){

			@Override
			public int getBatchSize() {
				return linkList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int index)
					throws SQLException {
				
				UsrRoleLink usrRoleLink = linkList.get(index);
				ps.setInt(1,usrRoleLink.getUsrid());
				ps.setInt(2,usrRoleLink.getRoleid());
			}
		});
	}
	
	
	
	
}
