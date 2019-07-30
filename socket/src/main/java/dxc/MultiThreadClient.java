package dxc;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Description:
 * Author:  llf
 * Created in 2019/6/29 17:25
 */
public class MultiThreadClient {

    private static class SendMsgToServer implements Runnable {
        private Socket client;

        public SendMsgToServer(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
                Scanner in =new Scanner(System.in);
                PrintStream out2Server = null;
                try {
                    out2Server = new PrintStream(client.getOutputStream(), true, "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (in.hasNextLine()) {
                    out2Server.println(in.nextLine());
                }
            while (true) {
                System.out.println("亲输入信息:");
                if (in.hasNextLine()) {
                    String str2Server = in.nextLine();
                    out2Server.println(str2Server);
                    if (str2Server.contains("bye")) {
                        System.out.println("客户端退出");
                        break;
                    }
                }
            }
            in.close();
            out2Server.close();
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ReadMsgFromServer implements Runnable {
        private Socket client;
        public ReadMsgFromServer(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            Scanner in = null;
            try {
                in = new Scanner(client.getInputStream());
                while (true) {
                    if (client.isClosed()) {
                        System.out.println("客户端已退出");
                    }
                    if (in.hasNextLine()) {
                        String strFromServer = in.nextLine();
                        System.out.println("服务器端发来的消息:" +strFromServer);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{
                in.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 6666);
        Thread th1 = new Thread(new SendMsgToServer(client));
        Thread th2 = new Thread(new ReadMsgFromServer(client));
        th1.start();
        th2.start();
    }
}
