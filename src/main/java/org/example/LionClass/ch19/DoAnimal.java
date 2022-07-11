package org.example.LionClass.ch19;

//code.oa.gg/java8/938
// 문제 : 아래와 같이 출력되도록 해주세요. init() 메세드에 의해서 출력되어야 합니다.
// 조건 : 사람 클래스의 생성자는 사용할 수 없습니다.
// 힌트 : 모든 생성자는 자신의 일을 하기 전에 super(); 부터 실행합니다.
// 힌트 : 모든 생성자는 자신의 일을 하기 전에 부모클래스의 생성자 부터 실행합니다.


public class DoAnimal {


    public static void main(String[] args) {

       // new Human();


    }

}

abstract class Animal {
    Animal(){init();}
    abstract void init();
}
class Human extends Animal{

    String name;
    int age;

    private Human(){this("예진",27);};
    private Human(String name, int age){
        this.name=name;
        this.age=age;
    }

    //public static Human getInstance(){
        //return instance;
    //}


    void init(){
       // this("없음",0); // this() 는 반드시 생성자의 first statement에 있어야 한다.
        System.out.println("사람이 "+this.name+","+this.age+"으로 초기화 됩니다.");}
}

class Cat extends Animal{
    String color;
    void init(){
        System.out.println("고양이가 초기화 됩니다.");
    }
}