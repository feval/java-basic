public class TestInterface{

    public static void main(String[] args){
        //QQMessage qq = new QQMessage();
        IMessage  qq = new QQMessage();
        qq.print();
        //向下转型
        QQMessage qqMessage = (QQMessage)qq;
        //向上转型 -> 接口类型  
        Company company = qqMessage;
        company.printCompany();
        
        //向上转型 -> 父类
        
        Tool tool = qqMessage;
        tool.printToolType();
        
        //RMI 远程方法调用
        //dubbo  客户端调用接口方法，服务端实现接口
        
       
    }
    
}

/*
1.接口 interface
2.常量 抽象方法 （常规 JDK8特性）
  常量：省略 public static final 
  方法：省略 public abstract
3.接口无法直接实例化，通过子类完成，子类需要实现接口 implements
4.常量通过接口名直接访问
5.子类可以实现多个接口，子类实例化对象可以赋值给 其中任意一个接口类型
6.子类可以同时继承父类，实现接口    extends A implements B ,C 
7.抽象类可以实现多接口，接口不能继承抽象类，接口可以继承多接口
8.接口中定义静态接口 static interface 
*/
interface IMessage{
    
    //常量
    //public static final String MSG = "java is best";    
    String MSG = "java is best";   

    //抽象方法
    void print();
}

interface Company {
    
    void printCompany();
}

interface Demo extends IMessage, Company{
    
}

abstract class Tool {
    
    public abstract void printToolType();
}


class QQMessage  extends Tool implements IMessage, Company{
    
    public void print(){
        System.out.println("这是QQ message");
    }
    
    public void printCompany(){
        System.out.println("腾讯出品");
    }
    
    
    public void printToolType(){
        System.out.println("一款聊天软件");
    }
    
}

