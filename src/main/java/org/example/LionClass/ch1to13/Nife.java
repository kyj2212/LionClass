package org.example.LionClass.ch1to13;

import org.example.LionClass.ch1to13.Weapon;

public class Nife extends Weapon {

    public String type = "칼";

    public int sharpness;


    public Nife() {this("기본칼", 100, 500);}

    public Nife(String name){this.name=name;}
    Nife(String name, int damage, int durability) {
        super(name, damage, durability);
    }

    void attack() {
        this.durability -= 20; // 총 -30
        super.attack();
    }
}
