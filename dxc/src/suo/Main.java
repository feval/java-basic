package suo;

import java.util.Scanner;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/13 0:36
 */
public class Main{
    public static void main (String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()) {
            String s = in.nextLine();
            String s1 = in.nextLine();
            int[] counter=new int[255];
            char[] chars=s.toCharArray();
            for (int i = 0; i <s.length() ; i++) {
                char c=chars[i];
                counter[c]++;
            }
            int[] counter1=new int[255];
            char[] chars1=s1.toCharArray();
            for (int i = 0; i <s1.length() ; i++) {
                char c=chars1[i];
                counter1[c]++;
            }
            int sub=0;     //不够
            int add=0;
            for (int i = 0; i <255 ; i++) {
                if ((counter1[i]-counter[i]) ==0) {
                   // break;
                }else if((counter1[i]-counter[i]) >0){
                    sub+=counter1[i]-counter[i];
                }else {
                    add+=counter[i]-counter1[i];
                }
            }
            if (sub!=0) {
                System.out.println("No"+" "+sub);
            }else {
                System.out.println("Yes" + " " + add);
            }
        }
    }
}

    