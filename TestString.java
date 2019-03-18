public class TestString{
	
	public static void main(String[] args) {
		{
		String[] str=new String[]{
			"JavaSE",
			"JavaEE",
			"MySQL"
		};
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length;i++) {
			sb.append(str[i]).append(",");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		}
		{
		StringBuffer sb=new StringBuffer("hello World");
		System.out.println(sb.reverse());
		
		System.out.println(sb.delete(1,5).toString()); //字符串删除
		System.out.println(sb.insert(1,"您好"));  //字符串替换
		}
	}
}