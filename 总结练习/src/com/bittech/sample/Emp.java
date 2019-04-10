package com.bittech.sample;

public class Emp {
    //雇员名称
    private String name;
    //雇员工作
    private String job;

    private String skill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}
