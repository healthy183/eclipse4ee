package com.kang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kang.model.SysRoles;

public interface SysRolesDAO {

	public SysRoles findwithOneToMany(int roleId);
	
	/* 传参方法1
	public SysRoles findByProperty
		(@Param("roleId") int roleId,
			@Param("roleName") String roleName);
	*/
	/*传参方法2*/
	public SysRoles findByProperty(Map<String,Object> map);
	
	public SysRoles selectIf(Map<String,Object> map);
	
	public SysRoles selectChoose(Map<String,Object> map);
	
	public List<SysRoles> selectForeach(List<Integer> intList);
	
	public List<SysRoles> selectin(Map<String,Object> map);

	
	//为什么不行?
	public SysRoles findByPropertySecond(int roleId,String roleName);
}
