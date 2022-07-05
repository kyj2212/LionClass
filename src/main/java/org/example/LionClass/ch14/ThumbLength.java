package org.example.LionClass.ch14;

// 문제 : 아래와 같이 출력 되도록 해주세요.
// 조건 : 생성자를 단 1개만 사용해주세요.


class ThumbLength {
    public static void main(String[] args) {
        int lenThumb = new Human().left.h.thumb.len;
        int rightThumb = new Human().right.h.thumb.len;

        System.out.println(lenThumb + "cm");
        // 출력 : 5cm
    }
}

class Human {
    Arm left;
    Arm right;

    Human() {
        this.left=new Arm();
        this.right=new Arm();
    }
}

class Arm {
    Hand h;

    Arm() {
        this.h=new Hand();
    }
}

class Hand {

    Finger thumb;

    Hand() {
        thumb = new Finger(5);
    }
}

class Finger {
    int len;
    Finger(int len){
        this.len=len;
    }
}



