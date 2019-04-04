public class TestInnerClass2{

    public static void main(String[] args){
        
       Outer.Inner  inner  = new Outer.Inner();
       inner.print();
       
    }

}
//外部类
class Outer{
    
    private static String message = "Outer的消息";
    
    //静态内部类
    /*
      1. static 修饰类
      2. 静态内部类不能访问外部类的非静态属性和方法
      3. 静态内部类使用：
         外部类.内部类  对象名 =  new 外部类.内部类();
         Outer.Inner inner = new Outer.Inner();
    */
    static class Inner{
        
        public void print(){
            System.out.println("static Inner 的消息");
        }
        
        public static void print(int a){
            System.out.println(a);
        }
    }
    
    public void print(){
        Inner inner = new Inner();
    }
    
}

