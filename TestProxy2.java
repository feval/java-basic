public class TestProxy2{
	public static void main(String[] args) {
		
		Subject realSubject=new RealSubject();
		System.out.println("扩展之前的业务:");
		realSubject.buyComputer();
		System.out.println("扩展之后的业务:");
		Subject proxySubject=new ProxySubject(realSubject);
		proxySubject.buyComputer();
	}	
}
interface Subject{
	void buyComputer();
}


class RealSubject implements Subject{
	public void buyComputer() {
		System.out.println("购买电脑");
	}
}
class ProxySubject implements Subject{
	
	private Subject target;
	public ProxySubject(Subject target) {
		this.target=target;
	}
	public void buyComputer() {
		System.out.println("调研,听取客服的讲解");
		this.target.buyComputer();
		System.out.println("享受售后服务");
	}
}