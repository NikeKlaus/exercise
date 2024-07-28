package com.best.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author cctv14
 * @data 2023/11/15 21:57
 * @description TCP 客户端
 */
public class TcpClient {
    public static void main(String[] args) {
        try {
            boolean flag = true;
            while (flag) {
                InetAddress serverIp = InetAddress.getByName("127.0.0.1");
                int port = 8080;
                try (Socket socket = new Socket(serverIp, port)) {
                    Scanner scanner = new Scanner(System.in);
                    String message = scanner.nextLine();
                    if ("exit".equalsIgnoreCase(message)) {
                        flag = false;
                    } else {
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write(message.getBytes());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
