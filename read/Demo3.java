package com.bite.xml.read;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.transform.sax.SAXResult;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/18 16:27
 */
public class Demo3 {
    public static void main(String[] args) throws Exception {
        Document doc = new SAXReader().read(Demo3.class.getClassLoader().getResource("contact.xml"));
        Element conElem = doc.getRootElement().element("contact");
        String idAttr = conElem.attributeValue("id");
        System.out.println(idAttr);
        System.out.println("--------------");
        Attribute attr = conElem.attribute("id");
        System.out.println(attr.getName() + "=" + attr.getValue());
        System.out.println("--------------");
        Element nameElem = doc.getRootElement().element("contact").element("name");
        System.out.println(nameElem.getText());

        conElem = doc.getRootElement().element("contact");
        String adress = conElem.elementText("adress");
        System.out.println(adress);
    }
}
