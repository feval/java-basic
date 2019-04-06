//导入Scanner类
import java.util.Scanner;
public class TestScanner{

    
    //Scanner的使用
 
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的名字：");
        String name = scanner.nextLine();
        
        System.out.println("请输入您的你年龄：");
        int age = scanner.nextInt();

        System.out.println("要不要给介绍个对象(yes/no)：");
        String rs = scanner.next();
        if(rs.equals("yes")){
            System.out.println("您的信息：");
            System.out.println("姓名："+name);
            System.out.println("年龄："+age);
        }else{
            System.out.println("好");
        } 
    } 
}