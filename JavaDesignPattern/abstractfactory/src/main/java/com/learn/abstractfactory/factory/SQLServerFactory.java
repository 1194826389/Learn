package com.learn.abstractfactory.factory;

import com.learn.abstractfactory.departmentTableOperation.IDepartment;
import com.learn.abstractfactory.departmentTableOperation.SQLServerDepartment;
import com.learn.abstractfactory.userTableOperation.IUser;
import com.learn.abstractfactory.userTableOperation.SQLServerUser;

/**
 * Created by hechao on 2017/3/19.
 */
public class SQLServerFactory extends IFactory {
    // 创建User表实例
    public IUser CreateUser() {
        return new SQLServerUser();
    }
    // 创建Department表实例
    public IDepartment CreateDepartmet() {
        return new SQLServerDepartment();
    }
}
