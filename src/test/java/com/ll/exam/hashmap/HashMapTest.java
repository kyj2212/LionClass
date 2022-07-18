package com.ll.exam.hashmap;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import com.ll.exam.arraylist.TestUtil;
import org.testng.annotations.Test;
import com.ll.exam.hashmap.UseHashMap.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class HashMapTest {

    @Test
    public void test__put_and_get_intValue(){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("영희",22);
        assertEquals((Integer)22, map.get("영희"));

    }


    @Test
    public void test__put_and_get_ObjectValue() throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("사람", new Human());

        TestUtil util = new TestUtil();
        ByteArrayOutputStream output = util.toByteArrayRedirection();

        ((Human)map.get("사람")).speak();

        assertEquals("사람이 말합니다.",util.readPrintByteArray(output) );
    }

    @Test
    public void test__put_same_key() throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("철수", 23);

        TestUtil util = new TestUtil();
        ByteArrayOutputStream output = util.toByteArrayRedirection();
        map.put("철수", 27);
        assertEquals("key 값 중복입니다.",util.readPrintByteArray(output) );

    }

    @Test
    public void test__remove() throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("영희", 22);
        map.put("철수", 23);

        assertEquals((Integer)22,map.remove("영희"));
        TestUtil util = new TestUtil();
        ByteArrayOutputStream output = util.toByteArrayRedirection();

        for ( String name : map.keySet() ) {
            System.out.println("이름 : " + name + ", 나이 : " + map.get(name));
        }
        assertEquals("이름 : 철수, 나이 : 23",util.readPrintByteArray(output) );
    }

    @Test
    public void test__keyset() throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("영희", 22);
        map.put("철수", 23);

        StringBuilder sb = new StringBuilder();
        for ( String name : map.keySet() ) {
            sb.append("이름 : " + name + ", 나이 : " + map.get(name)+"\n");
        }
        String rs= sb.toString();

        // keySet 은 set 이므로 두가지 중 한가지가 맞으면 된다.
        String case1="""
                        이름 : 영희, 나이 : 22
                        이름 : 철수, 나이 : 23\n""".stripIndent();
        String case2="""
                        이름 : 철수, 나이 : 23
                        이름 : 영희, 나이 : 22\n""".stripIndent();

        assertThat(rs.equals(case1)||rs.equals(case2)).isTrue();
        assertTrue(rs.equals(case1)||rs.equals(case2));

    }



    @Test
    public void test__real_vs_mine(){
        java.util.HashMap map = new java.util.HashMap<>();
        map.put("영희",22);
        map.get("영희");
        map.remove("영희");
        Integer a;
    }


}
