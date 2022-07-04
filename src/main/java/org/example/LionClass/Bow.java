package org.example.LionClass;

public class Bow extends Weapon {

    public String type = "활";

    public Bow() {
        this("기본활", 70, 200);
    }
    public Bow(String name){this.name=name;}

    Bow(String name, int damage, int durability) {
        super(name, damage, durability);
    }

    void attack() {
        this.durability -= 30; // 총 -40
        super.attack();
    }
}
