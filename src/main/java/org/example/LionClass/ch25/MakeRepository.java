package org.example.LionClass.ch25;

// 가정 : 우리는 오라클 자바 개발팀에 취업을 했습니다. 우리는 자바 10의 새로운 기능은 `저장소` 클래스를 만들어야 합니다.
// 다음 코드가 오류없이 진행되도록 해주세요. 오류만 안나면 됩니다.


import java.util.ArrayList;

public class MakeRepository {


    public static void main(String[] args) {


        Repository.save(10);
        Repository.save("안녕");
        Repository.save(new Human());
        Repository.save(new Apple());
        Repository.save(5.5);
        Repository.save(false);
        Repository.save('a');


        System.out.println("== NON Boxing ==");
        // 정수 계열
        byte b = 0; // 1바이트
        char c = 1; // 2바이트
        short s = 2; // 2바이트
        int i = 3; // 4바이트
        long l = 4; // 8바이트

        // 실수 계열
        // 4.1f => float 형 실수를 의미
        float f = 3.14f; // 4바이트
        // 3.141592 => double 형 실수를 의미
        double d = 3.141592; // 8 바이트
        // 논리 계열
        boolean bl = false; // 1/8 바이트, 1비트

        Repository.save(b); // byte b=0
        Repository.save(c); // char c= 1
        Repository.save(s); // short s=2
        Repository.save(i); // int i=3
        Repository.save(l); // long l =4
        Repository.save(f); // float f = 3.14
        Repository.save(d); // double d = 3.141592
        Repository.save(bl); // bool bl = false


        System.out.println("== Boxing ==");
        // 정수 계열
        Byte b2 = 0; // 1바이트
        Character c2 = 1; // 2바이트
        Short s2 = 2; // 2바이트
        Integer i2 = 3; // 4바이트
        Long l2 = 4l; // 8바이트
        Float f2 = 3.14f;
        Double d2 = 3.141592; // 8 바이트
        Boolean bl2 = false; // 1/8 바이트, 1비트

        Repository.save(b2); // byte b=0
        Repository.save(c2); // char c= 1
        Repository.save(s2); // short s=2
        Repository.save(i2); // int i=3
        Repository.save(l2); // long l =4
        Repository.save(f2); // float f = 3.14
        Repository.save(d2); // double d = 3.141592
        Repository.save(bl2); // bool bl = false

        System.out.println("== MIN MAX VAL ==");
        System.out.println("Byte MIN : "+ Byte.MIN_VALUE);
        System.out.println("Byte MAX : "+ Byte.MAX_VALUE);

        System.out.printf("\\u0061 : %c \n",'\u0061');
        System.out.printf("97 : %c \n",97);
        System.out.printf("'a' to hex : %h \n",'a');
        System.out.printf("Character MIN(c) : %c \n",Character.MIN_VALUE);
        System.out.printf("Character MIN(h) : %h \n",Character.MIN_VALUE);
        System.out.printf("Character MIN(d) : %d \n",(int)Character.MIN_VALUE);
        System.out.printf("Character MAX(c) : %c \n",Character.MAX_VALUE);
        System.out.printf("Character MAX(h) : %h \n",Character.MAX_VALUE);
        System.out.printf("Character MAX(d) : %d \n",(int)Character.MAX_VALUE);
        System.out.println("Integer MIN : "+ Integer.MIN_VALUE);
        System.out.println("Integer MAX : "+ Integer.MAX_VALUE);
        System.out.println("Long MIN : "+ Long.MIN_VALUE);
        System.out.println("Long MAX : "+ Long.MAX_VALUE);
        System.out.println("Float MIN : "+ Float.MIN_VALUE);
        System.out.println("Float MAX : "+ Float.MAX_VALUE);
        System.out.println("Double MIN : "+ Double.MIN_VALUE);
        System.out.println("Double MAX : "+ Double.MAX_VALUE);


        System.out.println("=== 리턴타입 형변환 ===");
        int i1 =10;
        OutRepo r = new OutRepo();
        r.save(i1);
        System.out.println(r.get());


        System.out.println("=== 다형성 ===");
        Animal a1 = new Human();
        a1.speak();
        Object o1 = a1;
        Human h1 = (Human) o1;
        h1.speak();

    }


    // Inner Repo
    static class Repository{


        static ArrayList list = new ArrayList<>();
        static int cnt=0;

        static void save(Object o){
            list.add(o);
            System.out.println(list.get(cnt)+"이(가) 저장이 완료되었습니다.");
            cnt++;
        }

    }

    abstract private static class Animal{ abstract void speak();}

    private static class Human extends Animal {
        String name=this.getClass().getSimpleName();
        void speak(){
            System.out.println(this.name+"이(가) 말합니다.");
        }
    }

    private static class Apple { String freshness;}
}

class OutRepo{
    Object data;
    void save(Object o){
        data=o;
        System.out.println(data+"이(가) 저장이 완료되었습니다.");
    }
    Object get(){
        return data;
    }
}
