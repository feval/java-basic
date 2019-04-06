public class TestTemplateDesignPattern{

    public static void main(String[] args){
        /*
        Coffee coffee = new Coffee();
        coffee.prepare();
        Tea  tea = new Tea();
        tea.prepare();
        */
        System.out.println("Drink1制作流程");
        Drink drink1 = new Coffee();
        drink1.prepare();
        
        System.out.println("Drink2制作流程");
        Drink drink2 = new Tea(false);
        drink2.prepare();
        
        System.out.println("Drink3制作流程");
        Drink drink3 = new Tea();
        drink3.prepare();
        
    }

}

/*
模版设计模式：
1. 子类和父类的继承关系
2. 抽象类，定义每一步执行的方法，有实现类完成方法的实现（覆写）

*/

abstract class Drink{
    
    //制作饮品的步骤
    public final void prepare(){
        //1.烧水
        boilWater();
        //2.添加主料
        addMaterial();
        //3.饮品倒入杯子
        cup();
        //4.添加辅料    
        if(this.isAddMinorMaterial()){
           addMinorMaterial();    
        }
    }
    
    public  void boilWater(){
        System.out.println("1. 制作饮品得烧水");
    }
    
    public abstract void addMaterial();
    public abstract void cup();
    public abstract void addMinorMaterial();
    
    public boolean isAddMinorMaterial(){
        return true;
    }

}


class Coffee extends Drink{
    
    /*
    public void prepare(){
        //1.烧水
        boilWater();
        //2.添加主料
        addMaterial();
        //3.饮品倒入杯子
        cup();
        //4.添加辅料
        addMinorMaterial();
    }
    */
    
    public void boilWater(){
        super.boilWater();
        System.out.println("1.1 开水不能喝，冷却");
    }
    
    public void addMaterial(){
        System.out.println("2. 往水中添加咖啡粉");
    }
    
    public void cup(){
        System.out.println("3. 泡好的咖啡倒入水杯");
    }
    
    public void addMinorMaterial(){
        System.out.println("4. 泡好的咖啡中添加糖");
    }
}


class Tea extends Drink{
    
    private boolean addMinorMaterial =true;
    
    /*
    public void prepare(){
        
        //1.烧水
        boilWater();
        //2.添加主料
        addMaterial();
        //3.饮品倒入杯子
        cup();
        //4.添加辅料
        addMinorMaterial();
    }*/
    
    public Tea(){
        
    }
    
    public Tea(boolean addMinorMaterial){
        this.addMinorMaterial =addMinorMaterial;
    }
        
    /*
    public void boilWater(){
        System.out.println("1. 煮茶烧水");
    }*/
    
    public void addMaterial(){
        System.out.println("2. 往水中添加茶叶");
    }
    
    public void cup(){
        System.out.println("3. 泡好的茶倒入水杯");
    }
    
    public void addMinorMaterial(){
        System.out.println("4. 泡好的茶中添加柠檬");
    }

    public boolean isAddMinorMaterial(){
        return this.addMinorMaterial;
    }
}








