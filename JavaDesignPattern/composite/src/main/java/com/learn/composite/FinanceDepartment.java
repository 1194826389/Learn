package com.learn.composite;

/**
 * leaf
 * Created by hechao on 2017/4/13.
 */
public class FinanceDepartment extends Company {
    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    public void display(int depth) {
        System.out.println("-");
        for (int i = 0; i < depth-1 ;i++)
            System.out.print("-");
        System.out.print(name);
    }

    public void lineOfDuty() {
        System.out.println(name + " 公司财务收支管理");
    }
}
