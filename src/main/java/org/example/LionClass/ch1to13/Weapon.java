package org.example.LionClass.ch1to13;

public class Weapon {

    public String name;
    public int damage;
    public int durability;

    public String type = "무기";

    public Weapon() {
        this("주먹", 10, 100);
    }

    Weapon(String name, int damage, int durability) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }

    void attack() {
        this.durability -= 10;
        System.out.println(this.name + "으로 " + this.damage + " 공격합니다. (내구도 : " + this.durability + ")");
    }

    public String toString() {
        return this.name;
    }
}


class Fight {
    public static void main(String[] args) {

        // 다형성 : 참조변수와 인스턴스의 연결, 참조변수를 통해 인스턴스를 가져올때 , 부모클래스의 인스턴스 변수값을 보존하고 싶을 때
        Weapon w1 = new Nife();
        w1.attack();
        System.out.println("w1 의 type은 + "+ w1.type);
        // 출력 : 칼로 공격합니다.

        Nife w2 = new Nife("큰칼",200,50);
        w2.attack();
        System.out.println("w2 의 type은 + "+w2.type);

        // 매개변수의 다형성
        System.out.println();
        Fighter f1 = new Fighter();

        // f1.fight((Weapon)w2);
        f1.buy(w2);
        // Weapon w = new Nife("작은칼",50,100);
        f1.buy(new Nife("작은칼",50,100));


        // 다형성 : 여러 종류의 객체를 배열로 다루기
        Weapon [] arr = new Weapon[3];
        arr[0]=new Nife();
        arr[1]=new Bow();
        arr[2]=new Bow("석궁",200,300);

        System.out.println();
        for(Weapon w : arr)
            f1.buy(w);

        System.out.println("====== 2020.06.30 =====");
        Fighter f2 = new Fighter("전사1",20);
        Fighter f3 = new Fighter("전사2",50);
        Fighter f4 = new Fighter("전사3",600);

        //  f2.attack();
        //  f3.attack();
        //  f4.attack();
        //  f4.attack();

        System.out.println("=== 문제 1 ===");
        Fighter a1 = new Fighter("칸",100);
        a1.power++;
        a1.introduce();

        a1.power=200;
        a1.name = "카나";
        a1.introduce();

        a1.w = new Bow();
        a1.attack();

        a1.w = new Nife();
        a1.attack();

    }


}

class Fighter {
    String name;
    int power;
    Weapon w;

    Fighter(){
        this("예진",0);
    }
    Fighter(String name,int power){
        this.name=name;
        this.power=power;
        this.introduce();
    }

    void introduce(){
        System.out.println(this.name+"(이)는 총 power : "+this.power+" 입니다.");
    }
    void getPower(){
        System.out.println("power : "+this.power);
    }
    void attack(){
        System.out.println(this.name+"(이)가 "+this.w.name+"으로 공격합니다.");
    }
    void buy(Weapon w){
        this.power+=w.damage;
        System.out.println(w.name+"을 구입하였습니다. "+this.name+"의 power : "+power);
    }
}
