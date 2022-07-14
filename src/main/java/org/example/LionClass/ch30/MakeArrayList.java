package org.example.LionClass.ch30;

public class MakeArrayList {

    public static void main(String[] args) {


        ArrayList ar = new ArrayList();
        ar.add(100);
        ar.add(200);
        ar.add(300);

        int value = ar.get(0);
        System.out.println(value);
        // 출력 : 100

        value = ar.get(1);
        System.out.println(value);
        // 출력 : 200

        value = ar.get(2);
        System.out.println(value);
        // 출력 : 300

    }

    static class ArrayList{

        int initsize=10;
        int arr [];
        int startidx;

        ArrayList() {
            this.arr=new int[initsize];
            startidx=0;
        }

        void grow(){
            if(startidx > arr.length)
                arr = new int[startidx*2];
        }

        void add(int data){
            grow();
            arr[startidx]=data;
            startidx++;
        }

        public int get(int i) {
            return arr[i];
        }
    }
}
