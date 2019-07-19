package cn.bite.travel.dao.impl;
import java.util.Scanner;
/**
 * Description:
 * Author:  llf
 * Created in 2019/7/18 22:48
 */

public class Main{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextLine()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            int a = Integer.parseInt(str1);
            String[] s =str2.split(" ");
            int c=subMax(s,a);
            System.out.println(c);
        }
    }
    public static int subMax(String[] s,int a) {
        int[] b=new int[a];
        for(int i=0;i<a;i++) {
            b[i]=Integer.parseInt(s[i]);
        }
        int max=b[0];
        int sum=0;
        boolean flag=true;
        for(int j=0;j<a;j++) {
            sum+=b[j];
         if (sum>max) {
             max=sum;
         }
         if (sum<0) {
             sum=0;
         }
        }
        return max;
    }
}