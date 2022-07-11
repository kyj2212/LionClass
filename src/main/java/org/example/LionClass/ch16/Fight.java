package org.example.LionClass.ch16;

abstract class Weapon {
    String name;int damage;
    Weapon(int damage) {
        this.name = this.getClass().getSimpleName();
        this.damage = damage;
    }
    void use(){
        System.out.println(this.name+"(으)로 공격합니다.");
        System.out.println("데미지 : "+this.damage);
    }
}

class DefaultWeapon extends Weapon{
    DefaultWeapon(){this(1);};
    DefaultWeapon(int damage){super(damage);};
}

class Sword extends Weapon {
    Sword(){this(78);}
    Sword(int damage) {super(damage);}
}


class Spear extends Weapon {
    Spear(){this(80);}
    Spear(int damage) {super(damage);}
}

class Wand extends Weapon {
    Wand(){this(12);}
    Wand(int damage) {super(damage);}
}

abstract class Fighter {
    String name;
    int power;
    Weapon w;

    Fighter(){this(100);}
    Fighter(int power){
        this.name=getClassName();
        this.power=power;
        //this.introduce();
    }

    void changeWeapon(Weapon w){this.w=w;}

    void attack() {
        System.out.printf(this.name+"(이)가 ");
        this.w.use();
    }

    String getClassName(){
        return this.getClass().getSimpleName();
    }

    void introduce(){
        System.out.println(this.name+"(이)는 총 power : "+this.power+" 입니다.");
    }
    void setPower(){
        this.power=this.power+this.w.damage;
        introduce();
    }
    void buy(Weapon w){
        this.power+=w.damage;
        System.out.println(w.name+"을 구입하였습니다. "+this.name+"의 power : "+power);
    }
}

class SwordFighter extends Fighter{

    SwordFighter() {
        super(); // 생략가능 자동생성자 super() 가 실행된다.
        this.w=new Sword();
        setPower();
    }
}

class SpearFighter extends Fighter{ SpearFighter(){this.w=new Spear();setPower();}}
class WandFighter extends Fighter{ WandFighter(){this.w=new Wand();setPower();}}
class DefaultFighter extends Fighter{ DefaultFighter(){this.w=new DefaultWeapon();setPower();}}



class Fight {
    public static void main(String[] args) {

   //     Fighter f1 = new Fighter("예진",100, new Sword());

   //     f1.attack();

   //     f1.changeWeapon(new Spear());
   //     f1.attack();

   //     f1.changeWeapon(new Wand());
   //     f1.attack();


        System.out.println("=== 구성 사용 === ");

        SwordFighter a = new SwordFighter();
        a.attack();
        SpearFighter b = new SpearFighter();
        b.attack();
        WandFighter c = new WandFighter();
        c.attack();
        DefaultFighter d = new DefaultFighter();
        d.attack();


    }

}

