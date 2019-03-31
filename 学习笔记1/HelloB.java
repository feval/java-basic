public class HelloB extends HelloA {
	//构造方法
	public HelloB(){
		System.out.println("4Hello B! 构造方法");
	}
	//非静态代码块
	{
		System.out.println("5i'm B class.非静态代码块");
	}
	//静态代码块
	static{
		System.out.println("6static B 静态代码块");
	}
	
	public static void main(String[] args) {
		System.out.println("7---start---");
		new HelloB();
		//new HelloB();
		System.out.println("8---end---");        
	}
}