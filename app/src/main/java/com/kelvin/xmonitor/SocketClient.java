package com.kelvin.xmonitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by admin on 20/12/2017.
 */
public class SocketClient {
    public static void main(String[] args) throws Exception{
        Socket client = new Socket("127.0.0.1",20006);
        client.setSoTimeout(10*1000);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(client.getOutputStream());
        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        boolean flag = true;
        while(flag){
            System.out.print("Info : ");
            String str = input.readLine();
            out.println(str);
            if("bye".equals(str)){
                flag = false;
            }else{
                String result = buf.readLine();
                System.out.println(result);
            }
        }
        input.close();
        if(client != null){
            client.close();
        }
    }
}
