package org.example.LionClass.ch42;

import java.util.ArrayList;
import java.util.List;

public class ButtonObserver {

    public static void main(String[] args) {

        View aButton = new Button();
        aButton.addOnClickListener(new OnClickListener() {
            @Override
            public void onClick(String msg) {
                System.out.println("홍길동이 받은 메세지 : " + msg);
            }

            public void breath() {
                System.out.println("홍길동 : 숨쉬다.");
            }
        });
        aButton.addOnClickListener((msg)-> System.out.println("홍길순이 받은 메세지 : " + msg));
        aButton.fireClickEvent(); // 홍길순, 홍길동 모두 클릭이벤트를 받아야함.
        aButton.fireClickEvent();
    }

}
class View {
    private List<OnClickListener> onClickListeners;

    public View(){onClickListeners=new ArrayList<>();}

    public void addOnClickListener(OnClickListener onClickListener) {
        this.onClickListeners.add(onClickListener);
    }

    public void fireClickEvent(){
        System.out.println("뷰가 클릭되었습니다.");
        for(OnClickListener onClickListener : onClickListeners)
            onClickListener.onClick("클릭");
    }

}

class Button extends View { }

interface OnClickListener { public void onClick(String msg);}

/*class HongBoy implements OnClickListener {
    @Override
    public void onClick(String msg) {
        System.out.println("홍길동이 받은 메세지 : " + msg);
    }

    public void breath() {
        System.out.println("홍길동 : 숨쉬다.");
    }
}*/

/*
class HongGirl implements OnClickListener {
    @Override
    public void onClick(String msg) {
        System.out.println("홍길순이 받은 메세지 : " + msg);
    }
}*/
