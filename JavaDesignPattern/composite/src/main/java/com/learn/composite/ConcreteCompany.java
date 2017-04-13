package com.learn.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * composite(Subsidiary)
 * Created by hechao on 2017/4/13.
 */
public class ConcreteCompany extends Company{

    private List<Company> children = new ArrayList<Company>();

    public ConcreteCompany(String name) {
        super(name);
    }

    public void add(Company company) {
        children.add(company);
    }

    public void remove(Company company) {
        children.remove(company);
    }

    public void display(int depth) {

        System.out.println("-");
        for (int i = 0; i < depth-1 ;i++)
            System.out.print("-");
        System.out.print(name);

        for (Company c:children) {
            c.display(depth + 2);
        }
    }

    public void lineOfDuty() {
        for (Company c : children) {
            c.lineOfDuty();
        }
    }
}
