package com.lin.dao;

        import com.lin.bean.BeanOperation;

/**
 * Description:
 * Author:  llf
 * Created in 2019/8/3 13:49
 */
public class EmpAction {
    private Emp emp=new Emp();
    public void setValue(String value) throws Exception {
        BeanOperation.setBeanValue(this,value);
    }
    public Emp getEmp() {
        return emp;
    }
}
