package com.learn.abstractfactory.factory;

import com.learn.abstractfactory.departmentTableOperation.IDepartment;
import com.learn.abstractfactory.userTableOperation.IUser;

/**
 * Created by hechao on 2017/3/19.
 */
public abstract class IFactory {
    public abstract IUser CreateUser();
    public abstract IDepartment CreateDepartmet();
}
