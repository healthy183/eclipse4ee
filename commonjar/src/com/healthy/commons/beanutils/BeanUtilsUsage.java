package com.healthy.commons.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import com.healthy.commons.mybean.Addresss;
import com.healthy.commons.mybean.Customers;

public class BeanUtilsUsage {

	
	public  void demoNormalJavaBeans() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		
		Addresss addr1 = new Addresss("CA1234", "xxx", "Los Angeles", "USA");
        Addresss addr2 = new Addresss("100000", "xxx", "Beijing", "China");
        Addresss[] addrs = new Addresss[2];
        addrs[0] = addr1;
        addrs[1] = addr2;
        Customers cust = new Customers(123, "John Smith", addrs);

        String cityPattern = "addresses[0].city";
        String name = (String) PropertyUtils.getSimpleProperty(cust, "name");
        String city = (String) PropertyUtils.getProperty(cust, cityPattern);
        Object[] rawOutput1 = new Object[] { "The city of customer ", name,
                "'s first address is ", city, "." };
        
        System.out.println(StringUtils.join(rawOutput1));
        
        String zipPattern = "addresses[1].zipCode";
        if (PropertyUtils.isWriteable(cust, zipPattern)) {
            System.out.println("Setting zipcode ...");
            PropertyUtils.setProperty(cust, zipPattern, "200000");
        }
        String zip = (String) PropertyUtils.getProperty(cust, zipPattern);
        Object[] rawOutput2 = new Object[] { "The zipcode of customer ", name,
                "'s second address is now ", zip, "." };
        System.out.println(StringUtils.join(rawOutput2));
	}
	
	public void demoDynaBeans() throws IllegalAccessException, InstantiationException{
		
		  DynaProperty[] dynaBeanProperties = new DynaProperty[] {
	                new DynaProperty("name", String.class), 
	                new DynaProperty("inPrice", Double.class),  
	                new DynaProperty("outPrice", Double.class), 
	        };

		  BasicDynaClass cargoClass = new BasicDynaClass
				  ("Cargo", BasicDynaBean.class, dynaBeanProperties);
		  
		  DynaBean cargo = cargoClass.newInstance();
		  
		  cargo.set("name", "Instant Noodles");
          cargo.set("inPrice", new Double(21.3));
          cargo.set("outPrice", new Double(23.8));
          System.out.println("name: " + cargo.get("name"));
          System.out.println("inPrice: " + cargo.get("inPrice"));
          System.out.println("outPrice: " + cargo.get("outPrice"));
	}
	
	public void mapToBean(){
		
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("id", 1);
		maps.put("name", "try");
		
		Customers customers = new Customers();
		
		try {
			BeanUtils.populate(customers,maps);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(customers.getName());
	}
	
	
	public static void main(String[] args) throws Exception {
		BeanUtilsUsage beanUtilsUsage = new BeanUtilsUsage();
		//beanUtilsUsage.demoNormalJavaBeans();
		//beanUtilsUsage.demoDynaBeans();
		beanUtilsUsage.mapToBean();
	}

}
