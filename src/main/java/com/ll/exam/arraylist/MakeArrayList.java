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

        private boolean isOverCapacity() {
            //  int capacity = arr.length;
            if(size>= arr.length)
                return true;
            else return false;
        }

        private void grow() {
            System.out.printf("배열의 크기가 " + arr.length);
            Object tmp[] = arr.clone();
            int newCapacity = size * 2;
            arr = new Object[newCapacity];
            System.out.println("에서 " + arr.length + "으로 증가하였습니다.");
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
    }
}
