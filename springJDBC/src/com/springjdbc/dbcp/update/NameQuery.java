package com.springjdbc.dbcp.update;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class NameQuery {

	private	NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
	private ApplicationContext app = null;
	
	public NameQuery(){
		app = new ClassPathXmlApplicationContext("com/springjdbc/dbcp/update/springJDBC.xml");
		namedParameterJdbcTemplate = (NamedParameterJdbcTemplate)app.getBean("namedParameterJdbcTemplate");
	}
	
	public void queryOne(){
		String sql = "select t.userName,t.usrPwd from t_user as t where t.userId = :userId";
		
		Tuser  t = new Tuser();
		t.setUserId(10);
		//javaBean的属性必须和数据库字段名称一致
		SqlParameterSource sps = new BeanPropertySqlParameterSource(t);
		
		final Tuser user = new Tuser();
		
		namedParameterJdbcTemplate.query(sql, sps, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				user.setUserName(rs.getString(1));
				user.setUserPwd(rs.getString(2));
			}
			
		});
		
		System.out.println(user.getUserName()+" "+user.getUserPwd());
	}
	
	public void updateOne(){
		
		String sql ="insert into t_user(userName,usrPwd) values(:userName,:usrPwd)";
		
		MapSqlParameterSource mps = new MapSqlParameterSource()
				.addValue("userName","插入").addValue("usrPwd","成功");
		
		namedParameterJdbcTemplate.update(sql, mps);
		
	}
	
	public static void main(String[] args) {
		
		NameQuery query = new NameQuery();
		//query.queryOne();
		query.updateOne();
	}

}
