package com.shouxin.yy.bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author aka-fk
 * @time 2023/8/30 10:05 下午
 */
public class BioServer {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("the server is start in port: " + PORT);
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
