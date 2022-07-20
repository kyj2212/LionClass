package org.example.LionClass.ch38;

public class SingleTonPattern {

    public static void main(String[] args) {
      //  sol01();
        System.out.println("============");
     //   sol02();
        System.out.println("============");
       // sol03();
        System.out.println("============");
        sol04();
    }

    static void sol01(){
        Human a;
        a=Human.getInstance();
        a.setAge(22);

        System.out.println("사람의 나이는 " + a.getAge() + "살 입니다.");
        // 출력 : 사람의 나이는 22살 입니다.
    }
    static void sol02() {
        Human[] humans = new Human[5];
        for(Human h : humans)
            h=Human.getHuman();

        System.out.println("실행완료");
    }


    static void sol03(){
        Human[] humans = new Human[5];
        for(Human h : humans){
            h=Human.getHuman();
            h.introduce();
        }

		/*
		// 출력
		저는 1번째 사람입니다.
		저는 2번째 사람입니다.
		저는 3번째 사람입니다.
		저는 4번째 사람입니다.
		저는 5번째 사람입니다.
		*/
    }


    static void sol04(){
        Human[] humans = new Human[7];
        for(Human h : humans){
            h=Human.getHuman();
            h.introduce();
        }

		/*
		// 출력
		저는 1번째 사람입니다.
		저는 2번째 사람입니다.
		저는 3번째 사람입니다.
		저는 3번째 사람입니다.
		저는 3번째 사람입니다.
		저는 3번째 사람입니다.
		저는 3번째 사람입니다.
		*/
    }



    static class Human {
        private int age;
        private int id;
        private static Human instance;
        private static final int maxInstance=3;
        private static int lastId;

        static {
            lastId=0;
        }


        private Human(int id) {

            this.id=id;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public static Human getHuman(){
            return new Human(getId());
        }


        private static int getId(){
            return lastId<maxInstance ? ++lastId :lastId;
        }

        public static Human getInstance(){
            if(instance==null)
                instance = new Human(getId());
            return instance;

        }

        public void introduce() {
            System.out.println("저는 "+this.id+"번째 사람입니다.");
        }
    }
}
