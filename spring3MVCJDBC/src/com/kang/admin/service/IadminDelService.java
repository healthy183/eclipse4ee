package com.kang.admin.service;

import java.util.List;

import com.kang.model.SysUsers;

public interface IadminDelService {

	List<SysUsers> findAllButMe(Integer usrid);

	void delUsr(String usrid);

}
