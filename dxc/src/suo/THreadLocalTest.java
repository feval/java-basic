package suo;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/12 20:11
 */
public class THreadLocalTest {
    private static ThreadLocal<String> str=new ThreadLocal<>();

    public static void main(String[] args) {
        str.set("nihao");
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                str.set("buhao");
            }
        });
        thread.start();
        System.out.println(str.get());
    }
}
