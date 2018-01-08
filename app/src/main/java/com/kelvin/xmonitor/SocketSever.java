package com.kelvin.xmonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by admin on 20/12/2017.
 */
public class SocketSever implements Runnable {
    private Socket client = null;
    public  SocketSever(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while (flag){
                String str = buf.readLine();
                if(str == null || "".equals(str)){
                    flag = false;
                }else{
                    if(str.equals("bye")){
                        flag = false;
                    }else{
                        out.println("msg from sever : " + str);
                    }
                }
            }
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
