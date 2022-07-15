package com.ll.exam.arraylist;

import javax.swing.*;
import java.io.*;

public class Util {

    private final static PrintStream sysout = System.out;

    public void toFileRedirection(String filename) throws FileNotFoundException {
        File file = new File(filename);
        PrintStream pr = new PrintStream(new FileOutputStream(file));
        PrintStream sysout = System.out;
        System.setOut(pr);
      //  System.out.println("It's file");
       // System.setOut(sysout);

        //BufferedReader br = new BufferedReader(new FileReader(file));

    }

    void toConsoleRedirection(){
        System.setOut(sysout);
    }


    String readPrint(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        String printed = br.readLine();
        br.close();
        toConsoleRedirection();
        return printed;

    }
}
