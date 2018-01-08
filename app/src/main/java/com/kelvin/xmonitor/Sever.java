package com.kelvin.xmonitor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 20/12/2017.
 */
public class Sever {
    public static void main(String[] args){
        try {
            ServerSocket server = new ServerSocket(20006);
            Socket client = null;
            while(true){
                client = server.accept();
                System.out.println("Client logged in");
                new Thread(new SocketSever(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
