package com.best.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author cctv14
 * @data 2023/11/15 21:58
 * @description TCP 服务端
 */
public class TcpServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            boolean flag = true;
            while (flag) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    baos.write(bytes, 0, len);
                }
                if ("exit".equalsIgnoreCase(baos.toString())) {
                    flag = false;
                } else {
                    System.out.println(baos.toString());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
