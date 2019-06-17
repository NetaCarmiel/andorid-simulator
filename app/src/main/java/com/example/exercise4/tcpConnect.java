package com.example.exercise4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class tcpConnect {
    private Socket socket;
    private static tcpConnect s_instance = null;
    PrintWriter out;

    public static tcpConnect Instance() {
        if (s_instance == null){
            s_instance= new tcpConnect();
        }
        return s_instance;
    }

    public void connectToServer(final String ip, final int port) {
        final Thread outThread = new Thread() {
            @Override
            public void run() {
                try {
                    socket = new Socket(ip, port);
                    System.out.println("connected");
                    out= new PrintWriter(socket.getOutputStream());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        };
        outThread.start();
    }
    public void disConnect(){
        if (out != null) {
            out.close();
        }
        try {
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMesssage(final String message) {
        final Thread outThread = new Thread() {
            @Override
            public void run() {
                System.out.println("Started...");
                //PrintWriter out = null;
                try {
                    //out = new PrintWriter(socket.getOutputStream());
                    String messageStr = message;
                    out.println(message + "\r\n");
                    out.flush();

                } catch (Exception e) {
                    e.printStackTrace();
                } //finally {
                  //  if (out != null) {
                  //      out.close();
                  //  }
               // }
            }
        };
        outThread.start();
    }

}