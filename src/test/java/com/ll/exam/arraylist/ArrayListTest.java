package com.ll.exam.arraylist;

import com.ll.exam.arraylist.MakeArrayList.ArrayList;
import org.testng.annotations.Test;

import java.io.PrintStream;

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
        alist.add();
    }

    @Test
    public void test__get(){
        ArrayList<Integer> alist = new ArrayList<>();
        alist.add();
    }

}
