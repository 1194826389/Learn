package com.learn.abstractfactory.departmentTableOperation;

import com.learn.abstractfactory.table.Department;

/**
 * Created by hechao on 2017/3/19.
 */
public class AccessDepartment extends IDepartment {
    public void insertDepartment(Department department) {
        System.out.print("在Access中给Department表增加一条记录\n");
    }

    public Department getDepartment(int id) {
        System.out.print("在Access中给Department表增加一条记录\n");
        return null;
    }
}
