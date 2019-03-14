import java.util.Scanner;
public class TestScanner1{
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入你的名字:");
		String name=scanner.nextLine();
		System.out.println("请输入你的性别:");
		String sex=scanner.nextLine();
		System.out.println("请输入你的年龄:");
		int age=scanner.nextInt();
		System.out.println("需不需要国家发放对象(需要/不需要):");
		String s=scanner.next();
		if(s.equals("需要")) {
			System.out.println("您的信息:");
			System.out.println("姓名:"+name);
			System.out.println("性别:"+sex);
			System.out.println("年龄:"+age);
			System.out.println("马上发放对象");
		}else {
			System.out.println("good");
		}
	}
}