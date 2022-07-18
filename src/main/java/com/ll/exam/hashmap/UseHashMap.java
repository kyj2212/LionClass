package com.ll.exam.hashmap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;



public class UseHashMap {



    public static void main(String[] args) {

        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("영희", 22);
        ages.put("철수", 23);
        ages.put("민서", 25);
        ages.put("철수", 27);
        ages.remove("영희");
        ages.put("광수", 27);
        for ( String name : ages.keySet() ) {
            System.out.println("이름 : " + name + ", 나이 : " + ages.get(name));
        }
        /* 출력결과 */
        // 이름 : 철수, 나이 : 27
        // 이름 : 민서, 나이 : 25
        // 이름 : 광수, 나이 : 27
        HashMap<String, Object> everyone = new HashMap<>();
        everyone.put("사람", new Human());
        everyone.put("원숭이", new Monkey());
        ((Human)everyone.get("사람")).speak();
        // 출력 => 사람이 말합니다.
        ((Monkey)everyone.get("원숭이")).performSkill();
        // 출력 => 원숭이가 묘기를 부립니다.
    }

    public static class Human {
        public void speak() {
            System.out.println("사람이 말합니다.");
        }
    }

    private static class Monkey {
        public void performSkill() {
            System.out.println("원숭이가 묘기를 부립니다.");
        }
    }

    public static class HashMap<T,E>{

        Set<T> keySet;

        ArrayList<Data> data;

        int initcapacity=10;
        int size;

        HashMap(){
            this.keySet=new HashSet<>();
            this.data=new ArrayList<>();
        }

        public Set<T> keySet(){
            return this.keySet;
        }

        public void put(T key, E value) {
            if(keySet.contains(key))
                System.out.println("key 값 중복입니다.");
                else{
                    keySet.add(key);
                    data.add(new Data(key,value));
                    size++;
                }

        }

        private int getIdx(T key){
            if(!keySet.contains(key))
                return -1;
            for(int i=0;i<size;i++){
                if(data.get(i).getKey().equals(key))
                    return i;
            }
            return -1;
        }

        public E get(T key) {
            int idx=getIdx(key);
            if(idx>=0)
                return (E) data.get(idx).getValue();
            else return null;
        }

        public E remove(T key) {
            Data del = data.get(getIdx(key));
            data.remove(del);
            keySet.remove(del.getKey());
            size--;
            return (E)del.getValue();
        }


        static class Data<T,E>{
            private Object key;
            private Object value;
            Data(T key, E value){
                this.key=key;
                this.value=value;
            }
            public E getValue(){
                return (E)this.value;
            }

            public T getKey() {
                return (T)this.key;
            }
        }


    }


}
