package com.learn.prototype.deepcopy;

/**
 * Created by hechao on 2017/3/25.
 */
public class WorkExperienceB implements Cloneable {
    private String workDate;
    private String company;

    public WorkExperienceB(){
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
