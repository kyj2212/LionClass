package org.example.LionClass.d0706;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static String line = "Test 15 lqlq 35 bad 99999 guess 34";
    static String str1 = "30 + 40 + 20 + 40 + 20 + 50 + 11 + -6  + -100";

    public static void main(String[] args) {


        System.out.println("=== list vs arry ===");
        list_vs_array();

        System.out.println('\n'+"=== what is stream ===");
        sol_stream();
        sol_nostream();

        System.out.println("=== stream with negative int ===");
        so_stream_negative();

    }


    private static void printarr(int[] arr, List<Integer> list1, ArrayList<Integer> list2){
        System.out.println("initial Array size : "+arr.length);
        System.out.println("initial List size : "+list1.toString());
        System.out.println("initial ArrayList size : "+list2.size());
    }

    private static void list_vs_array(){
        int [] arr = new int[10];
        List<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();


        printarr(arr, list1, list2);

        System.out.println("== first add item ==");
        list1.add(10);
        list2.add(20);

        printarr(arr, list1, list2);


    }

    private static void sol_stream(){
        int sum = Arrays
                .stream(line.split(" "))
                .filter((s) -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("stream sum : "+sum);

    }

    private static void sol_nostream(){
        StringTokenizer st = new StringTokenizer(line, " ");
        int s=0;
        while(true){
            if(!st.hasMoreTokens()) {
                break;
            }
            String str = st.nextToken();
            if(str.matches("\\d+")) {
                s+=Integer.parseInt(str);
            }
        }
        System.out.println("no stream : "+s);
    }

    private static void so_stream_negative() {
        int result = (Arrays
                .stream(str1.split(" "))
                .filter((s) -> s.matches("^?\\d+")) // ?(값이 하나있거나 없을수도) 앞에 문자 - 가 있을 경우 포함
                .mapToInt(Integer::parseInt)
                .sum());

        System.out.println("stream result : "+result);
    }


}
