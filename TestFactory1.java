import java.util.Scanner;
public class TestFactory1{
	
	public static void main(String[] args) {
		Client client=new Client();
		System.out.println("亲输入你要购买的产品(mac/surface/alienware)");
		Scanner scanner=new Scanner(System.in);
		String type=scanner.next();
		Computer computer=ComputerFactory.creatComputer(type);
		if(computer==null) {
			System.out.println("本工厂不能生产该类计算机:"+type);
			
		}else {
			client.buyComputer(computer);
		}
	}
	
}
class Client{
	public void buyComputer(Computer computer) {
		computer.printComputer();
	}
}
class ComputerFactory{
	
	public static Computer creatComputer(String type) {
		switch(type) {
			case "mac":{
				return new MacproComputer();
			}
			case "surface":{
				return new SurfacebookComputer();
			}
			case "alienware":{
				return new AlienwareComputer();
			}
			default :
			return null;
		}
	}
}
interface Computer{
	void printComputer();
}
class MacproComputer implements Computer{
	public void printComputer() {
		System.out.println("Mac pro 漂亮");
	}
}
class SurfacebookComputer implements Computer{
	public void printComputer() {
		System.out.println("Suface 性能好");
	}
}
class AlienwareComputer implements Computer{
	public void printComputer() {
		System.out.println("Alienware 便宜");
	}
}