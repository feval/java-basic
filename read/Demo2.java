package com.bite.xml.read;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/18 16:12
 */
public class Demo2 {
    public static void main(String[] args) throws Exception{
        SAXReader reader = new SAXReader();
        Document doc = reader.read(Demo2.class.getClassLoader().getResource("contact.xml"));
        Element rootElem = doc.getRootElement();
        System.out.println(rootElem.getName());
        Element conElem = rootElem.element("contact");
        System.out.println(conElem);
        System.out.println("-------------");
        List<Element> list = rootElem.elements("contact");

        Iterator<Element> it = list.iterator();
        while (it.hasNext()) {
            Element next = it.next();
            System.out.println(next);
        }
        System.out.println("-------------");
        List<Element> elements = rootElem.elements();
        for (Element element:elements) {
            System.out.println(element);
        }
    }
}
