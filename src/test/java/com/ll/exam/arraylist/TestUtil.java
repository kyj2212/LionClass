package com.ll.exam.arraylist;

import org.testng.annotations.Test;

import java.io.*;

import static org.testng.AssertJUnit.assertEquals;

public class TestUtil {

    @Test
    public void test_redirect_printstream() throws IOException {

        File file = new File("test_sysout.txt");
        PrintStream pr = new PrintStream(new FileOutputStream(file));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("test_filewriter.txt"))));
        PrintStream sysout = System.out;
        System.out.println("It's console");
        System.setOut(pr);
        System.out.println("It's file");
        System.setOut(sysout);
        BufferedReader br = new BufferedReader(new FileReader(file));
        assertEquals("It's file",br.readLine());

    }


}
