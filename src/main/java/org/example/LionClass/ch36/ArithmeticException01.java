package org.example.LionClass.ch36;

public class ArithmeticException01 {


    static class Main{
        public static void main(String[] args) {
            int rs = Calculater.divide(10, 0);
            System.out.println(rs);
        }
    }
    private class Calculater {
        static int divide(int a, int b) {
            int rs = 0;
            try{
                rs=a/b;
            }catch (ArithmeticException e){
                rs=0;
                System.out.println("can't divde 0");
            }
            return rs;
        }
    }
}


