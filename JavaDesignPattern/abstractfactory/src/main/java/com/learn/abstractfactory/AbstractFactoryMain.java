package com.learn.abstractfactory;

import com.learn.abstractfactory.departmentTableOperation.IDepartment;
import com.learn.abstractfactory.factory.AccessFactory;
import com.learn.abstractfactory.factory.IFactory;
import com.learn.abstractfactory.table.Department;
import com.learn.abstractfactory.table.User;
import com.learn.abstractfactory.userTableOperation.IUser;

/**
 * Created by hechao on 2017/3/19.
 */
public class AbstractFactoryMain {
    public static void main(String arg[]) {

        User user = new User();
        Department department = new Department();

        IFactory factory = new AccessFactory();
        IUser iUser = factory.CreateUser();
        // 在access数据库中添加user一条记录
        iUser.insertUser(user);
        iUser.getUser(0);

        IDepartment iDepartment = factory.CreateDepartmet();

        iDepartment.insertDepartment(department);
        iDepartment.getDepartment(0);
    }
}
