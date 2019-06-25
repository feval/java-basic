package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/25 19:24
 */
public class CollectionTest {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Collections.addAll(list,"hello","world");
        Collections.reverse(list);
        System.out.println(list);
    }
}
