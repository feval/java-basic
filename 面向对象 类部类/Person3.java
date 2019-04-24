public class Person3{
    
    /*
      1. 执行一次
      2. 在构造块，构造方法之前执行
      3. 静态代码块，在加载类的时候才会执行
    */
    static{
        System.out.println("Person3 静态代码块执行");
    }
    
    /*
      属性赋值：
      1. 直接赋值
      2. 通过构造块
      3. 通过构造方法 （传入参数， 执行方法）
      
      4. 通过对象访问修改属性的方法进行属性赋值
    */
    private int num ;
    
    /*
        1. 构造块在构造方法之前执行
        2. 每次创建对象，构造块都要执行
        3. 成员属性初始化赋值过程比较复杂采用
    */
    {
        System.out.println("构造块执行");
        
    }

    public Person3(){
        System.out.println("构造方法执行");
        
    }
    
    /*
    private void initNum(){
        //code1
        //code2
        //code3
        this.num = 5;
    }*/
    
    /*
    public static void main(String[] args){
        new Person3();
        new Person3();
    }*/
    
}