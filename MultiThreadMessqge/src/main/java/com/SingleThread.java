package com;



import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/29 15:45
 */
public class SingleThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(6666);
        System.out.println("等待客户端连接....");
        Socket client=serverSocket.accept();
       // System.out.println("客户端连接成功"+client.getPort());
        System.out.println("客户端连接成功");
        Scanner in=new Scanner(client.getInputStream());
        if (in.hasNextLine()) {
            System.out.println("客户端发来的消息:"+in.nextLine());
        }
        PrintStream out=new PrintStream(client.getOutputStream());
        out.println("i am socket");
        in.close();
        out.close();
        serverSocket.close();
    }
}
