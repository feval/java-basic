package com.lin.dao;

/**
 * Description:
 * Author:  llf
 * Created in 2019/8/3 13:47
 */
public class Emp {
    private String ename;
    private String job;
    private Dept dept=new Dept();

    public Dept getDept() {
        return dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", dept=" + dept +
                '}';
    }
}
