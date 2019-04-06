public class TestUSB{

    public static void main(String[] args){
        
        Computer computer  = new Computer();
        
        //面向接口编程
        
        USB printer = new Printer();
        computer.plugin(printer);
        
        USB udisk =  new Udisk();
        
        computer.plugin(udisk);
        
    }

}

interface USB{
    
    /**
      安装驱动
    */
    void setup();
    
    /**
      工作
    */
    void work();
}

class Computer{
    
    /**
     USB 类型  usb 参数
    */
    public void plugin(USB usb){
        usb.setup();
        usb.work();
    }
}

class Printer implements USB{
    /**
      安装驱动
    */
    public void setup(){
        System.out.println("打印机安装厂商提供的驱动");
    }
    
    /**
      工作
    */
    public void work(){
        System.out.println("打印机正常工作");
    }
    
}

class Udisk implements USB{
    /**
      安装驱动
    */
   public void setup(){
        System.out.println("U盘安装厂商提供的驱动");
    }
    
    /**
      工作
    */
    public void work(){
        System.out.println("U盘正常工作");
    }
    
}




