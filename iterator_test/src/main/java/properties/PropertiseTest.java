package Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/25 19:01
 */
public class PropertiseTest {
    public static void main(String[] args)  throws Exception{
        Properties properties=new Properties();
/*        properties.setProperty("xa","西安");
        properties.setProperty("sh","上海");
        properties.setProperty("bj","北京");
        properties.setProperty("hz","杭州");*/
        /*System.out.println(properties.getProperty("sh"));
        System.out.println(properties.getProperty("gz","城市"));*/
//        File file=new File("E:\\Java\\iterator_test\\src\\main\\resources"+"\\test.propertise");
        InputStream in=PropertiseTest.class.getClassLoader().getResourceAsStream("test.propertise");
        properties.load(in);
//        properties.store(new FileOutputStream(file),"first commit");
        System.out.println(properties.getProperty("xa"));
        System.out.println(properties.getProperty("sh"));

    }
}
