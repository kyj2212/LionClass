package org.example.LionClass.ch39;


import javax.swing.*;

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
        Duck duck=Duck.getDuck(duckType);
        if(duckType.equals("청둥")){
            duck.setCryingItem(new QqCyringItem());
            duck.setFlyingItem(new WingFlyingItem());
        }else if(duckType.equals("흰")){
            duck.setCryingItem(new QqCyringItem());
            duck.setFlyingItem(new WingFlyingItem());
        }else if(duckType.equals("고무")){
            duck.setCryingItem(new FfCyringItem());
            duck.setFlyingItem(new NoFlyingItem());
        }else if(duckType.equals("고무2")){
            duck.setCryingItem(new PpCryingItem());
            duck.setFlyingItem(new NoFlyingItem());
        }else if(duckType.equals("로봇")){
            duck.setCryingItem(new NoCryingItem());
            duck.setFlyingItem(new RocketFlyingItem());
        }
        return duck;
    }
}


abstract class FlyingItem { abstract void operate(String duckType);}
class WingFlyingItem extends FlyingItem { void operate(String duckType) {System.out.println(duckType+" : 오리가 날개로 날아갑니다.");}}
class NoFlyingItem extends FlyingItem { void operate(String duckType) {System.out.println(duckType+" : 저는 날 수 없어요. ㅜㅠ");}}
class RocketFlyingItem extends FlyingItem { void operate(String duckType){System.out.println(duckType+" : 로켓파워로 날아갑니다.");}}

abstract class CryingItem { abstract void operate(String duckType);}
class QqCyringItem extends CryingItem { void operate(String duckType) {System.out.println(duckType+" : 꽥꽥!");}}
class FfCyringItem extends CryingItem { void operate(String duckType) {System.out.println(duckType+" : 삑삑!");}}
class PpCryingItem extends CryingItem { void operate(String duckType) {System.out.println(duckType+" : Peek Peek!");}}
class NoCryingItem extends CryingItem { void operate(String duckType){System.out.println(duckType+" : 기계는 울 수 없습니다.");}}




class Duck {
    String duckType;
    private FlyingItem flyingItem;
    private CryingItem cryingItem;


    private Duck(String duckType){
        this.duckType=duckType;
       // this(new WingFlyingItem(),new QqCyringItemItem());
    }

    public static Duck getDuck(String duckType){
        return new Duck(duckType);
    }

    /*
    private Duck(FlyingItem flyingItem, CryingItem cryingItem){
        this.name=getClass().getSimpleName();
        this.flyingItem=flyingItem;
        this.cryingItem=cryingItem;
    }
     */

    public void fly(){
        flyingItem.operate(duckType);
    }

    public void cry() {
        cryingItem.operate(duckType);
    }

    public void setFlyingItem(FlyingItem flyingItem) {
        this.flyingItem=flyingItem;
    }

    public void setCryingItem(CryingItem cryingItem) {this.cryingItem = cryingItem;}
}


