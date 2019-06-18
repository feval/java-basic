package com.bite.xml.read;

import jdk.internal.dynalink.linker.LinkerServices;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/18 16:40
 */
public class Dom4jTest {
    public static void main(String[] args) throws Exception {
        Document doc = new SAXReader().read(Dom4jTest.class.getClassLoader().getResource("contact.xml"));
        List<Contact> contactList=new ArrayList<>();
        List<Element> elements= doc.getRootElement().elements("contact");
        for (Element element:elements) {
            Contact contact=new Contact();
            contact.setId(element.attributeValue("id"));
            contact.setName(element.elementText("name"));
            contact.setGender(element.elementText("gender"));
            contact.setPhone(element.elementText("phone"));
            contact.setEmail(element.elementText("email"));
            contact.setAddress(element.elementText("adress"));
            contactList.add(contact);
        }
        for (Contact contact:contactList) {
            System.out.println(contact);
        }
    }
}
