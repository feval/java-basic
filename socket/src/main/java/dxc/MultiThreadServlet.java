package dxc;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;


/**
 * Description:
 * Author:  llf
 * Created in 2019/6/29 17:40
 */
public class MultiThreadServlet {
    private static Map<String,Socket> clientmap=new ConcurrentHashMap<>();
    private static class ExecuteClientMsg implements Runnable{
        private Socket client;

        public ExecuteClientMsg(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            Scanner in=null;
            try {
                in =new Scanner(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true) {
                String str = in.nextLine();
                if (str.startsWith("R:")) {
                   String name= str.split(":")[1];
                    register(name,client);
                }
                if (str.startsWith("P:")) {
                    String name = str.split(":")[1].split("-")[0];
                    String message = str.split("-")[1];
                    privateChat(name,"私聊信息为:"+message);
                }
                if (str.startsWith("G:")) {
                    String message= str.split(":")[1];
                    groupChat("群聊消息为:"+message);
                }
                if (str.contains("bye")) {
                    quit(str);
                    break;
                }
            }
        }

        private void quit(String str) {
            Collection<Socket> sockets = clientmap.values();
            for (Socket cliean:sockets) {
            }
        }

        private void privateChat(String name, String message) {
            Socket client=clientmap.get(name);
            try {
                PrintStream out=new PrintStream(client.getOutputStream(),true,"UTF-8");
                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void groupChat(String message) {
            Collection<Socket> sockets = clientmap.values();
            for (Socket client:sockets) {
                try {
                    PrintStream out=new PrintStream(client.getOutputStream(),true,"UTF-8");
                    out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void register(String name,Socket client) {
            clientmap.put(name,client);
            groupChat(name+"已上线");
            System.out.println("当前在线用户个数"+clientmap.size());
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(6666);
        ExecutorService serviceSocket= Executors.newFixedThreadPool(20);
        for (int i = 0; i <20 ; i++) {
            System.out.println("等待客户连接....");
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接,端口号为:"+client.getPort());
            serviceSocket.submit(new ExecuteClientMsg(client));
        }
        serverSocket.close();
    }
}
