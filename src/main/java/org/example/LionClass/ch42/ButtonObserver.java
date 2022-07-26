package org.example.LionClass.ch42;

import java.util.ArrayList;
import java.util.List;

public class ButtonObserver {


    // 이번 작업 : 구독자 => OnClickListener 로 용어 변경
    // OnClickListener => 클릭 구독자
    // 클릭 구독자 => 누군가가 클릭되었다는 사실을 관찰하는 객체
    // 클릭 구독자 => 누군가가 클릭되었다면, 그 즉시 그 사실을 전달받고 싶어하는 객체
    public static void main(String[] args) {
        View aButton = new Button();
        // 홍길동 : 내가 너(뷰, 버튼)한테 나의 리모콘을 줄테니까, 너가 그것을 잘 가지고 있다가, 너가 클릭이 되면, 내 리모콘에 있는 버튼 중 하나를 눌러줘
        // 홍길동 : 나의 리모콘에는 버튼이 2개 있는데, 그 중에서 onClick을 호출해야 되는데.. 너가 그걸 잘 처리할 수 있을까?
        // 뷰 : 그건 걱정하지 않아도 됩니다. 당신이 나에게 준 홍길동 리모콘은, 어차피 onClick 버튼 빼고 모든 버튼이 제거됩니다. 즉 리모콘 형변환이 일어납니다.
        // 뷰 : 대신 당신 해야할 일은, OnClickEventListen가 되어야 한다는 것 입나다.
        // 홍길동 : 그럴줄 알고 그것(OnClickEventListen) 구현했습니다.
        aButton.addOnClickListener(new HongBoy());
        aButton.addOnClickListener(new HongGirl());
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

class HongBoy implements OnClickListener {
    @Override
    public void onClick(String msg) {
        System.out.println("홍길동이 받은 메세지 : " + msg);
    }

    public void breath() {
        System.out.println("홍길동 : 숨쉬다.");
    }
}

class HongGirl implements OnClickListener {
    @Override
    public void onClick(String msg) {
        System.out.println("홍길순이 받은 메세지 : " + msg);
    }
}