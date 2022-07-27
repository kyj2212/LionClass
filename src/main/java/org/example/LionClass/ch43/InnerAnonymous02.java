package org.example.LionClass.ch43;



class InnerAnonymous02 {

    public static void main(String[] args) {
        Activity activity = new MainActivity();
        activity.onCreate();
        // 출력 => 메인 액티비티가 실행되었습니다.
    }


}
abstract class Activity {
    abstract void onCreate();
}

class MainActivity extends Activity {


    @Override
    void onCreate() {
        System.out.println("메인 액티비티가 실행되었습니다.");
        // 아래 코드가 실행되도록 해주세요.
        View.OnClickListener a = new Apple();
        View aButton = new Button(this);
        aButton.setOnClickListener(a);

        aButton.fireClickEvent();
        // 출력 : 사과는 버튼이 클릭되었다는 사실을 방금 알았습니다.!
        // 조건 : 위 문구는 사과 클래스 안의 메서드에 의해서 출력되어야 합니다.
    }
}

class  Apple implements View.OnClickListener {

}
class Button extends View {

    public Button(MainActivity mainActivity){

    }
/*    @Override
    public void setOnClickListener(OnClickListener listener){

    }*/

}
abstract class View {


    public void setOnClickListener(OnClickListener listener){

    }

    public void fireClickEvent() {
    }

    // abstract public void setOnClickListener(OnClickListener listener);

    public static interface OnClickListener {

    }

}

