package bettich;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Solution859 {
    public static boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length()) {
            return false;
        }
        char[] data1=A.toCharArray();
        char[] data2=B.toCharArray();
        int count=0;
        char[] str=null;
        while(A.equals(B)) {
//            Set<Character> set=new HashSet<>();
//            for (int i = 0; i <A.length(); i++) {
//             if (set.contains(A.charAt(i))) {
//               return true;
//            }else
//            set.add(A.charAt(i));
//            }
            int[] charNum=new int[255];
            for (int i = 0; i <data1.length; i++) {
                char c=data1[i];
                if (c<='z'&&c>='a') {
                    charNum[c]++;
                    if (charNum[c]>1) {
                        return true;
                    }
                }
            }
                return false;
        }
        for (int i=0;i<data1.length&&i<data2.length;i++) {
            if(data1[i]<96||data2[i]<96) {
                return false;
            }
            if (data1[i]==data2[i]) {
                continue;
            }
            count++;
            if (count>2) {
                return false;
            }
            if (str==null) {
                str=new char[2];
               str[0]=data1[i];
               str[1]=data2[i];
            }else if (data1[i]==str[1]&&data2[i]==str[0]) {
                if (i+1<A.length()) {
                    String str1 = A.substring(i + 1);
                    String str2 = B.substring(i + 1);
                    if (str1.equals(str2)) {
                        return true;
                    }
                    return false;
                }else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("abc","abc"));
    }
}
