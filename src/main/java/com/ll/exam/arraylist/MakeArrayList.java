package com.ll.exam.arraylist;




// 문제 : 사용자에게 숫자를 입력받고, 평균과 총합을 출력해주세요.
// 조건 : 처음에는 정수 5개를 받고, 평균과 총합을 출력해주세요.
// 조건 : 처음에는 실수 5개를 받고, 평균과 총합을 출력해주세요.
// 조건 : ArrayList 클래스를 직접구현해주세요.
// 조건 : ArrayList 클래스에 get, add, size, extendDatasSizeIfNeed(private) 메서드를 구현해주세요.
// 조건 : ArrayList 클래스에 제너릭을 적용해주세요.
// 조건 : Scanner 를 사용해주세요.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class MakeArrayList {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=== 정수 ===");
        System.out.println("정수 5개를 입력해 주세요. ex) 1 2 3 4 5");
        StringTokenizer st = new StringTokenizer(br.readLine()," ");


        ArrayList<Integer> intList = new ArrayList<>();
        while(st.hasMoreTokens())
            intList.add(Integer.parseInt(st.nextToken()));

        System.out.println("--- 결과 ---");
        System.out.println("총합 : "+intSum(intList)+" 평균 : "+ intSum(intList)/intList.size());


        System.out.println("=== 실수 ===");
        System.out.println("실수 5개를 입력해 주세요. ex) 1.1 2.2 3.3 4.1 5.5");
        st = new StringTokenizer(br.readLine()," ");


        ArrayList<Double> doubleList = new ArrayList<>();
        while(st.hasMoreTokens())
            doubleList.add(Double.parseDouble(st.nextToken()));

        System.out.println("--- 결과 ---");
        System.out.println("총합 : "+doubleSum(doubleList)+" 평균 : "+ doubleSum(doubleList)/doubleList.size());




    }

    private static double doubleSum(ArrayList<Double> list) {
        double sum=0.0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }

    static int intSum(ArrayList<Integer> list){
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }


    public static class ArrayList<E>{

        private final int initCapacity=4; // 실제 ArrayList = 10으로 잡혀있다.
        private Object[] arr;
        private int size;

        ArrayList() {
            this.arr=new Object[initCapacity];
            this.size=0;
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName();
        }

        public void add(E data) {
            add(data,size);
        }

        private boolean isOverCapacity() {
            //  int capacity = arr.length;
            if(size>= arr.length)
                return true;
            else return false;
        }

        private void grow() {
           // System.out.printf("배열의 크기가 " + arr.length);
            Object tmp[] = arr.clone();
            int newCapacity = size * 2;
            arr = new Object[newCapacity];
           // System.out.println("에서 " + arr.length + "으로 증가하였습니다.");
            for (int i = 0; i < size; i++) {
                arr[i] = tmp[i];
            }
        }

        public E get(int idx) {
            if(checkIdxBounds(idx))
                return (E)arr[idx];
            else return null;
        }




        private boolean checkIdxBounds(int idx) {
            if(idx<size) return true;
            System.err.println("[IndexOutBoundsException] get("+ idx+")은 boundary를 넘었습니다.");
            return false;
        }

        public int size() {
            return this.size;
        }

        public E removeAt(int del) {
            Object tmp,removed;
            removed = arr[del];
            for(int i=del; i<size;i++) {
                tmp = arr[i+1];
                arr[i] = tmp;
            }
            size--;
            return (E)removed;
        }

        public void showAllelements() {
            System.out.println("=== 전체 데이터 출력 ===");
            for(int i =0;i<size;i++){
                System.out.printf(arr[i]+" ");
            }
            System.out.println();
        }

        public void add(E data, int idx) {
            if(isOverCapacity())
                grow();
            Object [] tmp= new Object[size-idx];

            for(int i=0; i<size-idx;i++)
                tmp[i] = arr[i+idx];

            arr[idx]=data;
            for (int i=0;i<size-idx;i++)
                arr[i+idx+1]=tmp[i];

            size++;
        }

        public boolean contains(E data){
            for(int i=0;i<size;i++){
                if(arr[i].equals(data))
                    return true;
            }
            return false;
        }
    }
}
