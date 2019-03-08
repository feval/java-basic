public class 乘法口诀{
	public static void main(String[] args) {
		mul(9);
	}
	public static void 	mul(int a) {
		for(int i=1;i<=a;++i) {
			for(int j=1;j<=i;++j) {
				System.out.print(i+"*"+j+"="+i*j+"\t");			
			}
		System.out.print("\n");
		}
	}
}