package com.bittech.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

    public String classPath = "E:\\worskpace\\java9_code\\javase-0411\\out\\production\\javase-0411\\";

    public Class loadClassData(String className) {
        //className -> Class
        //com.bittech.classloader.Member ->
        //E:\worskpace\java9_code\javase-0411\out\production\javase-0411\com\bittech\classloader\Member.class
        //classpath : E:\worskpace\java9_code\javase-0411\out\production\javase-0411
        byte[] data = loadData(className);
        return super.defineClass(className, data, 0, data.length);
    }

    private byte[] loadData(String className) {
        String classFile = classPath + className.replace(".", "\\") + ".class";
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             FileInputStream in = new FileInputStream(classFile)
        ) {
            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            out.flush();
            return out.toByteArray();
        } catch (IOException e) {

        }
        throw new RuntimeException("Class file load data filed.");
    }

}
