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

    // abstract public void setOnClickListener(OnClickListener listener);

    public static interface OnClickListener {

    }

}

