package com.lin.dao;

/**
 * Description:
 * Author:  llf
 * Created in 2019/8/3 14:46
 */
public class Company {
    private String cname;
    private String address;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "cname='" + cname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
