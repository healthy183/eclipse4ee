package com.kang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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

import com.kang.model.SysUsers;

@Scope("prototype")
@Repository("userDao")
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public SysUsers lgn(String usrNameVal, String usrPwdVal) {
		
		String sql ="select * from sys_users where usrname = ? and usrpwd = ?";
		
		final SysUsers user = new SysUsers();
		Object[] objArray = new Object[]{usrNameVal,usrPwdVal};
		int[] intArray = new int[]{Types.VARCHAR,Types.VARCHAR};
		
		jdbcTemplate.query(sql, objArray,intArray,new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				user.setUsrid(rs.getInt(1));
				user.setUsrname(rs.getString(2));
				user.setUsrpwd(rs.getString(3));
				user.setUsrtype(rs.getInt(4));
				user.setUsrmgr(rs.getInt(5));
			}
		});
		return user.getUsrid()!= null?user:null;
	}


	public List<SysUsers> findAllLead() {
		
		String sql ="select * from sys_users where usrtype = 0 order by usrid";
		
		final List<SysUsers> userList = new ArrayList<SysUsers>();
		
		jdbcTemplate.query(sql,new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				SysUsers user = new SysUsers();
				user.setUsrid(rs.getInt(1));
				user.setUsrname(rs.getString(2));
				user.setUsrpwd(rs.getString(3));
				user.setUsrtype(rs.getInt(4));
				user.setUsrmgr(rs.getInt(5));
				userList.add(user);
			}
			
		});
		return userList;
	}


	public Integer save(final SysUsers newUser) {
		
		final String sql = "insert into sys_users(usrname,usrpwd,usrtype,usrmgr) values(?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		
		jdbcTemplate.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1,newUser.getUsrname());
				ps.setString(2,newUser.getUsrpwd());
				ps.setInt(3,newUser.getUsrtype());
				if(newUser.getUsrmgr()!= null){
					ps.setInt(4,newUser.getUsrmgr());
				}else{///setInt(4,null);
					ps.setString(4,null);
				}
				return ps;
			}
		},keyHolder);
		return keyHolder.getKey().intValue();
	}


	public List<SysUsers> findAllButMe(Integer usrid) {
		
		String sql ="select s.*,c.usrname from sys_users as s " +
			"left join sys_users as c on s.usrmgr = c.usrid " +
				"where s.usrid != ? order by usrid";
		
		final List<SysUsers> userList = new ArrayList<SysUsers>();
		
		 Object[] obj = new Object[]{usrid};
		 int[] intArray = new int[]{Types.INTEGER};
		 
		jdbcTemplate.query(sql,obj,intArray,new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				SysUsers user = new SysUsers();
				user.setUsrid(rs.getInt(1));
				user.setUsrname(rs.getString(2));
				user.setUsrpwd(rs.getString(3));
				user.setUsrtype(rs.getInt(4));
				user.setUsrmgr(rs.getInt(5));
				user.setLeanderName(rs.getString(6));
				userList.add(user);
			}
			
		});
		return userList;
	}


	public void delUsr(Integer userId) {
		
		String sql ="delete from usr_role_link where usrid = ?";
		Object[] objArray = new Object[]{userId};
		int[] intArray = new int[]{Types.INTEGER};
		jdbcTemplate.update(sql,objArray,intArray);
		
		sql ="delete from sys_users where usrid = ?";
		jdbcTemplate.update(sql,objArray,intArray);
	}
	
}
