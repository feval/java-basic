package com.bite.xml.write;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/18 17:44
 */
public class Demo2 {
    public static void main(String[] args) throws IOException, DocumentException {
        //addDoc();    alt+ctrl+m
        //editDoc();
        //del();
    }

    private static void del() throws DocumentException, IOException {
        Document doc = new SAXReader().read(Demo1.class.getClassLoader().getResource("contact.xml"));
        Element conElem = doc.getRootElement().element("contact");
        //conElem.detach();   //自杀
        Element parent = conElem.getParent();
        parent.remove(conElem);
        setWriter(doc);
    }

    private static void editDoc() throws DocumentException, IOException {
        Document doc = new SAXReader().read(Demo1.class.getClassLoader().getResource("contact.xml"));
        Element conElem = doc.getRootElement().element("contact");
        Attribute idAttr = conElem.attribute("id");
        idAttr.setValue("003");
        Element nameElem = conElem.element("name");
        nameElem.setText("赵六");
        setWriter(doc);
    }

    private static void addDoc() throws IOException {
        Document doc = DocumentHelper.createDocument();
        Element rootElem = doc.addElement("contact-list");
        Element conElem = rootElem.addElement("contact");
        conElem.addAttribute("id", "001");
        setWriter(doc);
        return;
    }

    private static void setWriter(Document doc) throws IOException {
        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\123456.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(doc);
        writer.close();
    }
}
