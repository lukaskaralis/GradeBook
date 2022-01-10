package com.company;

public class Student extends Person {
    private String group;
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String newGrade) {
        this.grade = newGrade;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String newGroup) {
        this.group = newGroup;
    }

}
