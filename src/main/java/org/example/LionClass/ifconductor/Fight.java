package org.example.LionClass.ifconductor;

import org.example.LionClass.ch1to13.Bow;
import org.example.LionClass.ch1to13.Nife;
import org.example.LionClass.ch1to13.Weapon;

class Fighter {
    String name;
    Weapon right;
    Weapon left;

    Fighter(){
        this.name="전사"+((char)('a'+(int)(Math.random()*10)));
    }

    Fighter(String name, Weapon right, Weapon left){
        this.name =name;
        this.right=right;
        this.left=left;
    }

    void attack(){
        if(this.right==null&&this.left==null)
            System.out.println("아직 무기가 없습니다.");
        else if(this.left==null) {
            System.out.println(this.name+"(이)가 오른손으로 "+right.name+"(을)를 사용해 공격합니다.");
        }
        else if(this.right==null) {
            System.out.println(this.name+"(이)가 왼손으로 "+left.name+"(을)를 사용해 공격합니다.");
        }
        else
            System.out.println(this.name+"(이)가 왼손으로 "+left.name+"(을)를, " +
                    "오른손으로 "+right.name+"(을)를 사용해 공격합니다.");
    }
}


public class Fight {
    public static void main(String[] args) {
        Fighter a = new Fighter();
        a.attack();

        a.left=new Nife();
        a.attack();

        Fighter b = new Fighter("전사b",new Bow("석궁"),new Nife("긴칼"));
        b.attack();

    }
}
