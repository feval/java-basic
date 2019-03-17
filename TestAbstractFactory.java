public class TestAbstractFactory{

	public static void main(String[] args) {
		Client client=new Client();
		ComputerFactory factory=new MacProComputerFactory();
		client.buyComputer(factory.createComputer(),factory.createOperationOS());
	
	}
}
class Client{
	
	public void buyComputer(Computer computer,OperationOS os) {
		computer.printComputer();
		os.printOperationOS();
	}	
}

//计算机
interface Computer{
	/**
	*打印具体的计算机信息
	*/
	void printComputer();
}

class MacProComputer implements Computer{
	public void printComputer() {
		System.out.println("Mac 漂亮");
	}
}

class SurfaceBookComputer implements Computer{
	public void printComputer() {
		System.out.println("Suferface 划算");
	}
}

//操作系统
interface OperationOS{
	void printOperationOS();
}

class Windows10 implements OperationOS{
	public void printOperationOS() {
		System.out.println("Windows10 简单");
	}
}

class MacOS implements OperationOS{
	public void printOperationOS() {
		System.out.println("MacOS 流畅");
	}
}

/**
*抽象工厂模式
*/
interface ComputerFactory{
	Computer createComputer();
	OperationOS createOperationOS();
}

class MacProComputerFactory implements ComputerFactory{
	public Computer createComputer() {
		return new MacProComputer();
	}
	public OperationOS createOperationOS() {
		return new MacOS();
	}
}

class SurfaceBookComputerFactory implements ComputerFactory{
	public Computer createComputer() {
		return new SurfaceBookComputer();
	}
	public OperationOS createOperationOS() {
		return new Windows10();
	}
}









































































