package com.learn.abstractfactory.userTableOperation;

import com.learn.abstractfactory.table.User;

/**
 * Created by hechao on 2017/3/19.
 */
public abstract class IUser {
    abstract public void insertUser(User user);
    abstract public User getUser(int id);
}
