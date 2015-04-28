package com.kang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kang.model.SysRoles;

@Scope("prototype")
@Repository("roleDao")
public class RoleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//查询所有角色
	public List<SysRoles> findAllRoles() {
		String sql ="select * from sys_roles order by roleId";
		
		final List<SysRoles> roleList = new ArrayList<SysRoles>();
		
		jdbcTemplate.query(sql,new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				SysRoles role = new SysRoles();
				role.setRoleId(rs.getInt(1));
				role.setRoleName(rs.getString(2));
				role.setRoleUrl(rs.getString(3));
				roleList.add(role);
			}
		});
		return roleList;
	}

	
	
	public Integer save(final SysRoles newRole) {
		
		final String sql = "insert into sys_roles(roleName,roleUrl) values(?,?) ";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,newRole.getRoleName());
				ps.setString(2,newRole.getRoleUrl());
				return ps;
			}
		},keyHolder);
		
		return keyHolder.getKey().intValue();
	}
	
	
	
}
