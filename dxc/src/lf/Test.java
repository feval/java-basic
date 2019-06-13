package lf;

import java.util.*;

/**
 *
 */
public class Test {
    public static void sss() {
        System.out.println("nihao");
    }
    public static void main(String[] args) {
      //  ((Test)null).sss();
        int i=0;
        Integer j=new Integer(0);
        System.out.println(i==j);
        System.out.println(j.equals(i));

/*        //动态数组
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(1);
        System.out.println(list);
        //不包含重复元素的接口
        Set<Integer> set=new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(1);
        System.out.println(set);
        Collections.sort(list);
        System.out.println(list);
        Stack<Integer> stack=new Stack<>();
        stack.push(2);*/
        Scanner scanner = new Scanner(System.in);
        //自定义分隔符
        scanner.useDelimiter("-");
/*        if (scanner.hasNext()) {
            String str=scanner.next();
            System.out.println(str);
        }*/
/*        String str="wlf";
        str.toUpperCase();
        String str2=str.replace("W","w");
        str2=str2+"hl";
        System.out.println(str2);*/
    }
}
