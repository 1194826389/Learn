package com.learn.prototype.shallowcopy;

/**
 * Created by hechao on 2017/3/25.
 */
public class Resume implements Cloneable{
    private String name;
    private String sex;
    private String age;

    private WorkExperience workExperience;

    public Resume(String name){
        this.name = name;
        this.workExperience = new WorkExperience();
    }

    // 设置个人信息
    public void setPersonalInfo(String sex,String age) {
        this.sex = sex;
        this.age = age;
    }

    // 设置工作经历
    public void setWorkExperience(String workDate,String company) {
        this.workExperience.setWorkDate(workDate);
        this.workExperience.setCompany(company);
    }

    public void display() {
        System.out.print("Resume.hashCode == " +  this.hashCode()+ "\n");
        System.out.print("workExperience.hashCode == " +  workExperience.hashCode() + "\n");
        System.out.print(name + " " + sex + " " + age + "\n");
        System.out.print("工作经历: " + workExperience.getWorkDate() + " " + workExperience.getCompany() + "\n");
        System.out.print("----------------------------------------------------\n");

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
