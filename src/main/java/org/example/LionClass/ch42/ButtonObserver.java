package org.example.LionClass.ch42;

import java.util.ArrayList;
import java.util.List;

public class ButtonObserver {

    public static void main(String[] args) {

        View aButton = new Button();
        aButton.addOnClickListener((msg)-> System.out.println("홍길동이 받은 메세지 : " + msg));
        aButton.addOnClickListener((msg)-> System.out.println("홍길순이 받은 메세지 : " + msg));
        aButton.fireClickEvent();
        aButton.fireClickEvent();
    }

}
class View {
    List<OnClickListener> onClickListenerList;

    View(){
        onClickListenerList=new ArrayList<>();
    }

    public void addOnClickListener(OnClickListener onClickListener) {
        this.onClickListenerList.add(onClickListener);
    }

    public void fireClickEvent(){
        System.out.println("뷰가 클릭되었습니다.");
        for(OnClickListener onClickListener : onClickListenerList)
            onClickListener.onClick("클릭");
    }

}

class Button extends View {

}

interface OnClickListener {
    public void onClick(String msg);
}

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
