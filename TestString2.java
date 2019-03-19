public class TestString2{
	
	public static void main(String[] args) {
		{
		String str1 = "helloworld";
        for(int i=0; i < str1.length(); i++){
            char c = (char)(str1.charAt(i) - 32);
            System.out.print(c);
        }
        System.out.println();
		}
		{
		String str1 = "helloworld";
        char[] chars = str1.toCharArray();
        for(int i=0; i < chars.length; i++){
            char c = (char)(chars[i] - 32);
            System.out.print(c);
		}
	    System.out.println();
		}
		{
		String str1 = "helloworld";
        char[] chars = str1.toCharArray();
        for(int i=0; i < chars.length; i++){
            chars[i] = (char)(chars[i] - 32);
        }
        String str2 = new String(chars);
        System.out.println(str2);
        System.out.println(new String(chars,3,4));
			
		}
	} 
}