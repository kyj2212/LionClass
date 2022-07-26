package org.example.LionClass.ch40;


public class ObserverPattern {



    public static void main(String[] args) {
        sol01();
        System.out.println("=========");
        sol02();
    }


    static void sol01(){
        /*
        문제 : 사람 객체의 `안녕`이 `button.click();`에 의해 실행되도록 해주세요.
        조건 : Button에는 `사람` 이라는 언급이 없어야 합니다.
        */
        Button button = new Button();
        button.setListener(new Human());
        button.click();
    }


    interface Listener{
        public void listen(String msg);
    }
    interface ClickListener{
        public void onClick(String msg);
    }

    static class Button{

        private Listener listener;
        private ClickListener clickEventListener;

        void setListener(Listener listener){
            this.listener=listener;
        }

        void click(){
            listener.listen("버튼 click");
        }

        public void setClickEventListener(ClickListener clickEventListener) {
            this.clickEventListener=clickEventListener;
        }

        void fireClick(){
            clickEventListener.onClick("버튼 클릭");
        }
    }
    private static class Cat implements ClickListener{

        public void clickResponse(){
            System.out.println("고양이는 방금 버튼 클릭되었다는 사실을 전달받았습니다.");

        }
        @Override
        public void onClick(String msg) {
            clickResponse();
        }
    }
    private static class Dog  implements ClickListener{

        public void response(){
            System.out.println("강아지는 방금 버튼 클릭되었다는 사실을 전달받았습니다.");

        }
        @Override
        public void onClick(String msg) {
            response();
        }
    }
    private static class Owl implements ClickListener{

        public void getButtonClick(){
            System.out.println("부엉이는 방금 버튼 클릭되었다는 사실을 전달받았습니다.");
        }

        @Override
        public void onClick(String msg) {
            getButtonClick();
        }
    }

    static class Human implements Listener{
        public void hi() {
            System.out.println("Main::안녕!");
        }

        @Override
        public void listen(String msg) {
            hi();
        }
    }

    // 인터페이스를 사용
    static void sol02(){

            // no use 상속, 구현
            // 버튼 클래스는 모든 객체에게 클릭 사실을 알릴 수 있어야 한다.

            Button aButton = new Button();
            aButton.setClickEventListener(new Cat());
            aButton.fireClick();
            // 나(고양이)는 방금 버튼이 클릭되었다는 사실을 전달 받았습니다.

            aButton.setClickEventListener(new Dog());
            aButton.fireClick();
            // 나(개)는 방금 버튼이 클릭되었다는 사실을 전달 받았습니다.

            aButton.setClickEventListener(new Owl());
            aButton.fireClick();
        // 나(부엉이)는 방금 버튼이 클릭되었다는 사실을 전달 받았습니다.


    }







}
