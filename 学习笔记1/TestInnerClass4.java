public class TestInnerClass4{

    public static void main(String[] args){
        
      //没有class 类名
      //没有 构造 方法
      /*
      Chat chat =  new Chat() {
              public void sendMessage(){
                  System.out.println("匿名内部类的方法执行");
              }
          };
      chat.sendMessage();
      */
      
      int a = 10; //final
      new Chat() {
              public void sendMessage(){
                  System.out.println("匿名内部类的方法执行");
                  System.out.println(a);
              }
      }.sendMessage();

    }
    
}

/*
1. 匿名内部类：处理方法内部类的特点外
2. 必须继承一个抽象类或者实现一个接口
3. 没够构造方法
*/
interface Chat{
   //public  
    void sendMessage();
}








