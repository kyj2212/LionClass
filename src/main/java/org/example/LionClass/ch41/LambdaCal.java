package org.example.LionClass.ch41;

public class LambdaCal {
    public static void main(String[] args) {
        Cal cal = new Cal();
        cal.num1 = 10;
        cal.num2 = 20;

        int r1 = cal.run((a,b)->a+b);
        System.out.println(r1); // 30

        int r2=cal.run((a,b)->a-b);
        System.out.println(r2); // -10

        int r3 = cal.run((a,b)->a*b);
        System.out.println(r3); // 300
    }
}
class Cal {
    int num1;
    int num2;

    int run(Expression e) {
        return e.run(num1, num2);
    }
}

interface Expression {
    public int run(int num1, int num2);
}