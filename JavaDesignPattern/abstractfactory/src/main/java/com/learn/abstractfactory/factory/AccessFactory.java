package com.learn.abstractfactory.factory;

import com.learn.abstractfactory.departmentTableOperation.AccessDepartment;
import com.learn.abstractfactory.departmentTableOperation.IDepartment;
import com.learn.abstractfactory.userTableOperation.AccessUser;
import com.learn.abstractfactory.userTableOperation.IUser;

/**
 * Created by hechao on 2017/3/19.
 */
public class AccessFactory extends IFactory {
    public IUser CreateUser() {
        return new AccessUser();
    }

    public IDepartment CreateDepartmet() {
        return new AccessDepartment();
    }
}
