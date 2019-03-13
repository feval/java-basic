public class TemplateDesignPattern{
	public static void main(String[] args) {
		Drink coffee=new Coffee();
		coffee.means();
		Drink tea1=new Tea();
		tea1.means();
		Drink tea2=new Tea(false);
		tea2.means();		
	}
}
abstract class Drink{
	public final void means() {
		boilWatter();
		addMaterial();
		pourCup();
		if(this.isAddCondiments()) {
		addCondiments();
		}
	}
	public void boilWatter() {
		System.out.println("1.煮沸水");
	}
	public abstract void addMaterial();
	public abstract void pourCup();
	public abstract void addCondiments();
	public boolean isAddCondiments() {
		return true;
	}
}


class Coffee extends Drink{

	public void addMaterial() {
		System.out.println("2.用沸水冲泡咖啡");
	}
	public void pourCup() {
		System.out.println("3.把泡好的咖啡倒入杯子");
	}
	public void addCondiments() {
		System.out.println("4.加糖和牛奶");
	}

}


class Tea extends Drink{
	private boolean addCondiments=true;
	
	public Tea() {
		
	}
	public Tea(boolean addCondiments) {
		this.addCondiments=addCondiments;
	}
	public void boilWatter() {
		super.boilWatter();
		System.out.println("1.1水温80度");
	}
	public void addMaterial() {
		System.out.println("2.用沸水冲泡茶叶");
	}
	public void pourCup() {
		System.out.println("3.把泡好的茶倒入杯子");
	}
	public void addCondiments() {
		System.out.println("4.加柠檬");
	}
	public boolean isAddCondiments() {
		return this.addCondiments;
	}

}