public class TestUSB{

	public static void main(String[] args) {
		Computer computer=new Computer();
		USB printer=new Printer();
		computer.plugin(printer);
		USB udisk=new Udisk();
		computer.plugin(udisk);
	}
}
interface USB{
	void setup();
	void work();
}

class Computer{
	public void plugin(USB usb) {
		usb.setup();
		usb.work();
	}
}
class Printer implements USB{
	public void setup(){
		System.out.println("打印机安装厂提供的驱动"); //驱动
		
	}
	public void work() {
		System.out.println("打印机正常工作");   //工作
	}
}
class Udisk implements USB{
	public void setup() {
		System.out.println("U盘厂商驱动"); //驱动
		
	}
	public void work() {
		System.out.println("U盘正常工作");  //工作
	}
}