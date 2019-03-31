public class Person2{

    //属性
    //private 访问控制修饰符
    private String name;
    
    private int age;
    
    /*
    static 
    1.  修饰属性 ： 静态属性（类属性） 
    2.  访问方式 :  类名.属性名    this.属性名(不建议)
    3.  修饰方法 ： 静态方法（类方法）
    4.  访问方式 :  类名.方法名
    5.  静态属性，静态方法，如果在同一个类中访问 可以省去类名
    6.  静态方法中不能访问非静态属性（变量）和方法 
        => 成员属性，成员方法 this
    */
    private static String country = "中国";
    
    
    /*
    构造方法：
    1. 方法名和类名相同，没有返回值
    2. 如果用户没有定义构造方法，自动生成默认构造方法（无参数）
       如果用户定义了构造方法，不会再生成默认构造方法
    3. 调用本类的构造方法this(参数列表) 
       调用继承的构造方法super(参数列表)
    4. 构造方法中通过this,super调用构造方法必须是首行
    */
    public Person2(){
        
    }

    
    public Person2(int age){
        this.age = age;
        System.out.println("一个参数的构造方法被调用");
    }
    
    
    public Person2(int age, String name){
        this(age); //简化编码
        this.name = name; 
        System.out.println("两个参数的构造方法被调用");
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    public void setAge(int age){
        //more code 
        if(age < 0 || age >120){
            this.age = -1;
        }else{
            this.age = age;
        }
        
    }
    
    public int getAge(){
        return this.age;
    }
    
    //方法
    //默认的访问修饰符
    
    public String getPersonInfo(){
       //private 该类内部是可以直接访问
       //return "姓名:"+this.name+" 年龄:"+this.age;
       return "姓名:"+this.getName()+" 年龄:"+this.getAge() 
       + " 国籍:"+ Person2.country;   //this.country;
    }
    
    public void print(){
        System.out.println("在【成员方法】打印this:"+this);
    }
    
    public static void staticMethod(){
        System.out.println("这是Person2的静态方法"+this);
    }
    
    

}