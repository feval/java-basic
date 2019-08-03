package com.lin.single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 * Author:  llf
 * Created in 2019/7/30 15:58
 */
public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
        Socket client=new Socket("localhost",6666);
        System.out.println("与服务端建立连接");
        PrintStream out =new PrintStream(client.getOutputStream());
        out.println("hi,i am client");
        Scanner in=new Scanner(client.getInputStream());
        if (in.hasNextLine()) {
            String s=in.nextLine();
            System.out.println("服务器端发来的消息："+s);
        }
        in.close();
        out.close();
        client.close();
    }

}
