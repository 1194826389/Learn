package com.learn.abstractfactory.userTableOperation;

import com.learn.abstractfactory.table.User;

/**
 * Created by hechao on 2017/3/19.
 */
public class SQLServerUser extends IUser {
    public void insertUser(User user) {
        System.out.print("在SQL Server中给Department表增加一条记录");
    }

    public User getUser(int id) {
        System.out.print("在SQL Server中给Department表增加一条记录");
        return null;
    }
}
