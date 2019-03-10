public class TestOverride{

	public static void main(String[] args) {
		Person person;
		if(args.length==1&&args[0].equals("en")) {
			person=new Person("张三",true);
		}else{
			person=new ChinesePerson("张三",true);
		}
		person.setAge(24);
		person.setPost("HR direction");
		person.setAdress("西安科技大学");
		person.setTel("123456");
		person.personInfo();		
	}
}
class Person{
	private final String name;
	private final boolean gender;
	private int age;
	private String post;
	private String adress;
	private String tel;
	
	public Person(String name,boolean gender) {
		this.name=name;
		this.gender=gender;		
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setPost(String post) {
		this.post=post;
	}
	public void setAdress(String adress) {
		this.adress=adress;
	}
	public void setTel(String tel) {
		this.tel=tel;
	}
	public String getName() {
		return this.name;
	}
	public boolean isGender() {
		return this.gender;
	}
	public int getAge() {
		return this.age;
	}
	public String getPost() {
		return this.post;
	}
	public String getAdress() {
		return this.adress;
	}
	public String getTel() {
		return this.tel;
	}
	public void personInfo() {
		System.out.println("Name:"+this.name+"\t"+"        Gender:"+(this.gender?"male":"female"));
		System.out.println("Age:"+this.age+"\t"+"                Post:"+this.post);
		System.out.println("Adress:"+this.adress+"\t"+"Tel:"+this.tel);		
	}
}
class ChinesePerson extends Person{
	public ChinesePerson(String name,boolean gender) {
		super(name,gender);		
	}
		public void personInfo() {
		System.out.println("姓名:"+this.getName()+"\t"+"        性别:"+(this.isGender()?"男":"女"));
		System.out.println("年龄"+this.getAge()+"\t"+"                岗位:"+this.getPost());
		System.out.println("地点:"+this.getAdress()+"\t"+"电话:"+this.getTel());		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}