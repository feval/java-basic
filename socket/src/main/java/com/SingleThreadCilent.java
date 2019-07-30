package com;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/29 15:47
 */
public class SingleThreadCilent {
    public static void main(String[] args) throws IOException {
        Socket client=new Socket("localhost",6666);   //127.0.0.1
        System.out.println("与服务器成功建立连接");
        PrintStream out=new PrintStream(client.getOutputStream());
        out.println("hi,i am client");
        Scanner in=new Scanner(client.getInputStream());
        if (in.hasNextLine()) {
            String s = in.nextLine();
            System.out.println("服务端发来的消息为:"+s);
        }
        in.close();
        out.close();
        client.close();
    }
}
