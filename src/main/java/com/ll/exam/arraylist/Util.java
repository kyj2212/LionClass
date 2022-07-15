package com.ll.exam.arraylist;

import java.io.*;

public class Util {

    public PrintStream toFileRedirection(String filename) throws FileNotFoundException {
        File file = new File(filename);
        PrintStream pr = new PrintStream(new FileOutputStream(file));
        PrintStream sysout = System.out;
        System.setOut(pr);
      //  System.out.println("It's file");
       // System.setOut(sysout);

        //BufferedReader br = new BufferedReader(new FileReader(file));
        return sysout;
    }

    void toConsoleRedirection(PrintStream sysout){
        System.setOut(sysout);
    }
}
