package com.bite.xml.write;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/18 17:29
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{
        Document doc = new SAXReader().read(Demo1.class.getClassLoader().getResource("contact.xml"));
        OutputStream out=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123456.xml");
        //Outputformat.creatPretyFotmat;
        OutputFormat format=OutputFormat.createCompactFormat();
        format.setEncoding("utf-8");
        XMLWriter writer=new XMLWriter(out,format);
        writer.write(doc);
        writer.close();

    }
}
