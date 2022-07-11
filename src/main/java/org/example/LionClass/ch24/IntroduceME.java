package org.example.LionClass.ch24;

public class IntroduceME {
//code.oa.gg/java8/948
// 문제 : 아래 코드의 잘 못된 점을 고쳐보세요.

    public static void main(String[] args) {


        Human h1 = new Human();
        h1.name = "김예진";
        h1.age = 27;

        h1.introduce();
        // 출력 : 저는 22살 홍길동 입니다.

        Human h2 = new Human();
        h2.name = "홍길순";
        h2.age = 25;

        h2.introduce();
        // 출력 : 저는 25살 홍길순 입니다.

        h1.introduce();
        // 출력 : 저는 22살 홍길동 입니다.
    }
}
class Human {

    String name;
    int age;

    void introduce() {
        System.out.println("저는 " + this.age + "살 " + this.name + " 입니다.");
    }
}
