package com.kang.main.service;

import com.kang.model.MyUsr;
import com.kang.service.IbaseService;

public interface ImainService extends IbaseService<MyUsr, Integer>  {

	MyUsr lgn(MyUsr webUsr);

}
