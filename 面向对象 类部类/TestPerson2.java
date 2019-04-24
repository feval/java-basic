public class TestPerson2{

    public static void code1(){
         //封装性
        
        Person2  person = new Person2();
        
        //属性直接赋值
        /*
        person.name = "张三";
        
        person.age= 18;
        
        System.out.println(person.age);*/
        person.setName("张三");
        person.setAge(120);
        
        //调用方法
        String info = person.getPersonInfo();
        
        System.out.println(info);
    }

    
    public static void code2(){
         Person2  person = new Person2(18,"张三");
        String info = person.getPersonInfo();
        System.out.println(info);
    }
    
    public static void code3(){
         //匿名对象
        //1. length 是数组的属性
        //2. 匿名数组对象
        System.out.println("[1,2,3]数组长度:"+new int[]{1,2,3}.length);
       
        //1. 匿名对象，栈空间没有变量引用它
        //2. 不能再次使用
        //3. 垃圾对象（空间）
        System.out.println(new Person2(18,"李四").getPersonInfo());
    }
    
    public static void code4(){
         //this 表示当前对象
       Person2 p1 = new Person2(); //堆上有个对象  O1
       p1.print();//打印this
       System.out.println(p1);//打印对象p1
       
       Person2 p2 = new Person2(); //堆上又有个对象 O2
       p2.print();//打印this
       System.out.println(p2);//打印对象p2
    }
    
    public static void code5(){
        Person2 p3 = new Person2(18);
       System.out.println(p3.getPersonInfo());
       
       Person2 p4 = new Person2(19);
       System.out.println(p4.getPersonInfo());
       
       
       
       System.out.println("-----------");
       
       p3.setCountry("美国");
       System.out.println(p3.getPersonInfo());
       System.out.println(p4.getPersonInfo());
    }
    
    public static void main(String[] args){
       
       Person2.staticMethod();
       
    
       
    }

}