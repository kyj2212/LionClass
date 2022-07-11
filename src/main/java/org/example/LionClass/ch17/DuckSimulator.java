package org.example.LionClass.ch17;


/* 가정
우리는 게임개발회사에 입사했다.
우리에게는 성격좋은 사수 한명이 있다.
내가 개발할 게임은 오리시뮬레이션 게임이다.
선임이 나의 개발을 도와주진 않지만 조언은 해준다.
*/

/* 요구사항
- D1 요구 : 오리를 생성하고 날게하시오.
- D1 완료 : 클래스와 메서드를 만들어서 처리
- D2 요구 : 게임의 디테일을 살리기 위해서 `청둥오리`와 `흰오리`를 생성하고 날게하시오.
- D2 완료 : 클래스와 메서드를 만들어서 처리
- D3 요구 : 오리 계열의 클래스에 날다 메서드가 중복되었습니다. 중복을 제거해주세요.
- D3 완료 : 상속을 사용해서 처리
- D4 요구 : 게임의 재미를 위하여 고무오리를 추가하고 날게 하시오.
- D4 완료 : 클래스와 메서드를 만들어서 처리
- D5 요구 : 주말 주주회의에서 고무오리가 하늘을 날아다니는 것에 대해서 태클이 들어왔습니다. 고무오리 계열은 하늘을 날 수 없게 해주세요.
- D5 완료 : 메서드 오버라이드를 사용해서 처리
- D6 요구 : 고무오리가 반응이 좋습니다. 고무2오리를 추가하고 날게 해주세요.
- D6 완료 : 고무오리가 반응이 좋습니다. 고무2오리를 추가하고 날게 해주세요.
- D7 요구 : 고무오리계열에서 날다 메서드의 중복을 제거해주세요.
- D7 완료 : 상속으로 해결
- D8 요구 : 상속에는 한계가 있습니다. 상속을 사용하지 않고 고무오리계열의 중복을 제거해주세요.
- D8 요구 : 자바에서 다중상속은 불가능 합니다. 상속에는 한계가 있습니다. 상속을 사용하지 않고 고무오리계열의 중복을 제거해주세요.
- D8 완료 : 상속이 아닌 구성을 써서 해결

- D9 요구 : 현질기능을 추가한다. 로켓비행아이템을 추가하세요.
*/





abstract class Duck { FlyingItem f1; Duck() {f1 = new WingFlyingItem();} void fly() {f1.operate();}}
class WhiteDuck extends Duck { }
class BlueDuck extends Duck { }
class RubberDuck extends Duck { RubberDuck() {f1 = new NoFlyingItem();}}
class NewRubberDuck extends Duck { NewRubberDuck() {f1 = new NoFlyingItem();}}


abstract class FlyingItem { abstract void operate();}
class WingFlyingItem extends FlyingItem { void operate() {System.out.println("오리가 날개로 날아갑니다.");}}
class NoFlyingItem extends FlyingItem { void operate() {System.out.println("저는 날 수 없어요. ㅜㅠ");}}
class RocketFlyingItem extends FlyingItem{ void operate(){System.out.println("로켓파워로 날아갑니다.");}}



public class DuckSimulator {

    public static void main(String[] args) {

        BlueDuck bd = new BlueDuck();
        bd.fly();
        // 출력 : 오리가 날개로 날아갑니다.

        WhiteDuck wd = new WhiteDuck();
        wd.fly();
        // 출력 : 오리가 날개로 날아갑니다.

        RubberDuck rd = new RubberDuck();
        rd.fly();
        // 출력 : 저는 날 수 없어요. ㅜㅠ

        NewRubberDuck nrd = new NewRubberDuck();
        nrd.fly();
        // 출력 : 저는 날 수 없어요. ㅜㅠ

        nrd.f1 = new RocketFlyingItem();
        nrd.fly();
        // 출력 : 로켓파워로 날아갑니다.

    }


}
