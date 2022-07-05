package org.example.LionClass.ifconductor;


import java.util.LinkedList;

class Human {
    String name;
    int old;
    int num;
    Human before;
    Human next;



    Human(String name, int old){
        this.name=name;
        this.old=old;
    }
    void setNum(int num){
        this.num=num;
    }
    boolean isFirst(){
        if(this.before==null)
            return true;
        else return false;
    }
    boolean isLast(){
        if(this.next==null)
            return true;
        else return false;
    }
    int getNum(){
       return this.num;
    }
    String getName(){
        return this.name;
    }

    void setBefore(Human h){
        this.before=h;
    }
    void setNext(Human h){
        this.next=h;
    }

    void introduce(){
        System.out.println("저는 "+this.num+"번, "+this.name+", "+this.old+"살 입니다.");
    }
}

public class HRM {


    Human h;
    static int cnt;
    int max = 3; // 최대 10명

    void add(Human h) {
        Human tmp;
        this.cnt++;
        if(cnt==1)
            this.h = h;
        else {
            tmp=this.h;
            this.h=h;
            this.h.setBefore(tmp);
            tmp.setNext(h);
        }
        this.h.setNum(this.cnt);
        System.out.println("나이가 " + h.old + "살인 " + this.h.num + "번째 사람(" + this.h.name + ")이 추가되었습니다.");
    }

    Human getHuman(int n) {


        while(!this.h.isFirst()){
            this.h=this.h.before;
        }

        while (true) {
            if (this.h.getNum() == n)
                    return this.h;
            else if(!this.h.isLast()){
                    this.h=this.h.next;
                }
                else break;
            }
        System.out.println("현재 인력이 없습니다.");
        return null;

    }
}



class HRMList {


    static int cnt;
    LinkedList<Human> list = new LinkedList<>();

    void add(Human h) {

        cnt++;
        this.list.add(h);
        h.setNum(cnt);

        Human me = this.list.peekLast();

        System.out.println("나이가 " + h.old + "살인 " + me.getNum() + "번째 사람(" + me.getName() + ")이 추가되었습니다.");
    }

    Human getHuman(int n) {


        if(!this.list.isEmpty()){
            return this.list.get(n-1);
        }
        System.out.println("현재 인력이 없습니다.");
        return null;

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

        Human h4 = a.getHuman(4);
        h4.introduce();

        Human h2 = a.getHuman(2);
        h2.introduce();

        Human h3 = a.getHuman(3);
        h3.introduce();

        System.out.println("=== Linked List ===");
        HRMList l = new HRMList();
        l.add(new Human("홍홍홍",33));
        l.add(new Human("길길길",20));
        l.add(new Human("라라라",30));
        l.add(new Human("김예진",27));

        Human h5 = l.getHuman(1);
        h5.introduce();

        Human h8 = l.getHuman(4);
        h8.introduce();

        Human h6 = l.getHuman(2);
        h6.introduce();

        Human h7 = l.getHuman(3);
        h7.introduce();



    }
}


