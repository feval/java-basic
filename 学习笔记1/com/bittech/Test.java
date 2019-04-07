package com.bittech;

//import com.bittech.im.Message;
//import com.bittech.im.QQMessage;


/**
1. 包定义 代码首行
2. 公司域名反转   
   bittech.com -> com.bittech
   个人主页地址反转
   github.com/broncho -> com.github.broncho  
3. 包名不要用别人的包名
   java.lang javax eclipse apache 
   org.apache
4. 类定义了包名   类名：包名+类名 全限定名
5. 包名是独立的，没有包含关系
6. 不同包同名类如果被同时使用，在使用类的时候采用全限定名（不需要导入）
7. 本地开发时：源代码也归档到包目录下
*/
import child.Child;

public class Test{

    public static void main(String[] args){
        
        /*
        com.bittech.util.Message message1 = new com.bittech.util.Message();
        message1.print();
        com.bittech.im.Message message2 = new com.bittech.im.Message();
        message2.print();
        */
        Child child = new Child();
        child.print();
        
        
        
        
     
    }
}