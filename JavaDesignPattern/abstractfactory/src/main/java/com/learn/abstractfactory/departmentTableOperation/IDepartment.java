package com.learn.abstractfactory.departmentTableOperation;

import com.learn.abstractfactory.table.Department;

/**
 * Created by hechao on 2017/3/19.
 */
public abstract class IDepartment {
    abstract public void insertDepartment(Department department);
    abstract public Department getDepartment(int id);
}
