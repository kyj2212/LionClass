package com.ll.exam.arraylist;

public class MakeArrayList {

    public static void main(String[] args) {

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
            if(isOverCapacity())
                grow();
            arr[size]=data;
            size++;
        }
    }
}
