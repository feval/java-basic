package com.test1;

import com.sun.org.apache.xalan.internal.xsltc.runtime.InternalRuntimeError;

import java.util.Scanner;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/19 23:29
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            String[] s1 = str1.split(" ");
            int count = Integer.parseInt(s1[0]);
            int init = Integer.parseInt(s1[1]);
            int[] guaiwu = new int[count];
            String[] s2 = str2.split(" ");
            for (int i = 0; i < count; i++) {
                guaiwu[i] = Integer.parseInt(s2[i]);
            }
            for (int gw:guaiwu) {
                if (init>gw) {
                    init+=gw;
                }else {
                    init+=divisors(init,gw);
                }
            }
            System.out.println(init);

        }
    }

    public static int divisors(int a, int b) {
        int count = a;
        int max = 1;
        if (a > b) {
            count = b;
        }
        for (int i = 1; i <= count; i++) {
            if (a % i == 0 && b % i == 0) {
                max = i;
            }
        }
        return max;
    }
}
