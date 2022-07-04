package org.example.LionClass;

abstract class Food { String foodName;}

class ChineeseFood extends Food{
    String spicy;
    ChineeseFood(String foodname, String spicy){
        this.foodName=foodname;
        this.spicy=spicy;
    }
}
class Snack extends Food {
    String size;
    Snack(String foodname, String size){
        this.foodName=foodname;
        this.size=size;
    }
}

abstract class Restaurant { String storeName; abstract void deliver(Human h);}

class ChineeseRestaurant extends Restaurant{

    ChineeseFood likefood;

    ChineeseRestaurant(String storeName, ChineeseFood likefood){
        this.storeName = storeName;
        this.likefood = likefood;
    }

    @Override
    void deliver(Human h) {
        System.out.println(this.storeName+"에서 "+h.name+"("+h.phone+") 에게 "
                + this.likefood.spicy+ " "+this.likefood.foodName+"(을)를 배달합니다." );
    }
}

class SnackBar extends Restaurant{
    Snack likefood;

    SnackBar(String storeName, Snack likefood){
        this.storeName=storeName;
        this.likefood=likefood;
    }
    @Override
    void deliver(Human h) {
        System.out.println(this.storeName+"에서 "+h.name+"("+h.phone+") 에게 "
                + this.likefood.size+ " "+this.likefood.foodName+"(을)를 배달합니다." );
    }
}


class Human {
    Restaurant likeStore;
    String name,phone;
    Food likeFood;

    Human(String name,String phone, Restaurant likeStore){
        this.name=name;
        this.phone=name;
        this.likeStore=likeStore;
    }
    void order(){
        likeStore.deliver(this);
    }
}

// 상속 ~~은 ~~ 이다
// 사람은 좋아하는 음식을 가지고 있다. 포함.

public class PreferredFood {


    public static void main(String[] args) {

        Human a = new Human("김철수","010-1234-1234",new ChineeseRestaurant("영화반점", new ChineeseFood("짬뽕","매운")));
        Human b = new Human("김영희","010-4321-4321",new ChineeseRestaurant("북경반점", new ChineeseFood("짬뽕","안매운")));

        a.order();
        b.order();

        b.likeStore=a.likeStore;
        b.likeFood=new ChineeseFood("짜장","아주 매운");
        b.order();

        a.likeStore=new SnackBar("서브웨이",new Snack("샌드위치", "작은"));
        a.order();

    }

}
