package org.example.LionClass.ch39;


public class FactoryMethod {


    public static void main(String[] args) {
        
        Duck blue = DuckFactory.get("청둥");
        Duck white = DuckFactory.get("흰");
        Duck rubber = DuckFactory.get("고무");
        Duck rubber2 = DuckFactory.get("고무2");
        Duck robot = DuckFactory.get("로봇");
        

        blue.fly();
        // 출력 : 청둥오리 : 날개로 날아갑니다.
        blue.cry();
        // 출력 : 청둥오리 : 꽥꽥!!

        white.fly();
        // 출력 : 흰오리 : 날개로 날아갑니다.
        white.cry();
        // 출력 : 흰오리 : 꽥꽥!!

        rubber.fly();
        // 출력 : 고무오리 : 저는 날 수 없어요. ㅠㅠ
        rubber.cry();
        // 출력 : 고무오리 : 삑!삑!

        rubber2.fly();
        // 출력 : 고무오리 : 저는 날 수 없어요. ㅠㅠ
        rubber2.cry();
        // 출력 : 고무오리 : Peek!Peek!

        robot.fly();
        // 출력 : 로봇오리 : 로켓파워로 날아갑니다!!
        robot.cry();
        // 출력 : 로봇오리 : 기계는 울 수 없습니다.

        rubber2.setFlyingItem(new RocketFlyingItem());
        rubber2.fly();
        // 출력 : 고무오리 : 로켓파워로 날아갑니다!!
    }
    
}

class DuckFactory {
    static Duck get(String duckType){
        if(duckType=="청둥")
            return new MallardDuck();
        else if(duckType=="흰")
            return new WhiteDuck();
        else if(duckType=="고무")
            return new RubberDuck();
        else if(duckType=="고무2")
            return new RubberDuck2();
        else if(duckType=="로봇")
            return new RobotDuck();
        else return new Duck();
    }
}


abstract class FlyingItem { abstract void operate(String name);}
class WingFlyingItem extends FlyingItem { void operate(String name) {System.out.println(name+" : 오리가 날개로 날아갑니다.");}}
class NoFlyingItem extends FlyingItem { void operate(String name) {System.out.println(name+" : 저는 날 수 없어요. ㅜㅠ");}}
class RocketFlyingItem extends FlyingItem { void operate(String name){System.out.println(name+" : 로켓파워로 날아갑니다.");}}


class Duck {
    String name;
    FlyingItem flyingItem;

    Duck(){
        this(new WingFlyingItem());
    }
    Duck(FlyingItem flyingItem){
        this.name=getClass().getSimpleName();
        this.flyingItem=flyingItem;
    }

    void fly(){
        flyingItem.operate(this.name);
    }

    public void cry() {
        System.out.println(this.name+ " : 꽥꽥!!");
    }

    public void setFlyingItem(FlyingItem flyingItem) {
        this.flyingItem=flyingItem;
    }
}

class MallardDuck extends Duck { }

class WhiteDuck extends Duck { }

class RubberDuck extends Duck {
    RubberDuck(){super(new NoFlyingItem());}
    @Override
    public void cry() {System.out.println(this.name+ " : 삑!삑!");}
}

class RubberDuck2 extends RubberDuck {

    @Override
    public void cry() {System.out.println(this.name+ " : Peek!Peek!");}
}


class RobotDuck extends Duck {

    RobotDuck(){super(new RocketFlyingItem());}
    @Override
    public void cry() {System.out.println(this.name+" : 기계는 울 수 없습니다.");}
}



