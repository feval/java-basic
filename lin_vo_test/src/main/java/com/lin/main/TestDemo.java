package com.lin.main;


import com.lin.dao.EmpAction;

/**
 * Description:
 * Author:  llf
 * Created in 2019/8/3 14:27
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        String value = "emp.ename:feval|emp.job:Java Coder|emp.dept.dname:教务部|emp.dept.company.cname:xi'an technology" ;
        EmpAction empAction=new EmpAction();
        empAction.setValue(value);
        System.out.println(empAction.getEmp());
    }
}
