package com.shouxin.yy.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author aka-fk
 * @time 2023/8/30 10:18 下午
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true)
        ) {
            String body = null;
            while ((body=in.readLine()) != null && body.length() != 0) {
                System.out.println("the time server receive msg: " + body);
                out.println(new Date().toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
