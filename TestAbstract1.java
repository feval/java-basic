public class TestAbstract1{
	public static void main(String[] args) {
		new B(30).print() ; //1.实例化子类对象
	}
}

abstract class A{
	public A(){ //3.调用父类构造
		this.print() ; //4.调用被子类覆写的方法
	}
	public abstract void print() ;	
}

class B extends A{
    
	private int num = 100 ; //1
    
    { 
        num = 80; //2
    }
    
    //3
    // 默认值 >  1 > 2> 3 
    // 默认值 > 成员属性声明并赋值 > 构造块赋值 > 构造方法赋值
	public B(int num) { //2.调用子类实例化对象
		super() ; //3.隐含一行语句，实际要先调用父类构造
		System.out.println(this.num);
        this.num = num ; //7.为类中属性初始化
	}
    
	public void print() { //5.此时子类对象的属性还没有被初始化
		System.out.println(this.num) ; //6.对应其数据类型的默认值
	}
}
