public class TestInterface1{
	//接口的向上转型和向下转型
	public static void main(String[] args) {
		//向下转型
		IMessage qq=new QQMessage();
		//qq.print();
		QQMessage qqMessage=(QQMessage)qq;
		//向上转型
		Company company=qqMessage;
		company.printCompany();
		//向上转型->父类
		Tool tool=qqMessage;
		tool.printToolType();		
	}
}

interface IMessage{                                        //2
	String MSG="java is best";
	void print();
}
interface Company{
	void printCompany();
}
interface Demo extends IMessage,Company{
	
}              //接口多对一继承
abstract class Tool{
	public abstract void printToolType();
}
class QQMessage extends Tool implements IMessage,Company{  //1
	public void print() {
		System.out.println("这是QQ message");
	}
	public void printCompany() {
		System.out.println("腾讯出品");
	}
	public void printToolType() {
		System.out.println("一款聊天软件");
	}
}