package org.example.LionClass.ifconductor;


import java.util.LinkedList;

class Human {
    String name;
    int old;
    int num;
    Human(String name, int old){
        this.name=name;
        this.old=old;
    }
    void introduce(){
        System.out.println("저는 "+num+"번, "+this.name+", "+this.old+"살 입니다.");
    }
}



public class HRM {

    //HumanList hlist;
    int cnt;
    Human prev;
    Human next;
    LinkedList<Human> list = new LinkedList<>();


    void add(Human h){
        cnt++;
      //  this.hlist.h=h;
       // this.hlist.num=cnt;
        h.num=cnt;
        this.list.push(h);
        System.out.println("나이가 "+h.old+"살인 "+cnt+"번째 사람("+h.name+")이 추가되었습니다.");

    }
    void setNum (int n){

    }
    Human getHuman(int n){
        //if(this.list.get(n));
        // list.get(n).num=n;
        return list.get(n);
    }

}

class Main {
    public static void main(String[] args) {
        HRM a = new HRM();
        a.add(new Human("홍길순",33));
        a.add(new Human("홍길동",20));
        a.add(new Human("임꺽정",30));
        a.add(new Human("김예진",27));

        Human h1 = a.getHuman(1);
        h1.introduce();

    }
}


class HumanList {
    Human h;
    int num;
}