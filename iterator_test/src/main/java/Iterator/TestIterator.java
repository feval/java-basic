package Iterator;

import java.util.*;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/25 11:07
 */
public class TestIterator {
    public static void main(String[] args) {
/*        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("java");
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String str=iterator.next();
            System.out.println(str);
        }
        System.out.println("----------------");
        while(iterator.hasPrevious()) {
            String str=iterator.previous();
            System.out.println(str);
        }*/
/*        Vector<String> list = new Vector<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("java");
        Enumeration<String> enumeration=list.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }*/

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("java");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String str=iterator.next();
            if (str.equals("world")){
                iterator.remove();
            }
            System.out.println(str);
        }

    }
}
