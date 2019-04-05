/*
模版设计模式代码骨架：
*/
public abstract class TempalteDesignPatter{
    
    //1. 准备模版方法 final修饰，定义执行流程
    public final void templateMethod(){
        method1();
        if(true){
            method2();
        }
        for(int i=0;i<5;i++){
            method3();
        }
        method4();
        method5();
        method6();
    }

    //2. 一些子类必须实现的方法
    public abstract void method1();
    public abstract void method2();
    
    //3. 一些子类不需要覆写的方法
    public final void method3(){
        //这里是代码
    }

    public final void method4(){
        //这里是代码
    }
    
    //4. 一些子类可以选择去覆写的方法
    //钩子方法
    public void method5(){
        //这里是代码
    }
    
    public void method6(){
        //这里是代码
    }
    
}
