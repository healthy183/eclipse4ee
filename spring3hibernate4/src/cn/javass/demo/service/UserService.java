package cn.javass.demo.service;

import cn.javass.common.pagination.Page;
import cn.javass.common.service.IBaseService;
import cn.javass.demo.model.UserModel;
import cn.javass.demo.model.UserQueryModel;

/*UserModel的特有Service接口*/
public interface UserService extends IBaseService<UserModel, Integer> {

    Page<UserModel> query(int pn, int pageSize, UserQueryModel command);
}
