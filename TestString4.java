public class TestString4{
	
	public static void main(String[] args) {
		//字符串查找
		System.out.println("Hello World".contains("World"));   //true
		System.out.println("Hello World".contains("!")); //false
		String filename = "张三的简历.pdf";
		int index =  filename.lastIndexOf(".");
		if(index == -1){
		  System.out.println("未找dot .");
		}else{
		 System.out.println(filename.substring(index));
		 System.out.println("找到 dot .");
		}
		System.out.println(filename.endsWith(".pdf")); //true 

		System.out.println("字符串替换");
		System.out.println("Hello World".replaceAll("l","_"));
		System.out.println("Hello World".replaceFirst("l","_"));

		     
	
		
	}
	
	
}