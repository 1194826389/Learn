package com.learn.abstractfactory.userTableOperation;

import com.learn.abstractfactory.table.User;

/**
 * Created by hechao on 2017/3/19.
 */
public class AccessUser extends IUser {
    public void insertUser(User user) {
        System.out.print("在SQL Server中给User表增加一条记录\n");
    }

    public User getUser(int id) {
        System.out.print("在SQL Server中获取User表一条记录\n");
        return null;
    }
}
