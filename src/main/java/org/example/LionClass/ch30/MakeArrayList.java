package org.example.LionClass.ch30;


import java.util.ArrayList;

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


      //  System.out.println("al.get(3) + al.get(4) : " + (al.get(3) + al.get(4)));
        // 출력 => al.get(3) + al.get(4) : 1100

        System.out.println("al.get(5) : "+al.get(5));
        // 출력 -> exception , indexOutOfBoundsException (throws exception 말고 일단 sys.err로 처리)

        System.out.println("al.get(3).intValue() + al.get(4).intValue() : " + (al.get(3).intValue() + al.get(4).intValue()));
        // 출력 => al.get(3) + al.get(4) : 1100

        al.showAllValues();
        // 출력 =>
		/*
		== 전체 데이터 출력 ==
		0 : 100
		1 : 300
		2 : 400
		3 : 500
		4 : 600
		*/

        al.add(700, 1);
//        al.showAllValues();

        al.add(750, 1);
        al.showAllValues();
        // 출력 =>
		/*
		== 전체 데이터 출력 ==
		0 : 100
		1 : 750
		2 : 700
		3 : 300
		4 : 400
		5 : 500
		6 : 600
		*/

    }

    public static class ArrayList<E> {

        private final int initCapacity=4; // 실제 ArrayList = 10으로 잡혀있다.
        private Object[] arr;
        private int size;

        ArrayList() {
            this.arr=new Object[initCapacity];
            this.size=0;
        }

        public int size(){
            return size;
        }

        private void grow(){
            System.out.printf("배열의 크기가 "+arr.length);
            Object tmp [] = arr.clone();
            int newCapacity = size*2;
            arr = new Object[newCapacity];
            System.out.println("에서 "+arr.length+"으로 증가하였습니다.");
//            System.out.printf("grow : ");
            for(int i =0;i<size;i++){
                arr[i]=tmp[i];
            }
/*
            for(Object i : arr)
                System.out.printf(i+",");
            System.out.println();
*/
        }

        private boolean isOverCapacity(){
          //  int capacity = arr.length;
            if(size>= arr.length)
                return true;
            else return false;
        }

        public void add (E data, int idx){
            if(isOverCapacity())
                grow();
            Object [] tmp= new Object[size-idx];

            for(int i=0; i<size-idx;i++)
                tmp[i] = arr[i+idx];

            arr[idx]=data;
            for (int i=0;i<size-idx;i++)
                arr[i+idx+1]=tmp[i];

            size++;


/*
            System.out.printf("arr : ");
            for(Object i : arr)
                System.out.printf(i+",");
            System.out.println();
*/
        }

        /*
        void add (int intData){
            grow();
            Data data = new Data(intData);
            arr[size]=data;
            size++;
            System.out.printf("arr : ");
            for(Object i : arr)
                System.out.printf(i+",");
            System.out.println();
        }
*/


        public void add(E data){
            add(data,size);
        }



        public E get (int i){

            if(checkIdxBounds(i))
                return (E)arr[i];
            else return null;
        }

        private boolean checkIdxBounds(int idx) {
            if(idx<size) return true;
            System.err.println("[IndexOutBoundsException] get("+ idx+")은 boundary를 넘었습니다.");
            return false;
        }

        public void removeAt(int del) {
            Object tmp;
            for(int i=del; i<size;i++) {
                tmp = arr[i+1];
                arr[i] = tmp;
            }
            size--;
/*
            System.out.printf("remove : ");
            for(Object i : arr)
                System.out.printf(i+",");
            System.out.println();
*/
        }

        public void showAllValues() {
            System.out.println("== 전체 데이터 출력 ==");
            for(int i=0;i<size;i++){
                System.out.println(i+" : "+arr[i]);
            }
        }
    }

    /*
    public static class Data{
        private Object data;
        public Data(Object data){
            this.data = data;
        }
        public Integer intValue() {return (Integer) data;}
        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

     */
}

