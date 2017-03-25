package com.learn.prototype;

import com.learn.prototype.deepcopy.ResumeB;
import com.learn.prototype.deepcopy.WorkExperienceB;
import com.learn.prototype.shallowcopy.Resume;
import com.learn.prototype.shallowcopy.WorkExperience;

/**
 * Created by hechao on 2017/3/25.
 */
public class prototypeMain {
    public static void main(String arg[]) {
        // shallowcopy 第一层Resume深复制， 第二层workExperience就是浅复制
        Resume a = new Resume("大鸟");
        a.setPersonalInfo("男","29");
        a.setWorkExperience("1998-2003","XX企业");
        Resume b = null;
        Resume c = null;
        try {
            b = (Resume)a.clone();
            b.setWorkExperience("1998-2003","YY企业");

            c = (Resume)a.clone();
            c.setWorkExperience("1998-2003","ZZ企业");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }



        a.display();
        b.display();
        c.display();

        // deepcopy 第一层Resume深复制， 第二层workExperience就是深复制

//        ResumeB a = new ResumeB("大鸟");
//        a.setPersonalInfo("男","29");
//        a.setWorkExperienceB("1998-2003","XX企业");
//        ResumeB b = null;
//        ResumeB c = null;
//        try {
//            b = (ResumeB)a.clone();
//            b.setWorkExperienceB("1998-2003","YY企业");
//
//            c = (ResumeB)a.clone();
//            c.setWorkExperienceB("1998-2003","ZZ企业");
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//
//
//
//        a.display();
//        b.display();
//        c.display();
    }
}
