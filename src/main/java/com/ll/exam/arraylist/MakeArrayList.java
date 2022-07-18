package com.ll.exam.arraylist;




// 문제 : 사용자에게 숫자를 입력받고, 평균과 총합을 출력해주세요.
// 조건 : 처음에는 정수 5개를 받고, 평균과 총합을 출력해주세요.
// 조건 : 처음에는 실수 5개를 받고, 평균과 총합을 출력해주세요.
// 조건 : ArrayList 클래스를 직접구현해주세요.
// 조건 : ArrayList 클래스에 get, add, size, extendDatasSizeIfNeed(private) 메서드를 구현해주세요.
// 조건 : ArrayList 클래스에 제너릭을 적용해주세요.
// 조건 : Scanner 를 사용해주세요.


public class MakeArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();

        System.out.println("al.size() : " + al.size());
        // 출력 => al.size() : 0

        al.add(100);

        System.out.println("al.get(0) : " + al.get(0));
        // 출력 => al.get(0) : 100

        al.add(200);
        al.add(300);
        // 출력 => 배열의 크기가 증가되었습니다. 2 => 4

        System.out.println("al.size() : " + al.size());
        // 출력 => al.size() : 3

        System.out.println("al.get(1) : " + al.get(1));
        // 출력 => al.get(1) : 200

        al.removeAt(1);

        System.out.println("al.size() : " + al.size());
        // 출력 => al.size() : 2

        System.out.println("al.get(1) : " + al.get(1));
        // 출력 => al.get(1) : 300

        al.add(400);
        al.add(500);
        al.add(600);
        // 출력 => 배열의 크기가 증가되었습니다. 4 => 8
        System.out.println("al.size() : " + al.size());

        System.out.println("al.get(3) + al.get(4) : " + (al.get(3) + al.get(4)));
        // 출력 => al.get(3) + al.get(4) : 1100

        System.out.println("al.get(5) : "+al.get(5));
        // 출력 -> exception , indexOutOfBoundsException (throws exception 말고 일단 sys.err로 처리)

        System.out.println("al.get(3).intValue() + al.get(4).intValue() : " + (al.get(3).intValue() + al.get(4).intValue()));
        // 출력 => al.get(3) + al.get(4) : 1100

        al.showAllelements();
        // 출력 =>

        al.add(700, 1);
        al.showAllelements();

        al.add(750, 1);
        al.showAllelements();
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
    }
}
