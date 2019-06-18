package com.bite.xml.read;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/18 15:58
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        //创建解析器对象
        SAXReader reader = new SAXReader();
        //读取资源配置xml文件
        Document doc = reader.read(Demo1.class.getClassLoader().getResource("contact.xml"));
        System.out.println(doc);

    }
}
