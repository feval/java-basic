public class TestString1{
	
	public static void main(String[] args) {
		{
		int x=10;
		int y=10;
		System.out.println(x==y);   //true
		
		String a="Hello java";
		String b="Hello java";
		System.out.println(a==b);   //true
		
		String c=new String("Bit");
		String d=new String("Bit");
		System.out.println(c==d); // false
		
		String e=new String("Hello java");
		System.out.println(a==e);  //false
		
		String f=new String("Java is best").intern();//字符如常量池
		String g="Java is best";
		System.out.println(f==g);  //true
		}
		String str="HelloWorld";
		char c=str.charAt(9);
		System.out.println(c);
		
		String str1 = "helloworld";
        for(int i=0; i < str1.length(); i++){
            char d = (char)(str1.charAt(i) - 32);
            System.out.print(d);
        }
        System.out.println();
	}
}