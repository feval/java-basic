package com.lin.dao;

/**
 * Description:
 * Author:  llf
 * Created in 2019/8/3 14:48
 */
public class Dept {
    private String dname;
    private String loc;
    private Company company=new Company();

    public Company getCompany() {
        return company;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", company=" + company +
                '}';
    }
}
