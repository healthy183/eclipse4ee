package com.springjdbc.dbcp.update;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class TestUpdate {

	private	JdbcTemplate jdbcTemplate = null;
	private ApplicationContext app = null;
	
	public TestUpdate(){
		app = new ClassPathXmlApplicationContext("com/springjdbc/dbcp/update/springJDBC.xml");
		jdbcTemplate = (JdbcTemplate)app.getBean("jdbcTemplate");
	}
	
	//jdbcTemplate的execute()一般用于ddl语句(增删改表等sql语句)
	public void createTable(){
		
		String sql ="create table t_user(" +
				" userId int IDENTITY(1,1) not null primary key,userName varchar(40),usrPwd varchar(40))";
		jdbcTemplate.execute(sql);
	}
	
	public void insertInto(){
		String sql ="insert into t_user(userName) values('梁健康')";
		jdbcTemplate.update(sql);
	}
	
	public void insertIntoWithParam(){
		String sql ="insert into t_user(userName) values(?)";
		jdbcTemplate.update(sql,"梁伟雄");
	}
	
	public void insertIntoWithObjectArray(){
		String sql ="insert into t_user(userName,usrPwd) values(?,?)";
		Object[] params = new Object[]{"梁健康","123"}; 
		jdbcTemplate.update(sql,params);
	}
	
	public void insertIntoWithObjectArrayAndType(){
		String sql ="insert into t_user(userName,usrPwd) values(?,?)";
		Object[] params = new Object[]{"梁伟雄","123"}; 
		int[] intArray = new int[]{Types.VARCHAR,Types.VARCHAR}; 
		jdbcTemplate.update(sql,params,intArray);
	}
	
	public void insertIntoWithFun(){
	  final	Tuser user = new Tuser();
	  user.setUserName("abc");
	  user.setUserPwd("123");
	  
	  final String sql ="insert into t_user(userName,usrPwd) values(?,?)";
	  //回调函数调用的对象一定要final的
	  jdbcTemplate.update(new PreparedStatementCreator() {
		
		@Override
		public PreparedStatement createPreparedStatement(Connection connection)
				throws SQLException {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getUserPwd());
			return ps;
		}
	});
	  
}
	/**Exception in thread "main" org.springframework.jdbc.UncategorizedSQLException: 
		PreparedStatementCallback; uncategorized SQLException for SQL []; 
			SQL state [null]; error code [0]; 必须执行该语句才能获得结果。;
			nested exception is com.microsoft.sqlserver.jdbc.SQLServerException: 必须执行该语句才能获得结果
	**/
	public void getKeyValue(){
		  final	Tuser user = new Tuser();
		  user.setUserName("aa");
		  user.setUserPwd("123");
		  
		  final String sql ="insert into t_user(userName,usrPwd) values(?,?)";
		  
		  KeyHolder keyHolder = new GeneratedKeyHolder();
		  
		  jdbcTemplate.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				
				PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,user.getUserName());
				ps.setString(2,user.getUserPwd());
				return ps;
			}
		  },keyHolder);
		  System.out.println(keyHolder.getKey().intValue());
		  //user.setUserId();
		 // System.out.println("usrId:"+user.getUserId());
	}
	
	public void addBathSize(){
		
		final List<Tuser> usrList = new ArrayList<Tuser>();
		  Tuser user = new Tuser();
		  user.setUserName("bb");
		  user.setUserPwd("123");
		  usrList.add(user);
		  
		  user = new Tuser();
		  user.setUserName("cc");
		  user.setUserPwd("123");
		  usrList.add(user);
		  
		  final String sql = "insert into t_user(userName,usrPwd) values(?,?)";
		  
		  jdbcTemplate.batchUpdate(sql,new BatchPreparedStatementSetter(){

			@Override
			public int getBatchSize() {
				return usrList.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int index)
					throws SQLException {
					
				Tuser addUser = usrList.get(index);
				ps.setString(1,addUser.getUserName());
				ps.setString(2,addUser.getUserPwd());
			}
	});
		  
	}
	
	
	
	public static void main(String[] args) {
		
		TestUpdate t = new TestUpdate();
		//t.createTable();
		//t.insertInto();
		//t.insertIntoWithParam();
		//t.insertIntoWithObjectArray();
		//t.insertIntoWithObjectArrayAndType();
		//t.insertIntoWithFun();
		//t.getKeyValue();
		t.addBathSize();
	}

}
