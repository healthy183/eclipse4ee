package test.java.com.jasson.Test;

import java.util.Date;

import main.java.com.jasson.mode.GenderType;
import main.java.com.jasson.mode.Info;
import main.java.com.jasson.mode.User;
import main.java.com.jasson.mode.UserVO;

import org.dozer.Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"main/resources/applicationContext.xml");
		Mapper mapper = (Mapper) ctx.getBean("mapper");
		Info info = new Info();
		info.setCreateDate(new Date());
		info.setGender(GenderType.female);
		info.setId(100);
		
		User user = new User();
		user.setId(100);
		user.setName("jasson");
		user.setPassword("password");
		user.setInfo(info);
		user.setOption("NO");

		UserVO uservo = mapper.map(user, UserVO.class);
		//mapper.map
		
		System.out.println(user.getId()+"<------>"+uservo.getId());
		System.out.println(user.getPassword()+"<------>"+uservo.getPassword());
		System.out.println(user.getName()+"<------>"+uservo.getUserName());
		System.out.println(user.getInfo().getId()+"<------>"+uservo.getInfo().getId());
		System.out.println(user.getInfo().getGender()+"<------>"+uservo.getInfo().getGender());
		System.out.println(user.getInfo().getCreateDate()+"<------>"+uservo.getInfo().getDate());
		System.out.println(user.getOption()+"<------>"+uservo.getOption());
	}
}
