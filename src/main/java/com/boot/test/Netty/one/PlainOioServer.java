package com.boot.test.Netty.one;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author WangW
 * @date 2021/05/06 15:48
 * @description 阻塞I/O
 */
public class PlainOioServer {

    public void serve(int port) throws IOException {
        //等待客户端的请求，绑定传递的端口号
        final ServerSocket socket = new ServerSocket(port);
        for (;;) {
            //以阻塞的方式监听套接字的连接并接收，直到建立连接
            final Socket clientSocket = socket.accept();
            //输出客户端发送的消息
            System.out.println("Accepted connection from " + clientSocket);
            //开启一个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //建立一个输出流
                    OutputStream out;
                    try {
                        //返回此套接字的输出流。
                        out = clientSocket.getOutputStream();
                        //写入流信息
                        out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                        //如果先前写入的任何字节已被输出流的实现缓冲，则应立即将这些字节写入其预期目的地。
                        out.flush();
                        //关闭连接中的套接字
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            //关闭连接中的套接字
                            clientSocket.close();
                        } catch (IOException e) {
                            // ignore on close
                        }
                    }
                }
            }).start();
        }
    }
}
