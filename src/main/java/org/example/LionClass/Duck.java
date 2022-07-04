package org.example.LionClass;
// 문제 : 아래와 같이 출력되도록 해주세요.
// 조건 : 소스코드 중복이 없어야 합니다.
// 조건 : 복잡한 상속을 써도 됩니다.


public class Duck {
    String name;

    Duck(){
        this("오리");
    }

    Duck(String name){
        this.name=name;
        System.out.println(name+"은 "+this.getClass().getSimpleName()+"입니다.");
    }

    void fly(){
        System.out.println(name+"은 날개로 날아갑니다.");
    }

    void swim(){
        System.out.println(name+"은 물갈퀴로 수영합니다.");
    }
}

class MallardDuck extends Duck{

    MallardDuck(String name) {
        super(name);
    }
}

class WhiteDuck extends Duck{

    WhiteDuck(String name) {
        super(name);
    }
}

class RubberDuck extends RobotDuck{

    RubberDuck(String name) {
        super(name);
    }
    void fly(){
        System.out.println(this.name+"은 날 수 없습니다.");
    }
}

class RobotDuck extends Duck{

    RobotDuck(String name){
        super(name);
    }

    void swim(){
        System.out.println(this.name+"는 물에 떠다닙니다.");
    }
}


class DuckMove {
    public static void main(String[] args) {
        System.out.println("== 청둥오리 ==");
        MallardDuck a1 = new MallardDuck("청둥오리1");
        a1.fly(); // 오리가 날개로 날아갑니다.
        a1.swim(); // 오리가 물갈퀴로 수영합니다.

        System.out.println("== 흰오리 ==");
        WhiteDuck a2 = new WhiteDuck("흰오리1");
        a2.fly(); // 오리가 날개로 날아갑니다.
        a2.swim(); // 오리가 물갈퀴로 수영합니다.

        System.out.println("== 고무오리 ==");
        RubberDuck a3 = new RubberDuck("고무오리1");
        a3.fly(); // 저는 못 날아요 ㅠㅠ
        a3.swim(); // 오리가 물에 둥둥 떠다닙니다.

        System.out.println("== 고무2오리 ==");
        RubberDuck a4 = new RubberDuck("고무오리2");
        a4.fly(); // 저는 못 날아요 ㅠㅠ
        a4.swim(); // 오리가 물에 둥둥 떠다닙니다.

        System.out.println("== 로봇오리 ==");
        RobotDuck a5 = new RobotDuck("로봇오리1");
        a5.fly(); // 오리가 날개로 날아갑니다.
        a5.swim(); // 오리가 물에 둥둥 떠다닙니다.
    }
}