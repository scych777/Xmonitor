package com.kelvin.xmonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by admin on 20/12/2017.
 */
public class test {

    public static int getReversenum(int x){
        int reversenum = 0;
        while (x != 0){
            reversenum = reversenum * 10 + x % 10;
            System.out.println("x : " + x);
            x = x / 10;
        }
        return reversenum;
    }

    public static void main(String[] args){
        //int result = getReversenum(27);
        //System.out.println("Result : " + result);

    }
}
