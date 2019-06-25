package jvmtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/25 20:49
 */
public class OOMTest {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
/*        while (true) {
            list.add(new OOMObject());
        }*/
    }
}
