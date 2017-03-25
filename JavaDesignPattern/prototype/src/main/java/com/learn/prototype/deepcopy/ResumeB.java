package com.learn.prototype.deepcopy;

/**
 * Created by hechao on 2017/3/25.
 */
public class ResumeB implements Cloneable{
    private String name;
    private String sex;
    private String age;

    private WorkExperienceB workExperienceB;

    public ResumeB(String name){
        this.name = name;
        workExperienceB = new WorkExperienceB();
    }

    public ResumeB(WorkExperienceB workExperience){
        try {
            // workExperienceB deepcopy
            this.workExperienceB = (WorkExperienceB)workExperience.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    // 设置个人信息
    public void setPersonalInfo(String sex,String age) {
        this.sex = sex;
        this.age = age;
    }

    // 设置工作经历
    public void setWorkExperienceB(String workDate,String company) {
        workExperienceB.setWorkDate(workDate);
        workExperienceB.setCompany(company);
    }

    public void display() {
        System.out.print("Resume.hashCode == " +  this.hashCode()+ "\n");
        System.out.print("workExperienceB.hashCode == " +  workExperienceB.hashCode() + "\n");
        System.out.print(this.hashCode() + " " +name + " " + sex + " " + age + "\n");
        System.out.print(workExperienceB.hashCode() + " 工作经历: " + workExperienceB.getWorkDate() + " " + workExperienceB.getCompany() + "\n");
        System.out.print("----------------------------------------------------\n");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        ResumeB obj = new ResumeB(this.workExperienceB);
        obj.name = this.name;
        obj.sex = this.sex;
        obj.age = this.age;
        return obj;
    }
}
