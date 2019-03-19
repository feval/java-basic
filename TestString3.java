public class TestString3{
	
	public static void main(String[] args) {
		{
		String[] strs = new String[]{
            null,
            "",
            "       ",
            "1234",
            "123abc45"
        };
        
        for(int i=0; i<strs.length; i++){
            System.out.println(strs[i]+"是有数组组成："+ 
              isNumber(strs[i])
            );
        }
		}
	   System.out.println("A".equals("A")); //true
       System.out.println("A".equals("a")); //false
       System.out.println("A".equalsIgnoreCase("a"));//true
       System.out.println("A".compareTo("a"));//<0
       System.out.println("a".compareTo("A"));//>0
       System.out.println("A".compareTo("A"));//=0
       System.out.println("一".compareTo("王"));//unicode编码值比较
       // \u4e00 
	
	}
	
	public static boolean isNumber(String str){
	//str  null, "", "1234", "123abc45"
	if(str == null || "".equals(str)){
		return false;
	}
	char[] chars = str.toCharArray();
	for(int i=0; i<chars.length; i++){
		char c =  chars[i];
		if(!(c >='0' && c<='9')){
			return false;
		}
	}
	return true;
	}
}