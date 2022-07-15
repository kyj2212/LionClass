package com.ll.exam.arraylist;

import com.ll.exam.arraylist.MakeArrayList.ArrayList;
import org.testng.annotations.Test;
import com.ll.exam.arraylist.Util;

import java.io.*;

import static org.testng.AssertJUnit.*;

public class ArrayListTest {

    @Test
    public void test__isArrayList(){
        ArrayList<Integer>  alist = new ArrayList<>();
        assertEquals("ArrayList", alist.toString());
    }
    @Test
    public void test__add_lastidx(){
        ArrayList<Integer> alist = new ArrayList<>();
        alist.add(100);
    }

    @Test
    public void test__growCapacity() throws IOException {
        ArrayList<Integer> alist = new ArrayList<>();
        Util util = new Util();
        PrintStream sysout = util.toFileRedirection("grow.txt");
        alist.add(100);
        alist.add(200);
        alist.add(300);
        alist.add(400);
        alist.add(500);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("grow.txt")));
        assertEquals("배열의 크기가 4에서 8으로 증가하였습니다.", br.readLine());
        br.close();
        util.toConsoleRedirection(sysout);
        //System.out.println("console back");
    }

    @Test
    public void test__get(){
        ArrayList<Integer> alist = new ArrayList<>();
        alist.add(100);
        assertEquals(100,alist.get(0).intValue());
    }

    @Test
    public void test__getsize(){
        ArrayList<Integer> alist = new ArrayList<>();
        alist.add(100);
        assertEquals(1, alist.size());
    }

    @Test
    public void test__removeAt(){
        ArrayList<Integer> alist = new ArrayList<>();
        alist.add(100);
        alist.add(200);

        assertEquals(100,alist.get(0).intValue());
        assertEquals(100,alist.removeAt(0).intValue());
        assertEquals(200,alist.get(0).intValue());
    }



}
