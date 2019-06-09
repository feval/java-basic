package test;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/30 22:39
 */
public class Main {
    public static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            String str3 = in.nextLine();
            int a = Integer.parseInt(str1);
            String[] arr1 = str2.split(" ");
            String[] arr2 = str3.split(" ");
            System.out.println(df.format(jiDain(a, arr1, arr2)));
        }
    }

    private static double jiDain(int a, String[] arr1, String[] arr2) {
        double xfjd = 0;
        int kcxf = 0;
        for (int i = 0; i < a; i++) {
            double k = 0;
            int xuefen = Integer.parseInt(arr1[i]);
            int chenji = Integer.parseInt(arr2[i]);
            if (chenji <= 100 && chenji >= 90) {
                k = 4.0;
            }
            if (chenji <= 89 && chenji >= 85) {
                k = 3.7;
            }
            if (chenji <= 84 && chenji >= 82) {
                k = 3.3;
            }
            if (chenji <= 81 && chenji >= 78) {
                k = 3.0;
            }
            if (chenji <= 77 && chenji >= 75) {
                k = 2.7;
            }
            if (chenji <= 74 && chenji >= 72) {
                k = 2.3;
            }
            if (chenji <= 71 && chenji >= 68) {
                k = 2.0;
            }
            if (chenji <= 67 && chenji >= 64) {
                k = 1.5;
            }
            if (chenji <= 63 && chenji >= 60) {
                k = 1.0;
            }
            if (chenji < 60) {
                k = 0.0;
            }
            xfjd += k * xuefen;
            kcxf += xuefen;
        }
        return xfjd / kcxf;
    }
}

