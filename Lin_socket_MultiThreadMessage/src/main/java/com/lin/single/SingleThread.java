package com.lin.single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 * Author:  llf
 * Created in 2019/7/30 15:54
 */
public class SingleThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(6666);
        System.out.println("等待客户端连接");
        Socket client=serverSocket.accept();
        System.out.println("客户端链接成功"+client.getPort());
        Scanner in =new Scanner(client.getInputStream());
        if (in.hasNextLine()) {
            System.out.println("客户端发来的消息:"+in.nextLine());
        }
        PrintStream out=new PrintStream(client.getOutputStream());
        out.println("i an socket");
        in.close();
        out.close();
        serverSocket.close();
    }
}
