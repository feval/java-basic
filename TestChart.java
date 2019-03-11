public class TestChart{
	public static void main(String[] args) {
		Discount[] tx=new Discount[]{new Discount("T恤",245),new Discount("网球鞋",570),new Discount("网球拍",320)};
		int result=0;
		tx[0].setNum(2);
		tx[0].setMoney(245,2);
		tx[0].chartInfo();
		tx[1].setNum(1);
		tx[1].setMoney(570,1);
		tx[1].chartInfo();
		tx[2].setNum(1);
		tx[2].setMoney(320,1);
		tx[2].chartInfo();
		result=tx[0].getMoney()+tx[1].getMoney()+tx[2].getMoney();
		System.out.println("总价钱:                        "+result);
		tx[0].setResult(result);
		tx[0].setRebet(0.8);
		tx[0].setAgg(1500);
		tx[0].discountInfo();
	}
}
class Chart{
	private final String article;
	private final int price;
	private int num;
	private int money;
	public Chart(String article,int price) {
		this.article=article;
		this.price=price;
	}
	static{
		System.out.println("****************消费单**************");
		System.out.println("购买物品"+"\t"+"单价"+"\t"+"个数"+"\t"+"金额");
	}
	public void setNum(int num) {
		this.num=num;
	}
	public void setMoney(int price,int num) {
		this.money=price*num;
	}
	public String getArticle() {
		return this.article;
	}
	public int getPrice() {
		return this.price;
	}
	public int getNum() {
		return this.num;
	}
	public int getMoney() {
		return this.money;
	}
	public void chartInfo() {
		System.out.println(this.article+"\t        "+this.price+"\t "+this.num+"\t"+this.money);
	}	
}
class Discount extends Chart{
	private double result;
	private double rebet;
	private double agg;
//	private int integral;
	public Discount(String article,int price) {
		super(article,price);
	}
	public void setResult(double result) {
		this.result=result;
	}
	public void setRebet(double rebet) {
		this.rebet=rebet;
	}
	public void setAgg(double agg) {
		this.agg=agg;
	}	
	public double getResult() {
		return this.result;
	}
	public double getRebet() {
		return this.rebet;
	}
	public double getAgg() {
		return this.agg;
	}
	public void discountInfo() {
		System.out.println("折扣:"+"\t"+(this.rebet*10)+"折");
		System.out.println("消费总金额:"+"\t $"+(this.result*this.rebet));
		System.out.println("实际交费:"+"\t $"+this.agg);
		System.out.println("找钱:"+"\t         $"+(this.agg-(this.result*this.rebet)));
		System.out.println("本次消费所获得的积分是:"+"\t"+((int)(0.03*(this.result*this.rebet))));
	}
	
}

