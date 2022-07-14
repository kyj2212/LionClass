package org.example.LionClass.ch1to13;

public class TurtleMove {
    public static void main(String[] args) {
        Turtle t1 = new Turtle();
        t1.walk();
        t1.swim();
    }
}

class Turtle {
    String name;

    Turtle(){
        this("느린 거북이");
    }
    Turtle(String name){
        this.name=name;
    }
    void walk(){
        System.out.println(this.name+"거북이가 걷는다.");
    }
    void swim(){
        System.out.println(this.name+"거북이가 수영한다.");
    }
}
