package com.lin.bean;

import com.lin.dao.EmpAction;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description:
 * Author:  llf
 * Created in 2019/8/3 13:48
 */
public class BeanOperation {
    public BeanOperation() {
    }

    /**
     * 负责设置类中的属性操作
     *
     * @param actionObject 表示当前请求的程序类当前对象
     * @param msg          属性的具体内容，格式为:"对象.属性名称:内容|对象.属性名称:内容..."
     */
    public static void setBeanValue(Object actionObject, String msg) throws Exception {
        String[] result = msg.split("\\|");
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i].split(":");
            String attribute = temp[0];
            String value = temp[1];
            String[] fields = attribute.split("\\.");
            if (fields.length > 2) {
                Object curentObject = actionObject;
                for (int j = 0; j < fields.length - 1; j++) {
                    curentObject = getObject(curentObject, fields[j]);
                }
                setObjectValue(curentObject, fields[fields.length-1], value);
            } else {
                Object curentObject = getObject(actionObject, fields[0]);
                setObjectValue(curentObject, fields[1], value);
            }
        }
    }

    private static Object getObject(Object obj, String attribute) throws Exception {
        //查找empaction中是否包含属性attribute
        Field field = obj.getClass().getDeclaredField(attribute);
        if (field == null) {
            field = obj.getClass().getField(attribute);
        }
        if (field == null) {
            return null;
        }
        String methodName = "get" + initCap(attribute);
        Method method = obj.getClass().getMethod(methodName);
        return method.invoke(obj);
    }

    private static void setObjectValue(Object obj, String attribute, String value) throws Exception {
        Field field = obj.getClass().getDeclaredField(attribute);
        if (field == null) {
            field = obj.getClass().getField(attribute);
        }
        if (field == null) {
            return;
        }
        String methodName = "set" + initCap(attribute);
        Method setmethod = obj.getClass().getMethod(methodName, field.getType());
        setmethod.invoke(obj, value);
    }

    private static String initCap(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
