package org.example.LionClass;

// 문제 : 사람을 말하게 해주세요.
public class TalkingPeople {
    public static void main(String[] args) {
        Person p1 = new Person("예진");
        p1.talk();
        p1.talk("졸려");
    }
}

class Person {
    String name;

    Person(){
        this("예진");
    }

    Person(String name){
        this.name = name;
    }
    // 사람은 `말하다` 라는 기능을 가지고 있습니다.
    void talk() {
        System.out.println(this.name+"이 말합니다.");
    }
    void talk(String what){
        System.out.println(this.name+"이 \""+what+"\"라고 말합니다.");
    }
}
