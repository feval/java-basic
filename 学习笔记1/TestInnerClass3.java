public class TestInnerClass3{
    
    //方法内部类-局部内部类
    public static void main(String[] args){
        Outer outer = new Outer();
        outer.display(100);
    }

}

class Outer{
    
    private static int num;
    
    public void display(int args){
        //方法内部类-局部内部类
        //JDK8之前，JDK8 隐式添加final
        //final int a =10;
        int a = 10;
        int b = a;
        class Inner{
            
            public void print(){
                num++;
                System.out.println("Outer的成员属性num="+num);
                System.out.println("Outer的成员方法参数args="+args);
                System.out.println("局部变量：b="+b);
            }
            
        }
        a = 100;
        new Inner().print();  
    }
    
    
}