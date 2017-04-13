package com.learn.composite;

/**
 * leaf
 * Created by hechao on 2017/4/13.
 */
public class HRDepartment extends Company {
    public HRDepartment(String name) {
        super(name);
    }

    public void add(Company company) {

    }

    public void remove(Company company) {

    }

    public void display(int depth) {
        System.out.println("-");
        for (int i = 0; i < depth-1 ;i++)
            System.out.print("-");
        System.out.print(name);
    }

    public void lineOfDuty() {
        System.out.println(name + " 员工招聘培训管理");
    }
}
