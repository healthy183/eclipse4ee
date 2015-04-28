package com.springjdbc.dbcp.update;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.apache.bcel.generic.Type;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.CallableStatementCreatorFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

public class TestQuery {

	private	JdbcTemplate jdbcTemplate = null;
	private ApplicationContext app = null;
	
	public TestQuery(){
		app = new ClassPathXmlApplicationContext("com/springjdbc/dbcp/update/springJDBC.xml");
		jdbcTemplate = (JdbcTemplate)app.getBean("jdbcTemplate");
	}
	
	public void queryOne(){
		
		String sql = "select t.userName,t.usrPwd from t_user as t where t.userId = ?";
		final Tuser user = new Tuser();
		
		Integer usrId = 4;
		jdbcTemplate.query(sql,new Object[]{usrId},new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				//user.setUserName(rs.getString("userName"));
				//user.setUserPwd(rs.getString("usrPwd"));
				user.setUserName(rs.getString(1));
				user.setUserPwd(rs.getString(2));
			}
			
		});
		
		System.out.println(user.getUserName()+" "+user.getUserPwd());
	}
	
	public void queryForList(){
		
		String sql = "select t.userName,t.usrPwd from t_user as t where t.userId between ? and ?";
		
		final List<Tuser> usrList = new ArrayList<Tuser>();
		//普通查询
		/*jdbcTemplate.query(sql,new Object[]{9,11},new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Tuser user = new Tuser();
				user.setUserName(rs.getString(1));
				user.setUserPwd(rs.getString(2));
				usrList.add(user);
			}
			
		});*/
		//绑定参数类型，更加安全
		 Object[] obj = new Object[]{9,11};
		 int[] intArray = new int[]{Types.INTEGER,Types.INTEGER};
		 
		jdbcTemplate.query(sql,obj,intArray,new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Tuser user = new Tuser();
				user.setUserName(rs.getString(1));
				user.setUserPwd(rs.getString(2));
				usrList.add(user);
			}
			
		});
		
		for(Tuser usr : usrList){
			System.out.println(usr.getUserName()+" "+usr.getUserPwd());
		}
	}
	
	
	public void queryForInt(){
		
		String sql = "select count(*) from t_user";
		int count  = jdbcTemplate.queryForInt(sql);
		System.out.println(count);
	}
	
	
	public void queryForObjectByRowMapping(){
		
		String sql = "select t.userName,t.usrPwd from t_user as t where t.userId = ?";
		//final Tuser user = new Tuser();
		Integer usrId = 4;
		Tuser usr = jdbcTemplate.queryForObject(sql, new Object[]{usrId},new RowMapper<Tuser>(){

			@Override
			public Tuser mapRow(ResultSet rs, int index) throws SQLException {
				Tuser returnUsr = new Tuser();
				returnUsr.setUserName(rs.getString(1));
				returnUsr.setUserPwd(rs.getString(2));
				return returnUsr;
			}
			
		});
		
		System.out.println(usr.getUserName()+" "+usr.getUserPwd());
	}
	
	public void queryProc(){
		
		String sql ="{call springProc(?,?,?)}";
		
		Tuser returnUser = jdbcTemplate.execute(sql,new CallableStatementCallback<Tuser>(){

			@Override
			public Tuser doInCallableStatement(CallableStatement cs)
					throws SQLException, DataAccessException {
				
				cs.setInt(1,10);
				cs.setString(2,"bb");
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.execute();
				
				Tuser user = new Tuser();
				user.setUserName("bb");
				user.setUserPwd(cs.getString(3));
				return user;
			}
			
		});
		
		System.out.println(returnUser.getUserName()+" "+returnUser.getUserPwd() );
	}
	
	public void queryProc2(){
		
		String sql ="{call springProc(?,?,?)}";
		CallableStatementCreatorFactory fac = new CallableStatementCreatorFactory(sql);
		fac.addParameter(new SqlParameter("userId",Types.INTEGER));
		fac.addParameter(new SqlParameter("userName",Types.VARCHAR));
		fac.addParameter(new SqlOutParameter("usrPwd",Types.VARCHAR));
		
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("userId",10);
		paramsMap.put("userName","bb");
		
		CallableStatementCreator csc = fac.newCallableStatementCreator(paramsMap);
		
		Tuser returnTuser =	jdbcTemplate.execute(csc, new CallableStatementCallback<Tuser>() {

			@Override
			public Tuser doInCallableStatement(
					CallableStatement cs) throws SQLException,
					DataAccessException {
					
				cs.execute();
				
				Tuser user = new Tuser();
				user.setUserName("bb");
				user.setUserPwd(cs.getString(3));
				
				return user;
			}
			
		});
		
		System.out.println(returnTuser.getUserName()+" "+returnTuser.getUserPwd() );
	}
	
	
	public static void main(String[] args) {
		
		 TestQuery t = new  TestQuery();
		 //t.queryOne();
		//t.queryForList();
		//t.queryForInt();
		//t.queryForObjectByRowMapping();
		// t.queryProc();
		 t.queryProc2();
	}

}
