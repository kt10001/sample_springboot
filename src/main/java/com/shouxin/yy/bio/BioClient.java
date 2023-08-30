package com.shouxin.yy.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author aka-fk
 * @time 2023/8/30 10:34 下午
 */
public class BioClient {
    private final static int PORT = 8080;
    private final static String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(HOST, PORT);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            out.println("hello");
            String resp = in.readLine();
            System.out.println("服务器时间: " + resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
