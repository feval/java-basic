package maptest;


import sun.nio.cs.ext.MacArabic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/25 12:10
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"hello");
        map.put(4,"bite");
        map.put(4,"测试");
        map.put(null,null);
        map.put(null,"哈哈");
/*        System.out.println(map);
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Integer i=iterator.next();
            System.out.println(i+"="+map.get(i));
        }*/
        Set<Map.Entry<Integer,String>> set=map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator=set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

}
