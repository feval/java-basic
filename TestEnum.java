public class TestEnum{
	public static void main(String[] args) {
		Sex sex=Sex.getInstance(args[0]);
		System.out.println(sex);
	}
}
class Sex{
	private String desc;
	private static final Sex MALE=new Sex("男");
	private static final Sex FEMALE=new Sex("女");
	public static Sex getInstance(String desc) {
		switch(desc) {
			case "男":
			return MALE;
			case "女":
			return FEMALE;
			default :
			return null;
		}
	}
	private Sex(String desc) {
		this.desc=desc;
	}
	public String toString() {
		return this.desc;
	}
}