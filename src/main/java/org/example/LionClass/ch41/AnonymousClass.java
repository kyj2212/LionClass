package org.example.LionClass.ch41;

public class AnonymousClass {

    public static void main(String[] args) {
        View.OnClickListener aOnClickListener;

        // 수정가능지역 시작
        // 수정가능지역 끝


        // 익명 클래스
/*
        aOnClickListener=new View.OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("클릭되었다는 사실을 전달받았습니다.");
            }
        };
*/


        // 람다식
        aOnClickListener=() -> System.out.println("클릭되었다는 사실을 전달받았습니다.");

        // 메서드 참조로는 의미 없다?

        aOnClickListener.onClick();
        // 출력 => 클릭되었다는 사실을 전달받았습니다.
    }

}
class View {
    static interface OnClickListener {
        public void onClick();
    }
}